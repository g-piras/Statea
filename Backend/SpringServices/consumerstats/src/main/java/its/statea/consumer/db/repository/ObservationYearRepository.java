package its.statea.consumer.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumer.db.entity.ObservationYear;
import its.statea.consumer.db.entity.composite.ObservationYearKey;

public interface ObservationYearRepository extends JpaRepository<ObservationYear, ObservationYearKey> {
    
}
