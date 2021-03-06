package it.academy.dao;


import it.academy.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    SessionFactory sessionFactory;

    @Autowired
    DepartmentDaoImpl departmentDaoImpl;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployeeWithoutDepartment() {
        List<Employee> employees = sessionFactory
                .openSession()
                .createQuery("from Employee where D_ID is null", Employee.class)
                .list();

        return employees;
    }

    @Override
    public String createEmployee(Employee employee) {
        String save = (String) sessionFactory.getCurrentSession().save(employee);
        return save;
    }


    @Override
    public void delete(String id) {
        Employee employee = sessionFactory.getCurrentSession()
                .get(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);

    }


    @Override
    public Employee getOneEmployee(String id) {
        Employee employee=sessionFactory.openSession().get(Employee.class, id);
        System.out.println(employee);
        return employee;
    }

    @Override
    public void removeEmployeeFromDepartment(String id) {
        sessionFactory
                .getCurrentSession()
                .createSQLQuery("update personnel_management.T_EMP set D_ID=null where E_ID='"+id+"';")
                .executeUpdate();

    }

    @Override
    public void addEmployeeToDepartment(String employeeId, String departmentId) {
        sessionFactory
                .getCurrentSession()
                .createSQLQuery("update personnel_management.T_EMP set D_ID='"+departmentId+"' where E_ID='"+employeeId+"';")
                .executeUpdate();
    }

}
