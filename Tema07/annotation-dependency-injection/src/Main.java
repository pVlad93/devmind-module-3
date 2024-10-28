import beans.Autocar;
import beans.Automobil;
import beans.CarCollection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CarCollection carCollection = context.getBean("carCollection", CarCollection.class);

        Automobil autocar = carCollection.getAutocar();
        autocar.travel();
        System.out.println(autocar.getBrand());
        System.out.println(autocar.getMotor().getPutere());


        Automobil masina = carCollection.getMasina();
        masina.travel();
        System.out.println(masina.getBrand());
        System.out.println(masina.getMotor().getPutere());

        Automobil mutocicleta = carCollection.getMotocicleta();
        mutocicleta.travel();
        System.out.println(mutocicleta.getBrand());
        System.out.println(masina.getMotor().getPutere());
    }
}
