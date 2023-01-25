package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.AccommodationType;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, String> {
    
}
