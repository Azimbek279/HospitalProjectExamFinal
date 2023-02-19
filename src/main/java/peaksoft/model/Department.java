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
@Table(name = "departments")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "department_seq")
    @SequenceGenerator(name = "department_seq",
            sequenceName = "department_seq",
            allocationSize = 1)
    private Long id;

    private String name;

    @ManyToMany(cascade = {REFRESH,MERGE,PERSIST,DETACH},fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    @ManyToOne(cascade = {REFRESH,PERSIST,MERGE,DETACH},fetch = FetchType.EAGER)
    private Hospital hospital;


}
