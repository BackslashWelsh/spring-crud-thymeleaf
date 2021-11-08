package com.backslashwelsh.myquery.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @DateTimeFormat
    private LocalDate birthDate;

    private String phone;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    @Length(max = 2)
    private String state;

    @NotNull
    @Max(11)
    private int points;

}
