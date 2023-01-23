package its.statea.consumerforecasts.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumerforecasts.db.entity.Destination;
import its.statea.consumerforecasts.db.repository.DestinationRepository;

@Service
@Transactional
public class DestinationService {
    
    @Autowired private DestinationRepository destinationRepository;

    public Optional<Destination> fetchById(String id) {

        return destinationRepository.findById(id);
    }

    public boolean exists(String id) {

        return destinationRepository.existsById(id);
    }
}
