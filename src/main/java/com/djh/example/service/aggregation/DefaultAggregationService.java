package com.djh.example.service.aggregation;

import com.djh.example.entity.metric.Metric;
import com.djh.example.service.metric.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class DefaultAggregationService implements AggregationService {

    @Value("${metric.name:SomeFinalDefault}")
    private String metricName;

    @Value("${metric.number}")
    private int noOfMetrics;

    private MetricService metricService;

    public List<Metric> collectMetrics() {

        List<Metric> metrics = new ArrayList<>();

        for (int i = 0; i < noOfMetrics; i++) {
            Metric metric = new Metric();
            metric.setHost(metricName + i);
            metrics.add(metric);
        }

        return metrics;
    }

    public String aggregateMetrics(List<Metric> metrics) {

        String aggregationText = metrics.size() + "Metrics:\n";

        for (Metric metric : metrics) {
            aggregationText += metric.getHost() + ":" + metricService.processMetric(metric) + "\n";
        }

        return aggregationText;
    }

    public void setMetricService(MetricService metricService) {
        this.metricService = metricService;
    }

}
