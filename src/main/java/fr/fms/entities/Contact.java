package fr.fms.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private String phone;
    private String photo;

    @ManyToOne
    private Category category;

}
