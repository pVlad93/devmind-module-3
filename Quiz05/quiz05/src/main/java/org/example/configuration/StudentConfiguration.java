package org.example.configuration;

import org.example.beans.Student;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("org.example.beans")
//@PropertySource("classpath:config.properties")
public class StudentConfiguration {

    @Bean(name = "student")
    public Student getStudent() {
        return new Student("John", "Doe", 9.50);
    }

    @Bean(name = "prototypeStudent")
    @Scope(value = "prototype")
    public Student getPrototypeStudent() {
        Student student = new Student();
        student.setLastName("Mark");
        student.setFirstName("Peterson");
        student.setGrade(8.75);
        return student;
    }
}
