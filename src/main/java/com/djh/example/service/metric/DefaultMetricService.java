package com.djh.example.service.metric;

import com.djh.example.entity.metric.Metric;
import com.djh.example.repository.metric.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultMetricService implements MetricService {

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public String processMetric(Metric metric) {
        metricRepository.save(metric);
        return "Processed In Production";
    }

}
