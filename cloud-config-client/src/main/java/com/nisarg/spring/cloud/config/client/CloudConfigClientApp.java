package com.nisarg.spring.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope
@RestController
public class CloudConfigClientApp {

  @Value("${user.role}")
  private String role;

  public static void main(String[] args) {
    SpringApplication.run(CloudConfigClientApp.class, args);
  }

  @RequestMapping(value = "/whoami/{username}", method = RequestMethod.GET,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public String whoami(@PathVariable("username") String username) {
    return String.format("Hello! You 're %s and you' ll become a %s...\n ", username, role);
  }
}
