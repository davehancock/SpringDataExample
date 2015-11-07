package com.djh.example.service.metric;

import com.djh.example.entity.metric.Metric;

public class LocalMetricService implements MetricService {

    @Override
    public String processMetric(Metric metric) {
        return "Processed Locally";
    }

}
