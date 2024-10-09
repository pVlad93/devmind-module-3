import beans.JavaTeacher;
import beans.MathTeacher;
import interfaces.ITeacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TheSpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JavaTeacher javaTeacher = context.getBean("javaTeacher", JavaTeacher.class);
        System.out.println("javaTeacher's homework: " + javaTeacher.getHomework());
        System.out.println("javaTeacher's age: " + javaTeacher.getAge());
        System.out.println("javaTeacher's workplace: " + javaTeacher.getWorkPlace());
        System.out.println("javaTeacher's wisdom: " + javaTeacher.getWisdom());

        ITeacher mathTeacher = context.getBean("mathTeacher", MathTeacher.class);
        System.out.println("mathTeacher's wisdom: " + mathTeacher.getWisdom());

        context.close();
    }
}
