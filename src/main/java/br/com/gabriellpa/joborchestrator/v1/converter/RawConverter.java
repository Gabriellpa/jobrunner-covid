package br.com.gabriellpa.joborchestrator.v1.converter;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import br.com.gabriellpa.joborchestrator.v1.model.Raw;
import br.com.gabriellpa.joborchestrator.v1.entity.RawEntity;

@Component
public class RawConverter {

    private final ModelMapper modelMapper;

    public RawConverter(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.createTypeMap(Raw.class, RawEntity.class).addMappings(mapper -> mapper
                .using(new CasesMapValueToObject()).map(Raw::getCasesPerDay, RawEntity::setCasesPerDay));
    }

    public List<RawEntity> toRawEntity(List<Raw> raws) {
        return modelMapper.map(raws, new TypeToken<List<RawEntity>>() {
        }.getType());
    }

}
