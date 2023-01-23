package its.statea.webserver.db.repository;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.ObservationMonthCustomView;
import its.statea.webserver.db.entity.composite.ObservationMonthKey;

public interface ObservationMonthCustomViewRepository extends JpaRepository<ObservationMonthCustomView, ObservationMonthKey> {
    
    @Query( "SELECT om FROM ObservationMonthCustomView om WHERE "
            + "((om.origin.id = :originId) OR (:originId = 'ANY'))"
            + "AND "
            + "((om.destination.id = :destinationId) OR (:destinationId = 'ANY'))"
            + "AND "
            + "(om.accommodationType.id = 'ALL') "
            + "AND "
            + "(om.observationType.id = :observationTypeId) "
            + "AND "
            + "(om.date >= :startDate) "
            + "AND "
            + "(om.date <= :endDate)")
    Stream<ObservationMonthCustomView> findAllCustom(String originId, String destinationId, String observationTypeId, Date startDate, Date endDate, Sort sortInfo);

    @Query("SELECT MIN(om.date) FROM ObservationMonthCustomView om")
    Optional<Date> findMinDate();

    @Query("SELECT MAX(om.date) FROM ObservationMonthCustomView om")
    Optional<Date> findMaxDate();
}
