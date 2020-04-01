package com.chachae.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/4/1 18:29
 */
@RestController
public class FlowLimitController {

  @GetMapping("/testA")
  public String getA() {
    return "A";
  }

  @GetMapping("/testB")
  public String getB() {
    return "B";
  }
}
