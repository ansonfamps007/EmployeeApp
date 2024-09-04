package com.app.employee.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@RestController
public class TestController {

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public RseponseBean healthCheck(@RequestParam(name = "format", required = false) String format) {
        RseponseBean reRseponseBean = new RseponseBean();
        if ((null == format || format.isBlank()) || (!format.equals("short") && !format.equals("full"))) {
            reRseponseBean.setStatus("Bad Request");

        } else if (format.equals("short")) {
            reRseponseBean.setStatus("OK");
        } else if (format.equals("full")) {
            reRseponseBean.setStatus("OK");
            reRseponseBean.setCurrentTime(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
        }
        return reRseponseBean;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    class RseponseBean {

        private String status;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String currentTime;

    }

}
