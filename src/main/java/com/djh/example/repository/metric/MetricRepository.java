package com.djh.example.repository.metric;

import com.djh.example.entity.metric.Metric;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MetricRepository extends PagingAndSortingRepository<Metric, Long> {

}
