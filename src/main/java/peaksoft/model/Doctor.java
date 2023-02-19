package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctors_seq")
    @SequenceGenerator(name = "doctors_seq",
            sequenceName = "doctors_seq",
            allocationSize = 1)
    private Long id;

    private String firstName;

    private String lastName;

    private String position;

    private String email;

    @OneToMany(cascade = {REFRESH,MERGE,PERSIST,DETACH},fetch = FetchType.EAGER,mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    @ManyToMany(cascade = {REFRESH,MERGE,PERSIST,DETACH},fetch = FetchType.EAGER,mappedBy = "doctors")
    private List<Department> departments = new ArrayList<>();

    @ManyToOne(cascade = {REFRESH,MERGE,DETACH},fetch = FetchType.EAGER)
    private Hospital hospital;

}
