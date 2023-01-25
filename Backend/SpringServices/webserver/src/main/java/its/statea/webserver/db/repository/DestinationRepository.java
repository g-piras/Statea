package its.statea.webserver.db.repository;

import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination, String> {

    @Query("select d from Destination d")
    public Stream<Destination> findAllStream(Sort sortInfo);
    public Stream<Destination> findByIsAggregate(Boolean isAggregate, Sort sortInfo);
}
