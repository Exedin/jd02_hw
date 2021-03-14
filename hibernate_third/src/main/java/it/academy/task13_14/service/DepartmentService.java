package it.academy.task13_14.service;

import it.academy.task13_14.dao.DepartmetDao;
import it.academy.task13_14.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmetDao departmetDao;

    @Transactional
    public Department getDepartmentById(String id){
        return  departmetDao.getDepartmentById(id);
    }

    @Transactional
    public List<Department> getDepartment(){
        return departmetDao.getDepartments();
    }


    @Transactional
    public String saveDepartment(Department department){
        return departmetDao.saveOrUpdateDepartment(department);
    }

    @Transactional
    public String deleteDepartment(String id){
        final Department departmentById = departmetDao.getDepartmentById(id);
        return  departmetDao.deleteDepartment(departmentById);
    }

}

