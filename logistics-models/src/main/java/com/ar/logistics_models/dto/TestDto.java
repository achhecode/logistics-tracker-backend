package com.ar.logistics_models.dto;

//public class TestDto {
//    private String key;
//    private String value;
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public TestDto(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "TestDto{" +
//                "key='" + key + '\'' +
//                ", value='" + value + '\'' +
//                '}';
//    }
//}

// works but trying with lombok

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {
    private String key;
    private String value;
}