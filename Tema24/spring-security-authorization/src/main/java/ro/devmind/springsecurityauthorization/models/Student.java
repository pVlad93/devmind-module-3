package ro.devmind.springsecurityauthorization.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "studenti")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nume")
    private String name;

    @Column(name = "prenume")
    private String firstName;

    @Column(name = "cnp")
    private String cnp;

    @OneToOne
    @JoinColumn(name = "id_adresa")
    @JsonIgnore
    private Adresa adresa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "studenti_to_materii",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_materie")
    )
    @JsonIgnore
    private Set<Materie> materii;
}
