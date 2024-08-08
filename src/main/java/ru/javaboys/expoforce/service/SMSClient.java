package ru.javaboys.expoforce.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.sms.name}", url = "${feign.sms.url}")
public interface SMSClient {

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    SmsResponse sendSMS(@RequestParam String number,
                 @RequestParam String sign,
                 @RequestParam String text,
                 @RequestHeader(name = "Authorization") String authorization);
}