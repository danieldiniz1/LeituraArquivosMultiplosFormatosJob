package br.com.training.arquivoMultiplosFormatosJob.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MultiplosFormatosStepConfig {

    @Bean
    public Step multiplosFormatosStep(ItemReader multiplosFormatosReader, ItemWriter multiplosFormatosWriter,
                                      JobRepository jobRepository,
                                      PlatformTransactionManager transactionManager){
        return new StepBuilder("multiplosFormatosStep",jobRepository)
                .chunk(1)
                .reader(multiplosFormatosReader)
                .writer(multiplosFormatosWriter)
                .transactionManager(transactionManager)
                .build();
    }
}
