package ru.javaboys.expoforce.service;

import lombok.Data;

@Data
public class SmsResponse {

    private Boolean success;
    private DataResponse data;
    private String message;

    @Data
    public static class DataResponse {
        private Integer id;
        private String from;
        private String number;
        private String text;
        private Integer status;
        private String extendStatus;
        private String channel;
        private Double cost;
        private Long dateCreate;
        private Long dateSend;
    }
}
