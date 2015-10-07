package com.djh.example.entity;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author David Hancock
 */
public interface MetricRepository extends PagingAndSortingRepository<Metric, Long> {

}
