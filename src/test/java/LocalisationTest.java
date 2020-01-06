import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocalisationTest {

    @Test
    public void moveDepartmentTest() {
        List<Department> departmentList1= new ArrayList<>();
        List<Department> departmentList2= new ArrayList<>();
        Localisation localisation1=new Localisation("Name1", "City1", departmentList1);
        Localisation localisation2=new Localisation("Name2","City2",departmentList2);
        Department department1=new Department("Department1 Name", DepartmentType.MARKETING);
        Department department2=new Department("Department1 Name", DepartmentType.HR);
        localisation1.addDepartment(department1);
        localisation2.addDepartment(department2);
        boolean result=false;
        try {
            assertTrue(localisation1.moveDepartment(localisation2, department1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void moveDepartmentTestFailed() {
        List<Department> departmentList1 = new ArrayList<>();
        List<Department> departmentList2 = new ArrayList<>();
        Localisation localisation1 = new Localisation("Name1", "City1", departmentList1);
        Localisation localisation2 = new Localisation("Name2", "City2", departmentList2);
        Department department1 = new Department("Department1 Name", DepartmentType.MARKETING);
        Department department2 = new Department("Department2 Name", DepartmentType.MARKETING);
        localisation1.addDepartment(department1);
        localisation2.addDepartment(department2);
        Throwable exception=assertThrows(Exception.class, () -> {
            localisation1.moveDepartment(localisation2, department1);
        });
        assertEquals("This type of department already exists in this localisation", exception.getMessage());
    }
}