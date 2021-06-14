package br.com.gabriellpa.joborchestrator.v1.entity;

import java.util.List;

import br.com.gabriellpa.joborchestrator.v1.model.Cases;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RawEntity {
    private String provinceState;
    private String countryRegion;
    private Double _lat;
    private Double _long;
    private List<Cases> casesPerDay;
}
