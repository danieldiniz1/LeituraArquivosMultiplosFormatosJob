package br.com.training.arquivoMultiplosFormatosJob.writer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiplosFormatosWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public ItemWriter multiplosFormatosWriter() {
        return items -> items.forEach(item -> LOGGER.info(item));
    }
}
