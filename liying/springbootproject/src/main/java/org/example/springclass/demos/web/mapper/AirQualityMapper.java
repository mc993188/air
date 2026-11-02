package org.example.springclass.demos.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springclass.demos.web.pojo.AirQuality;
import org.example.springclass.demos.web.pojo.CityRankDTO;

import java.util.List;

@Mapper
public interface AirQualityMapper {
    // 城市 AQI 均值排名
    List<CityRankDTO> getCityRanking();
    // 优良时段比例
    List<CityRankDTO> getGoodRatio();
    // 单个城市24小时趋势
    List<AirQuality> getCityTrend(@Param("city") String city);

    List<AirQuality> getMultiCityTrend(@Param("cities") List<String> cities);
    List<CityRankDTO> getPollutantRadar(@Param("city") String city);
}
