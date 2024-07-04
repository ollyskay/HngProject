package com.example.HNG.project.one;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public HelloResponse sayHello(@RequestParam String visitor_name, HttpServletRequest request) throws IOException{
        String clientIp = request.getRemoteAddr();
        String city = "New York";
        int temperature = 11;

        String greeting = "Hello, " + visitor_name + "!, the temperature is " + temperature + "degree Celsius in " + city;
        return new HelloResponse(clientIp, city, greeting);
    }

    static class HelloResponse{
        private String client_ip;
        private String location;
        private String greeting;

        public HelloResponse(String client_ip, String location, String greeting ){
            this.client_ip = client_ip;
            this.location = location;
            this.greeting = greeting;

        }

        public String getClient_ip() { return client_ip; }
        public void setClient_ip(String client_ip) { this.client_ip = client_ip; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }

        public String getGreeting() { return greeting; }
        public void setGreeting(String greeting) { this.greeting = greeting; }
    }
}

