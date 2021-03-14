package it.academy.task13_14.service;

import it.academy.task13_14.config.MainConfig;
import it.academy.task13_14.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@ContextConfiguration(classes = MainConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceTest {


    @Autowired
    DepartmentService departmentService;

    @Test
    public void testDepartment() {
        Department department = new Department();
        department.setDescription("ingeneer");
        department.setName("ING");
        department.setPhone("+375291000000");
        String savedId = departmentService.saveDepartment(department);
        System.out.println(savedId);
        assertEquals("ING",departmentService.getDepartmentById(savedId).getName());
        final Department departmentById = departmentService.getDepartmentById(savedId);
        departmentService.deleteDepartment(departmentById.getId());
        assertNull(departmentService.getDepartmentById(savedId));

    }


}