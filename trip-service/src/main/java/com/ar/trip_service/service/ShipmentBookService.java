package com.ar.trip_service.service;

import com.ar.trip_service.dto.ShipmentCost;
import com.ar.trip_service.dto.ShipmentRequestDetailsDTO;
import com.ar.trip_service.dto.ShipmentResponseDetailsDTO;
import com.ar.trip_service.entity.Trip;
import com.ar.trip_service.model.TripStatus;
import com.ar.trip_service.repository.TripRepository;
import com.ar.trip_service.util.HexIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

@Service
@Slf4j
public class ShipmentBookService {

    @Autowired
    private TripRepository tripRepository;

    public ShipmentResponseDetailsDTO getShipmentTrackingId(ShipmentRequestDetailsDTO shipmentRequestDetailsDTO) {
        String trackingId = HexIdGenerator.generateHexId();
        // save the details in DB
        String originAddress = String.join(", ", Arrays.asList(
                shipmentRequestDetailsDTO.getOriginAddress(),
                shipmentRequestDetailsDTO.getOriginCity(),
                shipmentRequestDetailsDTO.getOriginCountry()
        ));

        String destAddress = String.join(", ", Arrays.asList(
                shipmentRequestDetailsDTO.getDestAddress(),
                shipmentRequestDetailsDTO.getDestCity(),
                shipmentRequestDetailsDTO.getDestCountry()
        ));

        Trip trip = new Trip();
        trip.setTrackingId(trackingId);
        trip.setOrigin(originAddress);
        trip.setDestination(destAddress);
        trip.setStartDate(LocalDate.now());
        trip.setExpectedDeliveryDate(LocalDate.now().plusDays(7));
        trip.setStatus(TripStatus.IN_PROGRESS);
        trip.setConsigneeName(shipmentRequestDetailsDTO.getOriginContactPerson().replace(" ", "_").toLowerCase());
        trip.setBrokerName(shipmentRequestDetailsDTO.getReferredByName());
        trip.setDriver("Drive "+ new Random().nextInt(1, 100));

        log.info("Saving trip data to database!");
        tripRepository.save(trip);


        return new ShipmentResponseDetailsDTO(trackingId);
    }
}
