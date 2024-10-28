package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Motocicleta implements Automobil{

    @Value("${motocicleta.brand.name}")
    private String brand;

    private Motor motor;
    public Motocicleta() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Motor getMotor() {
        return motor;
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public void travel() {
        System.out.println("Motorcycle travelling");
    }

    @Override
    public int maxDrivingSpeed() {
        return 170;
    }
}
