package com.johar.mybatis.mybatistest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.johar.mybatis.mybatistest.po.Student;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StudentService
 * @Description: TODO
 * @Author: Johar
 * @Date: 2024/4/12 22:18
 * @Since: 1.0.0
 */
@Service
public class StudentService extends ServiceImpl<com.johar.mybatis.mybatistest.mapper.StudentMapper, Student> implements IStudentService{


    public Student update(Student student){
        super.saveOrUpdate(student);
        return super.getById(student.getId());
    }
}