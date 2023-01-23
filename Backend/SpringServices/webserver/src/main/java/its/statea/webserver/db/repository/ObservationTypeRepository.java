package its.statea.webserver.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.webserver.db.entity.ObservationType;

public interface ObservationTypeRepository extends JpaRepository<ObservationType, String> {
    
}
