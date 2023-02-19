package peaksoft.service;

import peaksoft.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAllDoctors(Long doctorId);

    void saveDoctor(Doctor doctor, Long hospitalId);

    Doctor getDoctorById(Long id);

    void deleteDoctorById(Long id);

    void updateDoctor(Long doctorId,Doctor doctor);
}
