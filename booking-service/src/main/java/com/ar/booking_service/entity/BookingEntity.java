package com.ar.booking_service.entity;


import com.ar.logistics_models.options.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bookings")
//@Table(name = "bookings", uniqueConstraints = @UniqueConstraint(columnNames = "bookingId"))
//@Table(name = "bookings", uniqueConstraints = @UniqueConstraint(columnNames = {"customerId", "bookingId"}))
@Data
@Builder
@NoArgsConstructor // Required for JPA
@AllArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String bookingId;
    private String customerId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "booking_goods", joinColumns = @JoinColumn(name = "booking_id"))
    private List<GoodsEmbeddable> goodsList;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "sender_country")),
            @AttributeOverride(name = "state", column = @Column(name = "sender_state")),
            @AttributeOverride(name = "city", column = @Column(name = "sender_city")),
            @AttributeOverride(name = "line1", column = @Column(name = "sender_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "sender_line2")),
            @AttributeOverride(name = "landmark", column = @Column(name = "sender_landmark")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "sender_pinCode")),
            @AttributeOverride(name = "contactPerson.name", column = @Column(name = "sender_name")),
            @AttributeOverride(name = "contactPerson.mobile", column = @Column(name = "sender_mobile"))
    })
    private AddressEmbeddable sender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "receiver_country")),
            @AttributeOverride(name = "state", column = @Column(name = "receiver_state")),
            @AttributeOverride(name = "city", column = @Column(name = "receiver_city")),
            @AttributeOverride(name = "line1", column = @Column(name = "receiver_line1")),
            @AttributeOverride(name = "line2", column = @Column(name = "receiver_line2")),
            @AttributeOverride(name = "landmark", column = @Column(name = "receiver_landmark")),
            @AttributeOverride(name = "pinCode", column = @Column(name = "receiver_pinCode")),
            @AttributeOverride(name = "contactPerson.name", column = @Column(name = "receiver_name")),
            @AttributeOverride(name = "contactPerson.mobile", column = @Column(name = "receiver_mobile"))
    })
    private AddressEmbeddable receiver;

    private String brokerId;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Embedded
    private PaymentPreferenceEmbeddable paymentPreference;

    @Embedded
    private ReferralEmbeddable referral;
}

