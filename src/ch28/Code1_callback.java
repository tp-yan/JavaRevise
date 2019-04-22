package ch28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: tp
 * @Date: 2019/4/21 9:57
 * @Description: 什么是回调函数？
 * 定义：一个通过函数指针调用的函数，即成为回调函数。
 * 把函数的指针(即函数地址)作为参数传递给另一个函数，当这个指针被用来调用其所指向的函数时，这就是所谓的“回调”函数。
 * 回调函数不是由该函数的实现方直接调用的，而是在特定的事件或条件发生时由另一方调用的，用于对该事件或条件进行响应。
 * 一般我们编写的回调函数是被系统调用的！
 * 回调的基本过程：
 * 当A调用B的某个函数时，B由于信息不足，需要由A来传入一个函数，B在执行它的方法时会调用A传入的函数。
 * 本来A是调用B，现在B又需要调用A的一个函数来完成自己的任务，该函数因而被称为回调函数。
 * <p>
 * 回调函数的实现机制：
 * (1)定义一个回调函数
 * (2)将回调函数的函数指针注册给调用者(B)（例如之前的库函数）
 * (3)当特定的事件或条件发生时，调用者使用函数指针调用回调函数对事件进行处理
 * 在Java中没有函数指针，故通过定义接口的方法来实现回调函数的传递
 */

class Student {
    public int age;
    public int height;
    public int weight;

    public Student(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}

class MakeStudent {

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(16, 164, 56));
        students.add(new Student(15, 174, 50));
        students.add(new Student(17, 184, 64));
        return students;
    }
}

public class Code1_callback {
    public static void main(String[] args) {
        MakeStudent makeStudent = new MakeStudent();
        List<Student> students = makeStudent.getStudents();

        Collections.sort(students, new Comparator<Student>() {  // 这里采用匿名内部类的形式
            // Comparator接口：因为Java中没有指针的概念，所以由接口来提供回调函数
            // compare函数，即回调函数，由我们实现，系统来调用
            // 我们提供的回调函数其实是提供Collections.sort关于排序的额外信息
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
    }
}
