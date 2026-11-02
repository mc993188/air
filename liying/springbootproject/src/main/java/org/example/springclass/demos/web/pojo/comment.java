package org.example.springclass.demos.web.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class comment {

    private Integer id;
    private String content;
    private String author;
    private Integer aId;
}
