package br.com.gabriellpa.joborchestrator.config;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.nosql.redis.JedisRedisStorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import redis.clients.jedis.JedisPool;


@Configuration
public class JobrunrConfiguration {

    @Bean
    public StorageProvider storageProvider(JobMapper jobMapper) {
        JedisRedisStorageProvider storageProvider = new JedisRedisStorageProvider(new JedisPool("redis", 6379));
        storageProvider.setJobMapper(jobMapper);
        return storageProvider;
    }

}
