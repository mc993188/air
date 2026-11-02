package org.example.springclass.demos.web.pojo;

import lombok.Data;

@Data
public class CityRankDTO {
    private String city;
    private Double avgAqi;
    private Integer goodHours;
    private Double goodRatio;
}
