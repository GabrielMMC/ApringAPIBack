package br.com.si.CrudApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
public class PersonModelV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private long id;

    @Column(name = "full_name", nullable = false, length = 50)
    @Setter @Getter
    private String fullName;

    @Column(nullable = false, length = 50)
    @Setter @Getter
    private String email;

    @Column(nullable = false, length = 1)
    @Setter @Getter
    private String gender;


}
