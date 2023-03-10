package br.com.training.arquivoMultiplosFormatosJob.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MultiplosFormatosJobConfig {

    @Bean
    public Job multiplosFormatosJob(Step multiplosFormatosStep, JobRepository jobRepository){
        return new JobBuilder("multiplosFormatosJob",jobRepository)
                .start(multiplosFormatosStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
