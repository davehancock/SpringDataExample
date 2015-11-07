package com.djh.example.config;

import com.djh.example.ApplicationLoader;
import com.djh.example.service.aggregation.AggregationService;
import com.djh.example.service.aggregation.DefaultAggregationService;
import com.djh.example.service.metric.DefaultMetricService;
import com.djh.example.service.metric.LocalMetricService;
import com.djh.example.service.metric.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig {

    @Autowired
    private MetricService metricService;

    @Bean
    public ApplicationLoader applicationLoader() {
        ApplicationLoader applicationLoader = new ApplicationLoader();
        applicationLoader.setAggregationService(aggregationService());
        return applicationLoader;
    }

    @Bean
    public AggregationService aggregationService() {
        DefaultAggregationService aggregationService = new DefaultAggregationService();
        aggregationService.setMetricService(metricService);
        return aggregationService;
    }

    @Bean
    @Profile("!local")
    public MetricService metricService() {
        return new DefaultMetricService();
    }

    @Bean
    @Profile("local")
    public MetricService localMetricService() {
        return new LocalMetricService();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
