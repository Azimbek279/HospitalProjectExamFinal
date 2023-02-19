package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.model.Department;
import peaksoft.model.Hospital;
import peaksoft.repository.DepartmentRepository;

import java.util.List;
@Repository
@Transactional
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public DepartmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Department> getAllDepartment(Long departmentId) {
        return entityManager.createQuery("select d from Department d where d.hospital.id=:departmentId",
                Department.class).setParameter("departmentId",departmentId).getResultList();
    }

    @Override
    public void saveDepartment(Department department, Long hospitalId) {
        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
        hospital.addDepartment(department);
        department.setHospital(hospital);
        entityManager.merge(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        entityManager.remove(entityManager.find(Department.class,id));
    }

    @Override
    public void updateDepartment(Long departmentId, Department department) {
        Department department1 = entityManager.find(Department.class, departmentId);
        department1.setName(department.getName());
        entityManager.merge(department1);
    }
}
