package ro.devmind.springsecurityauthorization.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "adrese_studenti")
@Getter
@Setter
@ToString(exclude = "student")
public class Adresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "strada")
    private String street;

    @Column(name = "numar")
    private String number;

    @Column(name = "localitate")
    private String city;

    @OneToOne(mappedBy = "adresa")
    private Student student;
}
