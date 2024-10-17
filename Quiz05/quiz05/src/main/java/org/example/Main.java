package org.example;

import org.example.beans.Student;
import org.example.configuration.StudentConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);

        Student singletonStudent = context.getBean("student", Student.class);
        Student singletonStudent2 = context.getBean("student", Student.class);

        System.out.println(singletonStudent);
        System.out.println("Singleton comparison: " + (singletonStudent == singletonStudent2));

        Student prototypeStudent1 = context.getBean("prototypeStudent", Student.class);
        Student prototypeStudent2 = context.getBean("prototypeStudent", Student.class);

        System.out.println("Prototype comparison: " + (prototypeStudent1 == prototypeStudent2));

        context.close();
    }
}