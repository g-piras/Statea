package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.ObservationMonth;
import its.statea.consumer.db.entity.composite.ObservationMonthKey;

public interface ObservationMonthRepository extends JpaRepository<ObservationMonth, ObservationMonthKey> {
    
}
