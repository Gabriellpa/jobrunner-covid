package br.com.gabriellpa.joborchestrator.v1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// TODO: adicionar no config map(ainda não tem)

@FeignClient(name = "globalCovidData", url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series")
public interface CoronaVirusGitHubCSSEGIClient {

    @GetMapping("/time_series_covid19_confirmed_global.csv")
    public String getConfirmed();

    @GetMapping("/time_series_covid19_deaths_global.csv")
    public String getDeaths();

    @GetMapping("/time_series_covid19_recovered_global.csv")
    public String getRecovered();
    
}