package its.statea.webserver.db.service;

import java.sql.Date;
import java.time.LocalDate;
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

import its.statea.webserver.db.entity.PredictionMonth;
import its.statea.webserver.db.entity.composite.PredictionMonthKey;
import its.statea.webserver.db.repository.PredictionMonthRepository;
import its.statea.webserver.helper.datamap.DatesRangeDatamap;
import its.statea.webserver.helper.datamap.MonthRecordDatamap;

@Service
@Transactional
public class PredictionMonthService {
    
    @Autowired private PredictionMonthRepository predictionMonthRepository;

    public Optional<PredictionMonth> fetchById(PredictionMonthKey predictionMonthKey) {

        return predictionMonthRepository.findById(predictionMonthKey);
    }

    public <T extends MonthRecordDatamap> List<T> fetchPredictionMonthList(String originId, String destinationId, String observationTypeId, LocalDate startDate, LocalDate endDate, String sortField, Boolean ascendingOrder, Function<MonthRecordDatamap, ? extends T> dataMapper) {

        try (Stream<PredictionMonth> predictionMonthStream = predictionMonthRepository.findAllCustom(originId, destinationId, observationTypeId, Date.valueOf(startDate), Date.valueOf(endDate), Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
            
            return predictionMonthStream.map(dataMapper).collect(Collectors.toList());
        }
    }

    public <T extends DatesRangeDatamap> T fetchDatesRange(BiFunction<LocalDate, LocalDate, ? extends T> dataMapper) {

        Date start = predictionMonthRepository.findMinDate().orElse(null); 
        Date end = predictionMonthRepository.findMaxDate().orElse(null);
        
        if ((start == null) || (end == null)) {

            return null;
        }

        return dataMapper.apply(start.toLocalDate(), end.toLocalDate());
    }
}
