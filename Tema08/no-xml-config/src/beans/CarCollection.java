package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarCollection {

    @Autowired
    private Autocar autocar;
    private Masina masina;
    private Motocicleta motocicleta;

    public CarCollection() {

    }

    @Autowired
    public CarCollection(Masina masina) {
        this.masina = masina;
    }

    public Autocar getAutocar() {
        return autocar;
    }

    public Masina getMasina() {
        return masina;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    @Autowired
    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }
}
