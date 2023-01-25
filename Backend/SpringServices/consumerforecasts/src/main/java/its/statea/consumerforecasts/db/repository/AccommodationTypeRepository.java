package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.AccommodationType;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, String> {
    
}
