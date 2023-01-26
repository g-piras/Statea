package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination, String> {
    
}
