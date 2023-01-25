package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.PredictionMonth;
import its.statea.consumerforecasts.db.entity.composite.PredictionMonthKey;

public interface PredictionMonthRepository extends JpaRepository<PredictionMonth, PredictionMonthKey> {
    
}
