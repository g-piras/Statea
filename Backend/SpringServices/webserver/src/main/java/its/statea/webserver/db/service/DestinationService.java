package its.statea.webserver.db.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.webserver.db.entity.Destination;
import its.statea.webserver.db.repository.DestinationRepository;
import its.statea.webserver.helper.datamap.DestinationDatamap;

@Service
@Transactional
public class DestinationService {
    
    @Autowired private DestinationRepository destinationRepository;

    public <T extends DestinationDatamap> Optional<T> fetchById(String id, Function<DestinationDatamap, ? extends T> dataMapper) {

        Optional<Destination> tmpRes = destinationRepository.findById(id);

        if (tmpRes.isEmpty()) {

            return Optional.ofNullable(null);
        }

        return Optional.of(dataMapper.apply(tmpRes.get()));
    }

    public boolean exists(String id) {

        return destinationRepository.existsById(id);
    }

    public <T extends DestinationDatamap> List<T> fetchDestinationList(Boolean isAggregate, String sortField, Boolean ascendingOrder, Function<DestinationDatamap, ? extends T> dataMapper) {

        // BOTH aggregates AND non-aggregates
        if (isAggregate == null) {

            try (Stream<Destination> destinationStream = destinationRepository.findAllStream(Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
                
                return destinationStream.map(dataMapper).collect(Collectors.toList());
            }
        }
        // EITHER aggregates OR non-aggregates
        else {

            try (Stream<Destination> destinationStream = destinationRepository.findByIsAggregate(isAggregate, Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
                
                return destinationStream.map(dataMapper).collect(Collectors.toList());
            }
        }
    }
}
