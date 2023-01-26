package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.ObservationType;

public interface ObservationTypeRepository extends JpaRepository<ObservationType, String> {
    
}
