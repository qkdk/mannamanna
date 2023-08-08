package com.ssafy.manna.schedule.domain;

import com.ssafy.manna.global.common.domain.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReserveAddress extends Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Boolean isAdvertisement;
    private Integer advertisementCost;

    private LocalDateTime advertisementStartDate;
    private LocalDateTime advertisementEndDate;

    public ReserveAddress(String sido, String gugun, String detail, Double latitude,
            Double longitude,
            Integer id, String name, Boolean isAdvertisement, Integer advertisementCost,
            LocalDateTime advertisementStartDate, LocalDateTime advertisementEndDate) {
        super(sido, gugun, detail, latitude, longitude);
        this.id = id;
        this.name = name;
        this.isAdvertisement = isAdvertisement;
        this.advertisementCost = advertisementCost;
        this.advertisementStartDate = advertisementStartDate;
        this.advertisementEndDate = advertisementEndDate;
    }
}
