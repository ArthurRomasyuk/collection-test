package list_test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 5; i++) {
            User user = new User("name" + i);
            list.add(user);
        }

        System.out.println(list.toString());
        printCollection(list);
        System.out.println("size = " + list.size());
        list.add(3, new Object());
        printCollection(list);
        System.out.println("size = " + list.size());


    }

   static void printCollection(List list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}


class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}