package its.statea.consumer.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumer.db.entity.ObservationMonth;
import its.statea.consumer.db.entity.composite.ObservationMonthKey;
import its.statea.consumer.db.repository.ObservationMonthRepository;

@Service
@Transactional
public class ObservationMonthService {
    
    @Autowired private ObservationMonthRepository observationMonthRepository;

    @Autowired private AccommodationTypeService accommodationTypeService;
    @Autowired private ObservationTypeService observationTypeService;
    @Autowired private OriginService originService;
    @Autowired private DestinationService destinationService;

    public Optional<ObservationMonth> fetchById(ObservationMonthKey observationMonthKey) {

        return observationMonthRepository.findById(observationMonthKey);
    }

    public void saveRecord(ObservationMonth record) {

        // update or insert joined records
        accommodationTypeService.fetchById(record.getAccommodationType().getId()).ifPresentOrElse(
            // update
            (foundRecord) -> {  
                foundRecord.setName(record.getAccommodationType().getName());
                record.setAccommodationType(accommodationTypeService.save(foundRecord)); 
            },
            // insert 
            () -> {
                record.setAccommodationType(accommodationTypeService.save(record.getAccommodationType()));
            }
        );

        observationTypeService.fetchById(record.getObservationType().getId()).ifPresentOrElse(
            // update
            (foundRecord) -> {  
                foundRecord.setName(record.getObservationType().getName());
                record.setObservationType(observationTypeService.save(foundRecord));
            },
            // insert 
            () -> {
                record.setObservationType(observationTypeService.save(record.getObservationType()));
            }
        );

        originService.fetchById(record.getOrigin().getId()).ifPresentOrElse(
            // update
            (foundRecord) -> {  
                foundRecord.setNameEng(record.getOrigin().getNameEng());
                foundRecord.setNameIta(record.getOrigin().getNameIta());
                foundRecord.setIsAggregate(record.getOrigin().getIsAggregate());
                record.setOrigin(originService.save(foundRecord));
            }, 
            // insert
            () -> {
                record.setOrigin(originService.save(record.getOrigin()));
            }
        );

        destinationService.fetchById(record.getDestination().getId()).ifPresentOrElse(
            // update
            (foundRecord) -> {  
                foundRecord.setNameIta(record.getDestination().getNameIta());
                foundRecord.setIsAggregate(record.getDestination().getIsAggregate());
                record.setDestination(destinationService.save(foundRecord));
            }, 
            // insert
            () -> {
                record.setDestination(destinationService.save(record.getDestination()));
            }
        );

        // insert or update observation record
        observationMonthRepository.findById(new ObservationMonthKey(record.getOrigin(), record.getDestination(), record.getAccommodationType(), record.getObservationType(), record.getDate())).ifPresentOrElse(
            // update
            (foundRecord) -> {
                foundRecord.setObservation(record.getObservation());
                observationMonthRepository.saveAndFlush(foundRecord);
            }, 
            // insert
            () -> {

                observationMonthRepository.saveAndFlush(record);
            }
        );
    }
}
