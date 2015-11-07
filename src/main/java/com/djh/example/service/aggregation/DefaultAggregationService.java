package com.djh.example.service.aggregation;

import com.djh.example.entity.metric.Metric;
import com.djh.example.service.metric.MetricService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultAggregationService implements AggregationService {

    @Autowired
    private MetricService metricService;

    public String aggregateMetrics(List<Metric> metrics) {

        String aggregationText = metrics.size() + "M:";

        for (Metric metric : metrics) {
            aggregationText += metricService.processMetric(metric);
        }

        return aggregationText;
    }

    public void setMetricService(MetricService metricService) {
        this.metricService = metricService;
    }

}
