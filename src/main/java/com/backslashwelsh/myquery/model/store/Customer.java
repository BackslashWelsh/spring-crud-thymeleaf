package com.backslashwelsh.myquery.model.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
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

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @DateTimeFormat // TODO: 06.11.2021 change to custom. If is it better LocalDate
    private LocalDate birthDate;

    private String phone;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    @Length(max = 2)
    private String state;

    @Max(11)
    private int points;

}
