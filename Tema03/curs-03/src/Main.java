import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAnimal theCat = context.getBean("theCat", IAnimal.class);
        IAnimal theMouse = context.getBean("theMouse", IAnimal.class);

        System.out.println(theCat.makeSound());
        System.out.println(theMouse.makeSound());

        Cat theNamedCat = context.getBean("theNamedCat", Cat.class);
        System.out.println("The cat with a name: " + theNamedCat.getAnimalName());
    }
}
