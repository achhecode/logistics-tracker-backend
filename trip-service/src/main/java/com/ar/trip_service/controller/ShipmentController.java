package com.ar.trip_service.controller;

import com.ar.trip_service.dto.ShipmentCost;
import com.ar.trip_service.dto.ShipmentRequestDetailsDTO;
import com.ar.trip_service.dto.ShipmentResponseDetailsDTO;
import com.ar.trip_service.service.ShipmentBookService;
import com.ar.trip_service.service.ShipmentCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trips/shipment")
@Slf4j
public class ShipmentController {

    @Autowired
    private ShipmentCostService shipmentCostService;

    @Autowired
    private ShipmentBookService shipmentBookService;

    //    @RequestMapping(method = RequestMethod.OPTIONS)
    @PostMapping("/calculate")
    public ResponseEntity<ShipmentCost> getShipmentCost(@RequestBody ShipmentRequestDetailsDTO shipmentDetailsDTO){
        log.info("Request is {}", shipmentDetailsDTO);
        return ResponseEntity.ok(shipmentCostService.calculateShipmentCost(shipmentDetailsDTO));
    }

    @PostMapping("/book")
    public ResponseEntity<ShipmentResponseDetailsDTO> getShipmentDetails(@RequestBody ShipmentRequestDetailsDTO shipmentRequestDetailsDTO){
        log.info("Request reached in /book API");
        return ResponseEntity.ok(shipmentBookService.getShipmentTrackingId(shipmentRequestDetailsDTO));
    }

}
