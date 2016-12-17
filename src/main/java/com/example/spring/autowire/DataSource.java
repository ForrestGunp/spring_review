package com.example.spring.autowire;

import java.util.Properties;

/**
 * Created by Tang on 2016/12/13.
 */
public class DataSource {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
