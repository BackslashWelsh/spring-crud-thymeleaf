package com.backslashwelsh.myquery.model.office;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String jobTitle;

    @Min(5)
    private int salary;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reports_to", nullable = true)
    @ToString.Exclude
    private Employee reportsTo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    @ToString.Exclude
    private Office officeId;


}
