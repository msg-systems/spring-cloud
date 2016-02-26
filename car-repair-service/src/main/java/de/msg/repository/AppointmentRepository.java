package de.msg.repository;

import de.msg.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * An simple {@link JpaRepository} to persist {@link Appointment} data.
 */
@RepositoryRestResource
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
