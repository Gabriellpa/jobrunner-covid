package br.com.gabriellpa.joborchestrator.v1.converter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.stereotype.Component;

import br.com.gabriellpa.joborchestrator.v1.model.Raw;

@Component
public class CsvConverter {

    public List<Raw> stringToObject(String content) throws CsvValidationException, IOException {
        // TODO: Adicionar como builder?
        CsvToBeanBuilder<Raw> beanBuilder = new CsvToBeanBuilder<>(new InputStreamReader(new ReaderInputStream(new StringReader(content))));
        return beanBuilder.withType(Raw.class).build().parse();

    }

}
