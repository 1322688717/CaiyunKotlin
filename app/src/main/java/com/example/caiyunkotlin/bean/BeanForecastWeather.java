package com.example.caiyunkotlin.bean;

import java.util.List;

public class BeanForecastWeather {

    private List<ResultsDTO> results;

    public List<ResultsDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultsDTO> results) {
        this.results = results;
    }
}
