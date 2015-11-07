package com.djh.example;

import com.djh.example.entity.metric.Metric;
import com.djh.example.service.aggregation.AggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class ApplicationLoader implements CommandLineRunner {

    @Value("${metricName}")
    private String metricName;

    @Value("${metricNo}")
    private Integer noOfMetrics = 1;

    @Autowired
    private AggregationService aggregationService;


    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ApplicationLoader.class);
        springApplication.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        SpringApplication.run(ApplicationLoader.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Metric> metrics = new ArrayList<>();

        int noOfMetrics = Integer.parseInt(args[0]);
        for (int i = 0; i < noOfMetrics; i++) {
            Metric metric = new Metric();
            metric.setHost("Host" + i);
            metrics.add(metric);
        }

        String aggregatedMetrics = aggregationService.aggregateMetrics(metrics);
        System.out.print(aggregatedMetrics);
    }

}