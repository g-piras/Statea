package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination, String> {
    
}
