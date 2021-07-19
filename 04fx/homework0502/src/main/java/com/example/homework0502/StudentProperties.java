package com.example.homework0502;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;


/**
 * @author zengqi
 */
@Data
@ConfigurationProperties(prefix = "student")
public class StudentProperties implements Serializable {
    private int id;
    private String name;
}
