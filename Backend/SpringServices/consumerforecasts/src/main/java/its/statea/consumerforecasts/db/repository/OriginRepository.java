package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.Origin;

public interface OriginRepository extends JpaRepository<Origin, String> {
    
}
