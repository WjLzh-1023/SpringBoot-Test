package com.model;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "data")
public class DataProperties {
    private int id;
    private String name;

}
