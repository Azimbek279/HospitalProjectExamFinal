package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.model.enums.Gender;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patient_id_gen")
    @SequenceGenerator(name = "patient_id_gen",
            sequenceName = "patient_seq",
            allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

//    private Gender gender;

    private String email;

    @ManyToOne(cascade = {REFRESH,MERGE,PERSIST})
    private Hospital hospital;

//    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "patient")
//    private List<Appointment> appointments = new ArrayList<>();


}
