package org.example.springclass.demos.web.service.impl;

import org.example.springclass.demos.web.mapper.AirQualityMapper;
import org.example.springclass.demos.web.pojo.AirQuality;
import org.example.springclass.demos.web.pojo.CityRankDTO;
import org.example.springclass.demos.web.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AirQualityServiceImpl implements AirQualityService {
    @Autowired
    private AirQualityMapper airQualityMapper;
    @Override
    public List<CityRankDTO> getRanking() {

        return airQualityMapper.getCityRanking();
    }

    @Override
    public List<CityRankDTO> getGoodRatio() {

        return airQualityMapper.getGoodRatio();
    }

    @Override
    public List<AirQuality> getCityTrend(String city) {

        return airQualityMapper.getCityTrend(city);
    }
    @Override
    public List<AirQuality> getMultiCityTrend(List<String> cities) {
        return airQualityMapper.getMultiCityTrend(cities);
    }

    @Override
    public List<CityRankDTO> getPollutantRadar(String city) {
        return airQualityMapper.getPollutantRadar(city);
    }
}
