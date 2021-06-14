package br.com.gabriellpa.joborchestrator.config;

import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.InMemoryStorageProvider;
import org.jobrunr.storage.StorageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobrunrConfiguration {

        // The`spring-boot-starter-web` provides Jackson as JobMapper
        @Bean
        public StorageProvider storageProvider(JobMapper jobMapper) {
            InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
            storageProvider.setJobMapper(jobMapper);
            return storageProvider;
        }
    
}