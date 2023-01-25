package its.statea.consumerforecasts.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumerforecasts.db.entity.PredictionYear;
import its.statea.consumerforecasts.db.entity.composite.PredictionYearKey;
import its.statea.consumerforecasts.db.repository.PredictionYearRepository;

@Service
@Transactional
public class PredictionYearService {
    
    @Autowired private PredictionYearRepository predictionYearRepository;

    @Autowired private AccommodationTypeService accommodationTypeService;
    @Autowired private ObservationTypeService observationTypeService;
    @Autowired private OriginService originService;
    @Autowired private DestinationService destinationService;

    public Optional<PredictionYear> fetchById(PredictionYearKey predictionYearKey) {

        return predictionYearRepository.findById(predictionYearKey);
    }

    public void saveRecord(PredictionYear record) {

        // insert or update prediction record
        predictionYearRepository.findById(new PredictionYearKey(record.getOrigin(), record.getDestination(), record.getAccommodationType(), record.getObservationType(), record.getYear())).ifPresentOrElse(
            // update
            (foundRecord) -> {
                foundRecord.setPrediction(record.getPrediction());
                predictionYearRepository.saveAndFlush(foundRecord);
            }, 
            // insert
            () -> {

                // fill record with persistent entities
                record.setAccommodationType(accommodationTypeService.fetchById(record.getAccommodationType().getId()).get());
                record.setObservationType(observationTypeService.fetchById(record.getObservationType().getId()).get());
                record.setOrigin(originService.fetchById(record.getOrigin().getId()).get());
                record.setDestination(destinationService.fetchById(record.getDestination().getId()).get());
                // insert record
                predictionYearRepository.saveAndFlush(record);
            }
        );
    }
}
