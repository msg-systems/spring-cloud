package de.msg.repository;

import de.msg.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * An simple {@link JpaRepository} to persist {@link ServiceCenter} data.
 */
@RepositoryRestResource
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {
}
