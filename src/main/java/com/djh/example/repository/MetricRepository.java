package com.djh.example.repository;

import com.djh.example.entity.Metric;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author David Hancock
 */
public interface MetricRepository extends PagingAndSortingRepository<Metric, Long> {

}