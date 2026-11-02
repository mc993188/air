package org.example.springclass.demos.web.pojo;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AirQuality {
    private Long id;
    private LocalDateTime time;
    private String city;
    private String type;
    private Double value;
}
