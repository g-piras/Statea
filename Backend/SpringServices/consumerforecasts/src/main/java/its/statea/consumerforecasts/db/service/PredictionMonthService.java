package its.statea.consumerforecasts.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumerforecasts.db.entity.PredictionMonth;
import its.statea.consumerforecasts.db.entity.composite.PredictionMonthKey;
import its.statea.consumerforecasts.db.repository.PredictionMonthRepository;

@Service
@Transactional
public class PredictionMonthService {
    
    @Autowired private PredictionMonthRepository predictionMonthRepository;

    @Autowired private AccommodationTypeService accommodationTypeService;
    @Autowired private ObservationTypeService observationTypeService;
    @Autowired private OriginService originService;
    @Autowired private DestinationService destinationService;

    public Optional<PredictionMonth> fetchById(PredictionMonthKey predictionMonthKey) {

        return predictionMonthRepository.findById(predictionMonthKey);
    }

    public void saveRecord(PredictionMonth record) {

        // insert or update prediction record
        predictionMonthRepository.findById(new PredictionMonthKey(record.getOrigin(), record.getDestination(), record.getAccommodationType(), record.getObservationType(), record.getDate())).ifPresentOrElse(
            // update
            (foundRecord) -> {
                foundRecord.setPrediction(record.getPrediction());
                predictionMonthRepository.saveAndFlush(foundRecord);
            }, 
            // insert
            () -> {

                // fill record with persistent entities
                record.setAccommodationType(accommodationTypeService.fetchById(record.getAccommodationType().getId()).get());
                record.setObservationType(observationTypeService.fetchById(record.getObservationType().getId()).get());
                record.setOrigin(originService.fetchById(record.getOrigin().getId()).get());
                record.setDestination(destinationService.fetchById(record.getDestination().getId()).get());
                // insert record
                predictionMonthRepository.saveAndFlush(record);
            }
        );
    }
}
