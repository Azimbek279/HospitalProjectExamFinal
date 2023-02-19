package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Appointment;
import peaksoft.repository.AppointmentRepository;
import peaksoft.service.AppointmentService;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointment(Long appointmentId) {
        return appointmentRepository.getAllAppointment(appointmentId);
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        appointmentRepository.saveAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.getAppointmentById(id);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteAppointmentById(id);
    }

    @Override
    public void updateAppointment(Long appointmentId, Appointment appointment) {
        appointmentRepository.updateAppointment(appointmentId,appointment);
    }
}
