package com.example.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cId;

    private  String cName;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk")
    private List<Product> productList;

}

