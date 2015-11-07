package com.djh.example;

import com.djh.example.config.AppConfig;
import com.djh.example.entity.metric.Metric;
import com.djh.example.service.aggregation.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class ApplicationLoader implements CommandLineRunner {

    private AggregationService aggregationService;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        SpringApplication.run(AppConfig.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Metric> metrics = aggregationService.collectMetrics();
        String aggregatedMetrics = aggregationService.aggregateMetrics(metrics);

        System.out.print(aggregatedMetrics);
    }

    public void setAggregationService(AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

}