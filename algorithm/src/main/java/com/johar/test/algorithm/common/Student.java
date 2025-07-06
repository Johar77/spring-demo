package com.johar.test.algorithm.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Student
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/5/7 22:56
 * @Since: 1.0.0
 */
public class Student extends Person {

    private long id;

    public String name;

    private void dowork(){
        System.out.println("student do work");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    //    public static void doTask(){
//        System.out.println("student do task");
//    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1L;
        s1.name = "Johar";
        s1.dowork();
        Student.doTask();
        System.out.println(s1);

        Student s2 = new Student();
        s2.id = 2L;
        s2.name = "Johar2";

        Set set = new  HashSet();
        set.add(s1);
        set.add(s2);

        s2.name = "Lynn";
        set.remove(s2);

        System.out.println(set.size());


    }
}