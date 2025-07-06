package com.johar.mybatis.mybatistest.controller;

import com.johar.mybatis.mybatistest.dto.CreateUserDTO;
import com.johar.mybatis.mybatistest.po.Student;
import com.johar.mybatis.mybatistest.po.User;
import com.johar.mybatis.mybatistest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @ClassName: StudentController
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/4/12 22:25
 * @Since: 1.0.0
 */
@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/update")
    public Student addUser(@Valid @RequestBody Student dto){
        return studentService.update(dto);
    }
}