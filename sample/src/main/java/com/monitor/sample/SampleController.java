package com.monitor.sample;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private static final Logger logger = Logger.getLogger(SampleController.class.getName());
    @GetMapping("/")
    public String hello(HttpServletResponse response) throws IOException {
        logger.info("Ateemted access to / endpoint result in 403 Forbidden");
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denined");
        return null;
    }

    @PostMapping("/submit")
    public String handleFormSubmit(
        @RequestParam("name") String name, @RequestParam("_csrf") String csrfToken
    ) {
        System.out.println("Received CSRF token: " + csrfToken);
        System.out.println("Received name: " + name);
        return "result";
    }
}
