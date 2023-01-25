package its.statea.consumerforecasts.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import its.statea.consumerforecasts.db.entity.PredictionYear;
import its.statea.consumerforecasts.db.entity.composite.PredictionYearKey;

public interface PredictionYearRepository extends JpaRepository<PredictionYear, PredictionYearKey> {
    
}
