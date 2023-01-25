package its.statea.consumerforecasts.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumerforecasts.db.entity.AccommodationType;
import its.statea.consumerforecasts.db.repository.AccommodationTypeRepository;

@Service
@Transactional
public class AccommodationTypeService {
    
    @Autowired private AccommodationTypeRepository accommodationTypeRepository;

    public Optional<AccommodationType> fetchById(String id) {

        return accommodationTypeRepository.findById(id);
    }

    public boolean exists(String id) {

        return accommodationTypeRepository.existsById(id);
    }
}
