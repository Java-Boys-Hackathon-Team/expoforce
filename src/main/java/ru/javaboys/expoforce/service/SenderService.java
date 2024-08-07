package ru.javaboys.expoforce.service;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.javaboys.expoforce.entity.Client;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SenderService {

    @Value("${sms.login}")
    private String smsLogin;

    @Value("${sms.apikey}")
    private String smsApiKey;

    public static final String EMAIL_EXPOFORCE_SENDER_ADDRESS = "expo.force@yandex.ru";
    public static final String SUBJECT = "ExpoForce Special Offers";
    private static final String SMS_EXPOFORCE_SENDER_NAME = "ExpoForce";

    private final SMSClient SMSClient;
    private final JavaMailSender mailSender;

    @Async
    public void sendSMS(List<Client> clients, String message) {
        clients.forEach(client -> {
            String authorizationHeader = getBasicAuthenticationHeader();
            try {
                SmsResponse smsResponse = SMSClient.sendSMS(client.getPhone(), SMS_EXPOFORCE_SENDER_NAME, message, authorizationHeader);
                log.info("Got response: {}", smsResponse.toString());
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        });
    }

    @Async
    @SneakyThrows
    public void sendEmail(List<String> clientAddresses, String messageText) {
        InputStream resourceAsStream = this.getClass()
                .getClassLoader().getResourceAsStream("email-content.html");
        String text = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);

        for (String address : clientAddresses) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setFrom(EMAIL_EXPOFORCE_SENDER_ADDRESS);
                helper.setSubject(SUBJECT);
                helper.setText(text, Boolean.TRUE);
                helper.setTo(address);
                mailSender.send(message);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        log.info("Sent succesfully to {} addresses(s)", clientAddresses.size());

    }

    private String getBasicAuthenticationHeader() {
        String valueToEncode = smsLogin + ":" + smsApiKey;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
