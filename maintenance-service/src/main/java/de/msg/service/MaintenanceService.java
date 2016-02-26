package de.msg.service;

import de.msg.model.Customer;
import de.msg.model.MaintenanceEvent;
import de.msg.model.SensorEvent;

import de.msg.repository.MaintenanceEventRepository;
import de.msg.web.AppointmentServiceClient;
import de.msg.web.DataCollectionServiceClient;
import de.msg.web.MasterDataCustomerServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The {@link MaintenanceService} evaluates if maintenance is required by examining a {@link SensorEvent} instance.
 * If the {@link SensorEvent} data indicates that a maintenance is needed an {@link MaintenanceEvent} is scheduled.
 * In more sophisticated scenarios you would use a configurable business rule engine, like Drools.
 * See <a href="http://www.drools.org/">http://www.drools.org</a>
 */
@Service
public class MaintenanceService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DataCollectionServiceClient dataCollectionServiceClient;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AppointmentServiceClient appointmentServiceClient;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MasterDataCustomerServiceClient masterDataCustomerServiceClient;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MaintenanceEventRepository repository;

    /**
     * Fetches all {@link SensorEvent} and evaluates if car maintenance is required.
     * If car maintenance is required a {@link MaintenanceEvent} is created.
     *
     * @param sensorEvent An {@link SensorEvent} with sensor data to evaluate.
     * @return true if an maintenance is required.
     */
    public boolean evaluateMaintenance(SensorEvent sensorEvent) {
        // Evaluates if car maintenance is required. In this particular example we schedule a {@link MaintenanceEvent} when
        // the brake pad width falls below 4mm.
        return (sensorEvent.getSensorName().equals("brake_pad_front_left") && Long.valueOf(sensorEvent.getSensorValue()) < 4L);
    }

    /**
     * Schedules an {@link MaintenanceEvent}
     *
     * @param event The {@link MaintenanceEvent} to schedule.
     */
    public void scheduleMaintenanceEvent(MaintenanceEvent event) {
        Set<PagedResources<Customer>> pagedCustomers = masterDataCustomerServiceClient.findByCar(event.getCar());
        Collection<Customer> customers = parseEmbeddedJsonResponse(pagedCustomers);
        Customer customer = getFirstElement(customers);
        if (customer == null) {
            customer = new Customer(999, "TestUser", "TestUSer", event.getCar(), "test@email.com");
        }
        event.setCustomer(customer);

        Set<PagedResources<SensorEvent>> pagedSensorEvents = dataCollectionServiceClient.findByCar(event.getCar());
        Collection<SensorEvent> events = parseEmbeddedJsonResponse(pagedSensorEvents);
        event.setSensorEvents(new HashSet<>(events));

        repository.save(event);
        appointmentServiceClient.scheduleMaintenanceEvent(event);
    }

    /**
     * Creates a {@link Collection<T>} of entities from a {@link Set<PagedResources>}
     */
    // TODO Figure out how consuming @RestRepository _embedded HAL-JSON Resources really works. This can not be state of the art.
    private static <T> Collection<T> parseEmbeddedJsonResponse(Set<PagedResources<T>> pagedResources) {
        Collection<T> result = new ArrayList<>();
        for (PagedResources<T> page : pagedResources) {
            result.addAll(page.getContent());
        }
        return result;
    }

    private static <T> T getFirstElement(Collection<T> collection) {
        if (!collection.isEmpty()) {
            return collection.iterator().next();
        } else {
            return null;
        }
    }
}
