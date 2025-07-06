package com.johar.test.algorithm.array;

import org.springframework.util.StringUtils;
import sun.misc.LRUCache;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * @ClassName: ArrayListTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2023/2/6 18:46
 * @Since: 1.0.0
 */
public class ArrayListTest {

    public static void main1(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person(1, "Johar");
        Person p2 = new Person(2, "Bob");
        Person p3 = new Person(3, "Smith");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        //浅拷贝
        //List<Person> copy = new ArrayList<>(personList);

        //浅拷贝
        List<Person> copy = new ArrayList<>();
        copy.addAll(personList);
        for (Person p : copy){
            p.setId(p.getId() + 1);
        }
        personList.stream().forEach(System.out::println);

        List<Person>  ps = new LinkedList<>();

        //LRUCache

    }

    public static void main(String[] args) {
        List<String> personList = new ArrayList<>();
        personList.add("Johar");
        personList.add("Bob");
        personList.add("Smith");

        //浅拷贝
        //List<Person> copy = new ArrayList<>(personList);

        //浅拷贝
        List<String> copy = new ArrayList<>();
        copy.addAll(personList);
        for (int i = 0; i < copy.size(); i++){
            copy.set(i, copy.get(i).toLowerCase());
        }
        personList.stream().forEach(System.out::println);
        copy.stream().forEach(System.out::println);
    }

    private static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}