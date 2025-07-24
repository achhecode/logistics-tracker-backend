package com.ar.trip_service.test;

import com.ar.logistics_models.dto.TestDto;

public class Test {
    public static void main(String[] args) {
        TestDto testDto = new TestDto("A_R", "Danish");
        System.out.println(testDto.toString());
    }
}
