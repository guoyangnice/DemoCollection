package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by 菩提树下的杨过 on 05/09/2017.
 */
public class OOMTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        int max = 10000;
        List list = new ArrayList<>(max);
        for (int j = 0; j < max; j++) {
            Person p = new Person();
            p.setAge(100);
            p.setName("菩提树下的杨过");
            list.add(p);
        }
        System.out.println("ready!");
        latch.await();
    }

    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}