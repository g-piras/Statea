package its.statea.producer.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisRepository {

    RedisClient redisClient = RedisClient.create("redis://qY_aOGofJ*d8GJN@redis:6379/0");

    public void set(String key, String value) {

        try {

            StatefulRedisConnection<String, String> connection = redisClient.connect();
            RedisCommands<String, String> syncCommands = connection.sync();
        
            syncCommands.set(key, value);
        
            connection.close();
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * 
     * @param key
     * @return null when key does not exist
     */
    public String get(String key) {

        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();
    
        String result = syncCommands.get(key);
    
        connection.close();

        return result;
    }

    public void dispose() {

        redisClient.shutdown();
    }
}
