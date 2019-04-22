package ch28;

import java.util.List;

/**
 * @Author: tp
 * @Date: 2019/4/21 10:12
 * @Description: 使用回调函数的全部过程：模拟实现自己的函数A和系统库函数B
 */

interface IAttributeGetter {
    // 定义回调函数
    public int getAttribute(Student student);
}

public class Code2_callback {
    // 模拟库函数B，实现回调函数的注册，即传入接口对象
    public static float calculateAvg(List<Student> students, IAttributeGetter getter) {
        float sum = 0;
        for (Student student : students) {
            sum += getter.getAttribute(student);
        }
        return sum / students.size();
    }

    // 模拟自己的函数A
    public static void main(String[] args) {
        MakeStudent makeStudent = new MakeStudent();
        List<Student> students = makeStudent.getStudents();

        // 因为学生有三个属性，所以必须由我们告诉(传入接口实现)calculateAvg计算哪个属性，而calculateAvg本身没有决定使用哪个属性
        float avgAge = calculateAvg(students, new IAttributeGetter() { // 传入实际的回调函数实现
            @Override
            public int getAttribute(Student student) {
                return student.age;     // 实现学生平均年龄的计算
            }
        });

        float avgHeight = calculateAvg(students, new IAttributeGetter() {
            @Override
            public int getAttribute(Student student) {
                return student.height;   // 实现学生平均身高的计算
            }
        });

        float avgWeight = calculateAvg(students, new IAttributeGetter() {
            @Override
            public int getAttribute(Student student) {
                return student.weight;
            }
        });

        System.out.println("Average age:" + avgAge);
        System.out.println("Average height:" + avgHeight);
        System.out.println("Average weight:" + avgWeight);
    }
}


