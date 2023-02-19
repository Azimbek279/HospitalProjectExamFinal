package peaksoft.repository;

import peaksoft.model.Department;
import peaksoft.model.Doctor;

import java.util.List;

public interface DepartmentRepository {

    List<Department> getAllDepartment(Long departmentId);

    void saveDepartment(Department department, Long hospitalId);

    Department getDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    void updateDepartment(Long departmentId,Department department);

}
