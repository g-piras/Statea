package its.statea.consumer.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumer.db.entity.ObservationYear;
import its.statea.consumer.db.entity.composite.ObservationYearKey;
import its.statea.consumer.db.repository.ObservationYearRepository;

@Service
@Transactional
public class ObservationYearService {
    
    @Autowired private ObservationYearRepository observationYearRepository;

    @Autowired private AccommodationTypeService accommodationTypeService;
    @Autowired private ObservationTypeService observationTypeService;
    @Autowired private OriginService originService;
    @Autowired private DestinationService destinationService;

    public Optional<ObservationYear> fetchById(ObservationYearKey observationYearKey) {

        return observationYearRepository.findById(observationYearKey);
    }

    public void saveRecord(ObservationYear record) {

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
        observationYearRepository.findById(new ObservationYearKey(record.getOrigin(), record.getDestination(), record.getAccommodationType(), record.getObservationType(), record.getYear())).ifPresentOrElse(
            // update
            (foundRecord) -> {
                foundRecord.setObservation(record.getObservation());
                observationYearRepository.saveAndFlush(foundRecord);
            }, 
            // insert
            () -> {

                observationYearRepository.saveAndFlush(record);
            }
        );
    }
}
