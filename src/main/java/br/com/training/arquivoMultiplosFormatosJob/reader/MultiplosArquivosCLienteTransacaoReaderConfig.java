package br.com.training.arquivoMultiplosFormatosJob.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

import java.nio.file.Path;
import java.util.Arrays;

@Configuration
public class MultiplosArquivosCLienteTransacaoReaderConfig {



    @StepScope
    @Bean
    public MultiResourceItemReader multiplosArquivosCLienteTransacaoReader(FlatFileItemReader multiplosFormatosReader,
                                                                           @Value("#{jobParameters['arquivosClientes']}") Resource[] arquivosClientes){
        return new MultiResourceItemReaderBuilder<>()
                .name("multiplosArquivosCLienteTransacaoReader")
                .resources(arquivosClientes)
                .delegate(new ArquivoClienteTransacaoReader(multiplosFormatosReader))
                .build();
    }
}
