package com.chachae.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/3/31 23:26
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @GetMapping("/nacos/{id}")
  public String getPayment(@PathVariable("id") Integer id) {
    return "nacos register, server-port=" + serverPort + "\t id:" + id;
  }
}
