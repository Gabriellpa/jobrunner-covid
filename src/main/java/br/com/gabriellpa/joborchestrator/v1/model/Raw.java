package br.com.gabriellpa.joborchestrator.v1.model;

import com.opencsv.bean.CsvBindAndJoinByName;
import com.opencsv.bean.CsvBindByName;

import org.apache.commons.collections4.MultiValuedMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Raw {
    @CsvBindByName(column = "Province/State")
    private String provinceState;
    @CsvBindByName(column = "Country/Region")
    private String countryRegion;
    @CsvBindByName(column = "Lat")
    private Double _lat;
    @CsvBindByName(column = "Long")
    private Double _long;
    @CsvBindAndJoinByName(column = "[0-9]{1,2}/[0-9]{1,2}/[0-9]{1,2}", elementType = String.class)
    private MultiValuedMap<String, String> casesPerDay;
}
