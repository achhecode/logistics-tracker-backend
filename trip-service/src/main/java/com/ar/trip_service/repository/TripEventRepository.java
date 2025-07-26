package com.ar.trip_service.repository;

import com.ar.trip_service.entity.TripEntity;
import com.ar.trip_service.entity.TripEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripEventRepository extends JpaRepository<TripEventEntity, Long> {
//    Optional<List<TripEventEntity>> findByTripId(String tripId);
    List<TripEventEntity> findByTrip_TripId(String tripId);

}
