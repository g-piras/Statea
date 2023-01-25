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

import its.statea.webserver.db.entity.ObservationMonthCustomView;
import its.statea.webserver.db.entity.composite.ObservationMonthKey;
import its.statea.webserver.db.repository.ObservationMonthCustomViewRepository;
import its.statea.webserver.helper.datamap.DatesRangeDatamap;
import its.statea.webserver.helper.datamap.MonthRecordDatamap;

@Service
@Transactional
public class ObservationMonthCustomViewService {
    
    @Autowired private ObservationMonthCustomViewRepository observationMonthCustomViewRepository;

    public Optional<ObservationMonthCustomView> fetchById(ObservationMonthKey observationMonthKey) {

        return observationMonthCustomViewRepository.findById(observationMonthKey);
    }

    public <T extends MonthRecordDatamap> List<T> fetchObservationMonthList(String originId, String destinationId, String observationTypeId, LocalDate startDate, LocalDate endDate, String sortField, Boolean ascendingOrder, Function<MonthRecordDatamap, ? extends T> dataMapper) {

        try (Stream<ObservationMonthCustomView> observationMonthStream = observationMonthCustomViewRepository.findAllCustom(originId, destinationId, observationTypeId, Date.valueOf(startDate), Date.valueOf(endDate), Sort.by(ascendingOrder? Direction.ASC : Direction.DESC, sortField))) {
            
            return observationMonthStream.map(dataMapper).collect(Collectors.toList());
        }
    }

    public <T extends DatesRangeDatamap> T fetchDatesRange(BiFunction<LocalDate, LocalDate, ? extends T> dataMapper) {

        Date start = observationMonthCustomViewRepository.findMinDate().orElse(null); 
        Date end = observationMonthCustomViewRepository.findMaxDate().orElse(null);
        
        if ((start == null) || (end == null)) {

            return null;
        }

        return dataMapper.apply(start.toLocalDate(), end.toLocalDate());
    }
}
