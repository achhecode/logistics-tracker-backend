package com.ar.booking_service.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class UserContactEmbeddable {
    private String name;
    private String mobile;
}
