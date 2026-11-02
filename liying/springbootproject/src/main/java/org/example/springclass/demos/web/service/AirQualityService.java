package org.example.springclass.demos.web.service;

import org.example.springclass.demos.web.pojo.AirQuality;
import org.example.springclass.demos.web.pojo.CityRankDTO;

import java.util.List;

public interface AirQualityService {
    List<CityRankDTO> getRanking();
    List<CityRankDTO> getGoodRatio();
    List<AirQuality> getCityTrend(String city);

    List<AirQuality> getMultiCityTrend(List<String> cities);

    List<CityRankDTO> getPollutantRadar(String city);
}
