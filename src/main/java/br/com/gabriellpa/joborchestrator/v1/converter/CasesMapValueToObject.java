package br.com.gabriellpa.joborchestrator.v1.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.modelmapper.AbstractConverter;

import br.com.gabriellpa.joborchestrator.v1.model.Cases;

public class CasesMapValueToObject extends AbstractConverter<MultiValuedMap<String, String>, List<Cases>>  {

    @Override
    protected List<Cases> convert(MultiValuedMap<String, String> source) {
        return source.entries().stream()
        .map(mapper -> Cases.builder().date(mapper.getKey()).numberOfCases(mapper.getValue()).build()).collect(Collectors.toList());
    }
    
}
