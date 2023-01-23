package its.statea.webserver.db.repository;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.PredictionMonth;
import its.statea.webserver.db.entity.composite.PredictionMonthKey;

public interface PredictionMonthRepository extends JpaRepository<PredictionMonth, PredictionMonthKey> {
    
    @Query( "SELECT pm FROM PredictionMonth pm WHERE "
            + "((pm.origin.id = :originId) OR (:originId = 'ANY'))"
            + "AND "
            + "((pm.destination.id = :destinationId) OR (:destinationId = 'ANY'))"
            + "AND "
            + "(pm.accommodationType.id = 'ALL') "
            + "AND "
            + "(pm.observationType.id = :observationTypeId) "
            + "AND "
            + "(pm.date >= :startDate) "
            + "AND "
            + "(pm.date <= :endDate)")
    Stream<PredictionMonth> findAllCustom(String originId, String destinationId, String observationTypeId, Date startDate, Date endDate, Sort sortInfo);

    @Query("SELECT MIN(pm.date) FROM PredictionMonth pm")
    Optional<Date> findMinDate();

    @Query("SELECT MAX(pm.date) FROM PredictionMonth pm")
    Optional<Date> findMaxDate();
}
