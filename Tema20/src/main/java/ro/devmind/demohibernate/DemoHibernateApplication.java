package ro.devmind.demohibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.devmind.demohibernate.repositories.StudentRepository;

@SpringBootApplication
public class DemoHibernateApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) {
//        studentRepository.findAllByAdresa_CityOrderByIdDesc("Bucuresti").forEach(System.out::println);
    }
}
