package com.chachae.security.uaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.security.uaa.entity.Employee;
import java.util.List;

/**
 * @author chachae
 * @since 2020/4/21 21:36
 */
public interface EmployeeService extends IService<Employee> {

  Employee findByUsername(String username);

  List<String> findByEmployeeId(Long employeeId);

}
