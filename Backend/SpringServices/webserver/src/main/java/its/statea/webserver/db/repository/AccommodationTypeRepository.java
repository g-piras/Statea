package its.statea.webserver.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.webserver.db.entity.AccommodationType;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, String> {
    
}
