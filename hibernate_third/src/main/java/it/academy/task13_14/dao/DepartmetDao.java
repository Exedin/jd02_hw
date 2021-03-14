package it.academy.task13_14.dao;

import it.academy.task13_14.entity.Department;

import java.util.List;

public interface DepartmetDao {

    Department getDepartmentById(String id);

    List<Department> getDepartments();

    String saveOrUpdateDepartment(Department department);

    String deleteDepartment(Department department);
}
