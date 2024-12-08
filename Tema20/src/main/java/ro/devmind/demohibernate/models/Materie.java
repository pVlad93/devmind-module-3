package ro.devmind.demohibernate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "materii")
@Getter
@Setter
public class Materie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    @JsonIgnore
    private Profesor profesor;

    @ManyToMany(mappedBy = "materii")
    @JsonIgnore
    private Set<Student> student;

    @Override
    public String toString() {
        return "Materie{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }
}
