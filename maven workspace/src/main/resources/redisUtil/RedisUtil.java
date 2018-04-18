package redisUtil;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public  class RedisUtil {
	@SuppressWarnings("unused")
	public Jedis getJedis(){
		
		//Jedis jedis = new Jedis("39.107.81.17",6379);	
		//jedis.auth("tanhao123.");
		Jedis jedis = new Jedis("127.0.0.1",6379);
		return jedis;
	}
	
}
