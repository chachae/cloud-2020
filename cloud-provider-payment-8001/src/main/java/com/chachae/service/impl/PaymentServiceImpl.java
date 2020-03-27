package com.chachae.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.PaymentDAO;
import com.chachae.entity.Payment;
import com.chachae.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author chachae
 * @since 2020/3/27 17:06
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentDAO, Payment>
    implements PaymentService {}
