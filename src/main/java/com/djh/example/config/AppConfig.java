package com.djh.example.config;

import com.djh.example.service.aggregation.AggregationService;
import com.djh.example.service.aggregation.DefaultAggregationService;
import com.djh.example.service.metric.DefaultMetricService;
import com.djh.example.service.metric.LocalMetricService;
import com.djh.example.service.metric.MetricService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public AggregationService aggregationService(){
        return new DefaultAggregationService();
    }

    @Bean
    @Profile("!local")
    public MetricService metricService(){
        return new DefaultMetricService();
    }

    @Bean
    @Profile("local")
    public MetricService localMetricService(){
        return new LocalMetricService();
    }

}
