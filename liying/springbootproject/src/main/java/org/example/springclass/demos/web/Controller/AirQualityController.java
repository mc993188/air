package org.example.springclass.demos.web.Controller;


import org.example.springclass.demos.web.mapper.AirQualityMapper;
import org.example.springclass.demos.web.pojo.AirQuality;
import org.example.springclass.demos.web.pojo.CityRankDTO;
import org.example.springclass.demos.web.service.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/air")
@CrossOrigin
public class AirQualityController {
    @Autowired
    private AirQualityService airQualityService;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboardData() {
        Map<String, Object> result = new HashMap<>();
        result.put("ranking", airQualityService.getRanking());
        result.put("ratio", airQualityService.getGoodRatio());

        // 提取所有城市名，去重，用于前端下拉框
        List<String> cityList = airQualityService.getRanking().stream()
                .map(CityRankDTO::getCity).collect(Collectors.toList());
        result.put("cityList", cityList);
        return result;
    }

    // 2. 动态折线图接口
    @GetMapping("/trend")
    public List<AirQuality> getTrend(@RequestParam String cities) {
        List<String> cityList = Arrays.asList(cities.split(","));
        return airQualityService.getMultiCityTrend(cityList);
    }

    // 3. 动态雷达图接口
    @GetMapping("/radar")
    public List<CityRankDTO> getRadar(@RequestParam String city) {
        return airQualityService.getPollutantRadar(city);
    }

    @Autowired
    private javax.sql.DataSource dataSource;

    @GetMapping("/check")
    public String checkTable() {
        try (java.sql.Connection conn = dataSource.getConnection()) {
            java.sql.ResultSet rs = conn.createStatement().executeQuery("SELECT COUNT(*) FROM air_quality");
            if (rs.next()) {
                return "当前连接的库是：" + conn.getCatalog() + "，air_quality 表的数据量是：" + rs.getInt(1);
            }
        } catch (Exception e) {
            return "查询出错：" + e.getMessage();
        }
        return "未知错误";
    }
}
