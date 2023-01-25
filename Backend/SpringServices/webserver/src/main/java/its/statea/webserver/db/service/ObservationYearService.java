package its.statea.webserver.db.service;

import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.webserver.db.entity.ObservationYear;
import its.statea.webserver.db.entity.composite.ObservationYearKey;
import its.statea.webserver.db.repository.ObservationYearRepository;
import its.statea.webserver.helper.datamap.YearRecordDatamap;
import its.statea.webserver.helper.datamap.YearsRangeDatamap;

@Service
@Transactional
public class ObservationYearService {
    
    @Autowired private ObservationYearRepository observationYearRepository;

    public Optional<ObservationYear> fetchById(ObservationYearKey observationYearKey) {

        return observationYearRepository.findById(observationYearKey);
    }

    public <T extends YearRecordDatamap> List<T> fetchObservationYearList(String originId, String destinationId, String observationTypeId, String startYear, String endYear, String sortField, Boolean ascendingOrder, Function<YearRecordDatamap, ? extends T> dataMapper) {

        try (Stream<ObservationYear> observationYearStream = observationYearRepository.findAllCustom(originId, destinationId, observationTypeId, Year.parse(startYear), Year.parse(endYear), Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
            
            return observationYearStream.map(dataMapper).collect(Collectors.toList());
        }
    }

    public <T extends YearsRangeDatamap> T fetchYearsRange(BiFunction<Year, Year, ? extends T> dataMapper) {

        Year start = observationYearRepository.findMinYear().orElse(null); 
        Year end = observationYearRepository.findMaxYear().orElse(null);
        
        if ((start == null) || (end == null)) {

            return null;
        }

        return dataMapper.apply(start, end);
    }
}
