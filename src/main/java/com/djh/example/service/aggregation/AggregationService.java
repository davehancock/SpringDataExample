package com.djh.example.service.aggregation;

import com.djh.example.entity.metric.Metric;

import java.util.List;

public interface AggregationService {

    String aggregateMetrics(List<Metric> metrics);

}
