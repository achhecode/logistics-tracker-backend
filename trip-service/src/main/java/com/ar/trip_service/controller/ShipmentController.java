package com.ar.trip_service.controller;

import com.ar.trip_service.dto.ShipmentCost;
import com.ar.trip_service.dto.ShipmentDetailsDTO;
import com.ar.trip_service.service.ShipmentCostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trips")
@Slf4j
public class ShipmentController {

    @Autowired
    private ShipmentCostService shipmentCostService;

    //    @RequestMapping(method = RequestMethod.OPTIONS)
    @PostMapping("calculate")
    public ResponseEntity<ShipmentCost> getShipmentCost(@RequestBody ShipmentDetailsDTO shipmentDetailsDTO){
        log.info("Request is {}", shipmentDetailsDTO);
        return ResponseEntity.ok(shipmentCostService.calculateShipmentCost(shipmentDetailsDTO));
    }

}
