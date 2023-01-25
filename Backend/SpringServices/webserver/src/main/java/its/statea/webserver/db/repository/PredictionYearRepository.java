package its.statea.webserver.db.repository;

import java.time.Year;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.PredictionYear;
import its.statea.webserver.db.entity.composite.PredictionYearKey;

public interface PredictionYearRepository extends JpaRepository<PredictionYear, PredictionYearKey> {
    
    @Query( "SELECT py FROM PredictionYear py WHERE "
        + "((py.origin.id = :originId) OR (:originId = 'ANY')) "
        + "AND "
        + "((py.destination.id = :destinationId) OR (:destinationId = 'ANY'))"
        + "AND "
        + "(py.accommodationType.id = 'ALL') "
        + "AND "
        + "(py.observationType.id = :observationTypeId) "
        + "AND "
        + "(py.year >= :startYear) "
        + "AND "
        + "(py.year <= :endYear)")
    Stream<PredictionYear> findAllCustom(String originId, String destinationId, String observationTypeId, Year startYear, Year endYear, Sort sortInfo);

    @Query("SELECT MIN(py.year) FROM PredictionYear py")
    Optional<Year> findMinYear();

    @Query("SELECT MAX(py.year) FROM PredictionYear py")
    Optional<Year> findMaxYear();
}
