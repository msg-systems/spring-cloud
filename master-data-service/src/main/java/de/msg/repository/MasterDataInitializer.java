package de.msg.repository;

import de.msg.model.Customer;
import de.msg.model.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Initializes sample {@link Customer} data.
 */
@Component
public class MasterDataInitializer {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private CustomerRepository customerRepository;
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private ServiceCenterRepository serviceCenterRepository;

    @PostConstruct
    public void generateTestData() {
        if (customerRepository.findByCar(1) == null) {
            customerRepository.save(new Customer("Max", "Miller", 1, "max.miller@email.com"));
        }
        if (customerRepository.findByCar(2) == null) {
            customerRepository.save(new Customer("John", "Smith", 2, "john.smith@email.com"));
        }


        if (serviceCenterRepository.findOne(1L) == null) {
            serviceCenterRepository.save(new ServiceCenter("BMW Service Center", "service@bmw.de"));
        }
        if (serviceCenterRepository.findOne(2L) == null) {
            serviceCenterRepository.save(new ServiceCenter("Mercedes Benz Service Center", "service@mercedes-benz.de"));
        }
        if (serviceCenterRepository.findOne(3L) == null) {
            serviceCenterRepository.save(new ServiceCenter("Audi Service Center", "service@audi.de"));
        }
        if (serviceCenterRepository.findOne(4L) == null) {
            serviceCenterRepository.save(new ServiceCenter("Volkswagen Service Center", "service@volkswagen.de"));
        }
        if (serviceCenterRepository.findOne(5L) == null) {
            serviceCenterRepository.save(new ServiceCenter("Porsche Service Center", "service@porsche.de"));
        }
        if (serviceCenterRepository.findOne(6L) == null) {
            serviceCenterRepository.save(new ServiceCenter("Opel Service Center", "service@opel.de"));
        }
    }
}
