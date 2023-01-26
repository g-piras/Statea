package its.statea.webserver.db.repository;

import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import its.statea.webserver.db.entity.Origin;

public interface OriginRepository extends JpaRepository<Origin, String> {
 
    @Query("select o from Origin o")
    public Stream<Origin> findAllStream(Sort sortInfo);
    public Stream<Origin> findByIsAggregate(Boolean isAggregate, Sort sortInfo);
}
