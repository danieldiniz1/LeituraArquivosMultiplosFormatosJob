package br.com.training.arquivoMultiplosFormatosJob.reader;

import br.com.training.arquivoMultiplosFormatosJob.model.Cliente;
import br.com.training.arquivoMultiplosFormatosJob.model.Transacao;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente>, ResourceAwareItemReaderItemStream<Cliente> {

    private FlatFileItemReader<Object> delegate;
    private Object objectAtual;

    public ArquivoClienteTransacaoReader(FlatFileItemReader<Object> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Cliente read() throws Exception {
        if (objectAtual == null)
            objectAtual = delegate.read(); //TODO ler objeto

        Cliente cliente = (Cliente) objectAtual;
        objectAtual = null;

        if (cliente != null){
            while (peek() instanceof Transacao)
                cliente.getTransacoes().add((Transacao) objectAtual);
        }
        return cliente;
    }

    private Object peek() throws Exception {
        objectAtual = delegate.read(); //TODO leitura do próximo objeto
        return objectAtual;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        delegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        delegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        delegate.close();
    }

    @Override
    public void setResource(Resource resource) {
        delegate.setResource(resource);
    }
}
