package it.academy.service;

import it.academy.dao.DepartmentDao;
import it.academy.dao.EmployeeDao;
import it.academy.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeDao employeeDao;

    @Transactional(readOnly = true)
    public Department getOneDepartment(String id){
        return departmentDao.getOneDepartment(id);
    }

    @Transactional(readOnly = true)
    public List<Department> getAllDepartment(){
        List<Department> allDepartment = departmentDao.getAllDepartment();
        return allDepartment;
    }

    @Transactional
    public void deleteDepartment (String id){
        final Department oneDepartment = departmentDao.getOneDepartment(id);
        oneDepartment.getEmployeeList().stream().forEach(employee -> employeeDao.removeEmployeeFromDepartment(employee.getId()));
        departmentDao.deleteDepartment(id);
    }

    @Transactional
    public String createDepartment (Department department){
        String save = departmentDao.createDepartment(department);
        return save;
    }



}
