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

import its.statea.webserver.db.entity.Origin;
import its.statea.webserver.db.repository.OriginRepository;
import its.statea.webserver.helper.datamap.OriginDatamap;

@Service
@Transactional
public class OriginService {
    
    @Autowired private OriginRepository originRepository;

    public <T extends OriginDatamap> Optional<T> fetchById(String id, Function<OriginDatamap, ? extends T> dataMapper) {

        Optional<Origin> tmpRes = originRepository.findById(id);

        if (tmpRes.isEmpty()) {

            return Optional.ofNullable(null);
        }

        return Optional.of(dataMapper.apply(tmpRes.get()));
    }

    public boolean exists(String id) {

        return originRepository.existsById(id);
    }

    public <T extends OriginDatamap> List<T> fetchOriginList(Boolean isAggregate, String sortField, Boolean ascendingOrder, Function<OriginDatamap, ? extends T> dataMapper) {

        // BOTH aggregates AND non-aggregates
        if (isAggregate == null) {

            try (Stream<Origin> originStream = originRepository.findAllStream(Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
                
                return originStream.map(dataMapper).collect(Collectors.toList());
            }
        }
        // EITHER aggregates OR non-aggregates
        else {

            try (Stream<Origin> originStream = originRepository.findByIsAggregate(isAggregate, Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
                
                return originStream.map(dataMapper).collect(Collectors.toList());
            }
        }
    }
}