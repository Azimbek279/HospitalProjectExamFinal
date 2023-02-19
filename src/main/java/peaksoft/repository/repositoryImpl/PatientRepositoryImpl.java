package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.model.Hospital;
import peaksoft.model.Patient;
import peaksoft.repository.HospitalRepository;
import peaksoft.repository.PatientRepository;

import java.util.List;

@Repository
@Transactional
public class PatientRepositoryImpl implements PatientRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final HospitalRepository hospitalRepository;

    public PatientRepositoryImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Patient> getAllPatient(Long patientId) {
        return entityManager.createQuery("select p from Patient p where p.hospital.id=:patientId",
                Patient.class).setParameter("patientId",patientId).getResultList();
    }

    @Override
    public void savePatient(Patient patient, Long hospitalId) {
        Hospital hospital = hospitalRepository.getHospitalById(hospitalId);
        patient.setHospital(hospital);
        hospital.addPatient(patient);
        entityManager.merge(patient);

//        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
//        hospital.addPatient(patient);
//        patient.setHospital(hospital);
//
////        entityManager.merge(patient);
//        entityManager.merge(patient);

//        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
//        patient.setHospital(hospital);
//        hospital.addPatient(patient);

    }

    @Override
    public Patient getPatientById(Long id) {
        return entityManager.find(Patient.class,id);
    }

    @Override
    public void deletePatientById(Long id) {
        entityManager.remove(entityManager.find(Patient.class,id));
    }

    @Override
    public void updatePatient(Long patientId, Patient patient) {
        Patient patient1 = entityManager.find(Patient.class, patientId);
        patient1.setFirstName(patient.getFirstName());
        patient1.setLastName(patient.getLastName());
        patient1.setEmail(patient.getEmail());
        patient1.setEmail(patient.getPhoneNumber());
//        patient1.setGender(patient.getGender());
        entityManager.merge(patient);
    }
}
