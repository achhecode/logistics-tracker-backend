package com.ar.trip_service.repository;

import com.ar.trip_service.entity.TripEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripEventRepository extends JpaRepository<TripEventEntity, Long> {
}
