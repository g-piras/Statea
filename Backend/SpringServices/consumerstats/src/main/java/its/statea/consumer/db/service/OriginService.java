package its.statea.consumer.db.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import its.statea.consumer.db.entity.Origin;
import its.statea.consumer.db.repository.OriginRepository;

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

    public Origin save(Origin record) {

        return originRepository.saveAndFlush(record);
    }
}
