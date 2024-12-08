package ro.devmind.demohibernate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "profesori")
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Materie> materii;

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", name='" + nume + '\'' +
                ", materii=" + materii +
                '}';
    }
}
