package its.statea.webserver.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.webserver.db.entity.ObservationType;
import its.statea.webserver.db.repository.ObservationTypeRepository;

@Service
@Transactional
public class ObservationTypeService {
    
    @Autowired private ObservationTypeRepository observationTypeRepository;

    public Optional<ObservationType> fetchById(String id) {

        return observationTypeRepository.findById(id);
    }

    public boolean exists(String id) {

        return observationTypeRepository.existsById(id);
    }
}
