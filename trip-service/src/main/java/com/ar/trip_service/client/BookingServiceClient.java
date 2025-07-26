package com.ar.trip_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "booking-service") // Eureka service name
public interface BookingServiceClient {

    @GetMapping("/bookings/exists/{bookingId}")
    boolean bookingExists(@PathVariable("bookingId") String bookingId);

}