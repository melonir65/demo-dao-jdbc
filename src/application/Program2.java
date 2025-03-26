package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== Test 1: update ====");
        Department department = new Department(null,"Games");
        departmentDao.insert(department);
        System.out.println("Inserted new  id = " + department.getId());

        System.out.println("\n==== Test 2: Department findById ====");
        department = departmentDao.findById(2);
        System.out.println(department);


        System.out.println("\n==== Test 3: Department findById ====");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list ){
            System.out.println(obj);
        }


        System.out.println("\n==== Test 4: update ====");
        department = departmentDao.findById(1);
        department.setName("Boardgames");
        departmentDao.update(department);
        System.out.println("Update completed");

        System.out.println("\n==== Test 5: Department delete ====");
        System.out.print("Enter id for delete test: ");
        int id = scanner.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

    }
}
