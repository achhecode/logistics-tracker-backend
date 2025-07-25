package com.ar.booking_service.service;

import com.ar.booking_service.dto.BookingCostRequestDTO;
import com.ar.booking_service.dto.BookingCostResponseDTO;
import com.ar.booking_service.dto.BookingRequestDTO;
import com.ar.booking_service.dto.BookingResponseDTO;
import com.ar.booking_service.entity.BookingEntity;
import com.ar.booking_service.repository.BookingRepository;
import com.ar.booking_service.util.BookingMapper;
import com.ar.booking_service.util.HexIdGenerator;
import com.ar.logistics_models.dto.GoodsDTO;
import com.ar.logistics_models.options.BookingStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingService {

    @Value("${price.perKg}")
    private double pricePerKg;


    private final BookingRepository bookingRepository;

    // Save booking
    public BookingResponseDTO createBooking(BookingRequestDTO request) {
        BookingEntity entity = BookingMapper.toEntity(request);
        entity.setBookingId(HexIdGenerator.generateHexId());
        entity.setStatus(BookingStatus.PENDING);
        BookingEntity saved = bookingRepository.save(entity);
        return BookingMapper.toResponseDTO(saved);
    }

    // Get booking by bookingId
    public BookingResponseDTO getBookingById(String bookingId) {
        BookingEntity entity = bookingRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found: " + bookingId));
        return BookingMapper.toResponseDTO(entity);
    }

    public BookingCostResponseDTO calculateBookingCost(BookingCostRequestDTO bookingCostRequestDTO) {
        int randomDistance = 100 + new Random().nextInt(501);
        double totalCost = 0;
        log.info("Request is {}", bookingCostRequestDTO.toString());
        for(GoodsDTO goodsDTO: bookingCostRequestDTO.getGoodsList()){
            totalCost += (pricePerKg * goodsDTO.getQuantity()) * randomDistance;
        }

        totalCost = BigDecimal.valueOf(totalCost)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        log.info("Total cost is {}", totalCost);
        return new BookingCostResponseDTO(totalCost);
    }


}

