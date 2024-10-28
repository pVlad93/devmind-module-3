package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("autocar")
public class Autocar implements Automobil {

    @Value("${autocar.brand.name}")
    private String brand;

    @Autowired
    private Motor motor;
    public Autocar() {

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
        System.out.println("Coach driving");
    }

    @Override
    public int maxDrivingSpeed() {
        return 99;
    }

}
