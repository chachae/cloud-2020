package com.chachae.security.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/4/23 17:43
 */

@RestController
public class OrderController {

  @GetMapping("/r1")
  @PreAuthorize("hasAuthority('employee:list')")
  public String r1() {
    return "访问资源 1";
  }

}
