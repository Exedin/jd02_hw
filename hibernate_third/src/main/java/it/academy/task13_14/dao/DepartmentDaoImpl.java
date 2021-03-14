package it.academy.task13_14.dao;

import it.academy.task13_14.entity.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmetDao {

    @PersistenceContext(name = "entityManagerFactory")
    EntityManager entityManager;


    @Override
    public Department getDepartmentById(String id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> getDepartments() {
        Query query = entityManager.createQuery("SELECT dep FROM Department AS dep", Department.class);
        return query.getResultList();
    }

    @Override
    public String saveOrUpdateDepartment(Department department) {
        return entityManager.merge(department).getId();
    }

    @Override
    public String deleteDepartment(Department department) {
        String id = department.getId();
        entityManager.remove(department);
        return id;
    }


}
