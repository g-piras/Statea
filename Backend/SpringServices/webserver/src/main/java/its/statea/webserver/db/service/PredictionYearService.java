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

import its.statea.webserver.db.entity.PredictionYear;
import its.statea.webserver.db.entity.composite.PredictionYearKey;
import its.statea.webserver.db.repository.PredictionYearRepository;
import its.statea.webserver.helper.datamap.YearRecordDatamap;
import its.statea.webserver.helper.datamap.YearsRangeDatamap;

@Service
@Transactional
public class PredictionYearService {
    
    @Autowired private PredictionYearRepository predictionYearRepository;

    public Optional<PredictionYear> fetchById(PredictionYearKey predictionYearKey) {

        return predictionYearRepository.findById(predictionYearKey);
    }

    public <T extends YearRecordDatamap> List<T> fetchPredictionYearList(String originId, String destinationId, String observationTypeId, String startYear, String endYear, String sortField, Boolean ascendingOrder, Function<YearRecordDatamap, ? extends T> dataMapper) {

        try (Stream<PredictionYear> predictionYearStream = predictionYearRepository.findAllCustom(originId, destinationId, observationTypeId, Year.parse(startYear), Year.parse(endYear), Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
            
            return predictionYearStream.map(dataMapper).collect(Collectors.toList());
        }
    }

    public <T extends YearsRangeDatamap> T fetchYearsRange(BiFunction<Year, Year, ? extends T> dataMapper) {

        Year start = predictionYearRepository.findMinYear().orElse(null); 
        Year end = predictionYearRepository.findMaxYear().orElse(null);
        
        if ((start == null) || (end == null)) {

            return null;
        }

        return dataMapper.apply(start, end);
    }
}
