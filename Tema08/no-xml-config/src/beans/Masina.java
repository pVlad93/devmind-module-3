package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Masina implements Automobil{
    @Value("${masina.brand.name}")
    private String brand;

    private Motor motor;
    public Masina() {

    }

    @Autowired
    public Masina(Motor motor) {
        this.motor = motor;
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

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public void travel() {
        System.out.println("Car travelling");
    }

    @Override
    public int maxDrivingSpeed() {
        return 180;
    }
}
