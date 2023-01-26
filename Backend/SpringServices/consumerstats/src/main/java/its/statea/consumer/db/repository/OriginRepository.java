package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.Origin;

public interface OriginRepository extends JpaRepository<Origin, String> {
    
}
