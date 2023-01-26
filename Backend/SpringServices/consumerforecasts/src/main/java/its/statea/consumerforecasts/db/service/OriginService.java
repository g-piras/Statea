package its.statea.consumerforecasts.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumerforecasts.db.entity.Origin;
import its.statea.consumerforecasts.db.repository.OriginRepository;

@Service
@Transactional
public class OriginService {
    
    @Autowired private OriginRepository originRepository;

    public Optional<Origin> fetchById(String id) {

        return originRepository.findById(id);
    }

    public boolean exists(String id) {

        return originRepository.existsById(id);
    }
}
