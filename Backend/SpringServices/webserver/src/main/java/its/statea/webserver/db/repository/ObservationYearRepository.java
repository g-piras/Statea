package its.statea.webserver.db.repository;

import java.time.Year;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.ObservationYear;
import its.statea.webserver.db.entity.composite.ObservationYearKey;

public interface ObservationYearRepository extends JpaRepository<ObservationYear, ObservationYearKey> {
 
    @Query( "SELECT oy FROM ObservationYear oy WHERE "
            + "((oy.origin.id = :originId) OR (:originId = 'ANY')) "
            + "AND "
            + "((oy.destination.id = :destinationId) OR (:destinationId = 'ANY'))"
            + "AND "
            + "(oy.accommodationType.id = 'ALL') "
            + "AND "
            + "(oy.observationType.id = :observationTypeId) "
            + "AND "
            + "(oy.year >= :startYear) "
            + "AND "
            + "(oy.year <= :endYear)")
    Stream<ObservationYear> findAllCustom(String originId, String destinationId, String observationTypeId, Year startYear, Year endYear, Sort sortInfo);

    @Query("SELECT MIN(oy.year) FROM ObservationYear oy")
    Optional<Year> findMinYear();
    
    @Query("SELECT MAX(oy.year) FROM ObservationYear oy")
    Optional<Year> findMaxYear();
}
