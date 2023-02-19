package peaksoft.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Department;
import peaksoft.repository.DepartmentRepository;
import peaksoft.service.DepartmentService;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartment(Long departmentId) {
        return departmentRepository.getAllDepartment(departmentId);
    }

    @Override
    public void saveDepartment(Department department, Long hospitalId) {
        departmentRepository.saveDepartment(department,hospitalId);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteDepartmentById(id);
    }

    @Override
    public void updateDepartment(Long departmentId, Department department) {
        departmentRepository.updateDepartment(departmentId,department);
    }
}
