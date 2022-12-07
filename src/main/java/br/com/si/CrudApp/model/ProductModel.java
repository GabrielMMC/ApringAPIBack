package br.com.si.CrudApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private long id;

    @Column(nullable = false, length = 50)
    @Setter @Getter
    private String name;

    @Column(nullable = false, length = 50)
    @Setter @Getter
    private String brand;

    @Column(nullable = false)
    @Setter @Getter
    private Double value;


}
