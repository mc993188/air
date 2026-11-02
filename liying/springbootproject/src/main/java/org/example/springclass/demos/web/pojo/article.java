package org.example.springclass.demos.web.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class article {
    private Integer id;
    private String title;
    private String content;
    private List<comment> commentList;
}
