package com.ar.trip_service.service;

import com.ar.trip_service.dto.ShipmentCost;
import com.ar.trip_service.dto.ShipmentDetailsDTO;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

//@ConfigurationProperties(prefix = "price")
@Service
public class ShipmentCostService {

    @Value("${price.perKg}")
    private double pricePerKg;

    public ShipmentCost calculateShipmentCost(ShipmentDetailsDTO shipmentDetailsDTO) {
        int randomDistance = 100 + new Random().nextInt(501);
        double totalCost = (pricePerKg * shipmentDetailsDTO.getWeight()) * randomDistance;

        totalCost = BigDecimal.valueOf(totalCost)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        return new ShipmentCost(totalCost);
    }
}
