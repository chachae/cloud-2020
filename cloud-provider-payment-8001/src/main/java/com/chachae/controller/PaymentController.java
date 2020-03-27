package com.chachae.controller;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import com.chachae.service.PaymentService;
import org.springframework.web.bind.annotation.*;

/**
 * @author chachae
 * @since 2020/3/27 17:11
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/create")
  public Result<Boolean>creat(@RequestBody Payment payment) {
    boolean res = this.paymentService.save(payment);
    return new Result<>(200, "插入成功", res);
  }

  @GetMapping("/get/{id}")
  public Result<Payment> get(@PathVariable Long id) {
    Payment res = this.paymentService.getById(id);
    return new Result<>(200, "查询成功", res);
  }
}
