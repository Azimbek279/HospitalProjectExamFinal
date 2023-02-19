package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Appointment;
import peaksoft.repository.AppointmentRepository;

import java.util.List;

@Repository
@Transactional
public class AppointmentRepositoryImpl implements AppointmentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public AppointmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Appointment> getAllAppointment(Long appointmentId) {
        return entityManager.createQuery("select a from Appointment a",Appointment.class).getResultList();
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return entityManager.find(Appointment.class,id);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        entityManager.remove(entityManager.find(Appointment.class,id));
    }

    @Override
    public void updateAppointment(Long appointmentId, Appointment appointment) {
        Appointment appointment1 = entityManager.find(Appointment.class, appointmentId);
        appointment1.setDate(appointment.getDate());
    }
}
