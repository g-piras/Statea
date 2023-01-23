package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.ObservationType;

public interface ObservationTypeRepository extends JpaRepository<ObservationType, String> {
    
}
