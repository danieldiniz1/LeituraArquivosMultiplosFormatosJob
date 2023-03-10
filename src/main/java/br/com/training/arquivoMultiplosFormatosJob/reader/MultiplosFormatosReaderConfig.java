package br.com.training.arquivoMultiplosFormatosJob.reader;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;

@Configuration
public class MultiplosFormatosReaderConfig {

    @Bean
    public FlatFileItemReader multiplosFormatosReader(LineMapper lineMapper) {
        return new FlatFileItemReaderBuilder<>()
                .name("multiplosFormatosReader")
                .resource(new PathResource("files/clientes.txt"))
                .lineMapper(lineMapper)
                .build();
    }
}
