package ro.devmind.demohibernate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String strada;

    @Column(name = "numar")
    private String numar;

    @Column(name = "localitate")
    private String localitate;

    @OneToOne(mappedBy = "adresa")
    private Student student;
}
