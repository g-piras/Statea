package its.statea.producer.redis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class RedisService {
    
    private static final String redisKey = "last_update";
    private static final String fallbackDate = "1900-01-01";

    public String lastUpdateDate() {

        RedisRepository redisRepository = new RedisRepository();

        String isoDate = redisRepository.get(redisKey);
        isoDate = (isoDate != null)? isoDate : fallbackDate;

        redisRepository.dispose();

        return isoDate;
    }

    public void saveUpdateDate() {

        RedisRepository redisRepository = new RedisRepository();

        redisRepository.set(redisKey, LocalDate.now().format(DateTimeFormatter.ISO_DATE));

        redisRepository.dispose();
    }
}
