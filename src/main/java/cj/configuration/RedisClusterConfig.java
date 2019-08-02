package cj.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.stereotype.Component;

import lombok.Data;

@Configuration
@EnableConfigurationProperties
public class RedisClusterConfig {

	@Data
	@Component
	@ConfigurationProperties(prefix = "spring.redis.cluster")
	public class RedisClusterConfigurationProperties {
		
		@Autowired
        RedisClusterConfigurationProperties() {}
		
		/*
		 * spring.redis.cluster.nodes[0] = 127.0.0.1:7379 
		 * spring.redis.cluster.nodes[1] = 127.0.0.1:7380 
		 * ...
		 */
		private List<String> nodes;
	}
	
	@Autowired
	private RedisClusterConfigurationProperties redisClusterConfigurationProperties;
	
	@Value("${spring.redis.maxTotal}")
	private Integer maxTotal;
	
	@Value("${spring.redis.maxIdle}")
	private Integer maxIdlel;

	@Value("${spring.redis.minIdle}")
	private Integer minIdlel;
	
	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {
		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(redisClusterConfigurationProperties.getNodes());
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration);
		return lettuceConnectionFactory;
    }
}







//package cj.enm.base.supply.core.common.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class RedisRepositoryConfig {
//	
//	@Value("${spring.redis.host}")
//  private String redisHost;
//
//  @Value("${spring.redis.port}")
//  private int redisPort;
//	
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		return new LettuceConnectionFactory(redisHost, redisPort);
//	}
//
//	@Bean
//	public RedisTemplate<?, ?> redisTemplate() {
//		RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(redisConnectionFactory());
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		return redisTemplate;
//	}
//}
