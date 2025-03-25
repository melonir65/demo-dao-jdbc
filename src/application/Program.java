package application;


import model.dao.DaoFactory;
import model.dao.SellerDao;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== Test 1: Seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n==== Test 2: Seller findByDepartmentId ====");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list){
            System.out.println(s);
        }

        System.out.println("\n==== Test 3: Seller findAll ====");
        list = sellerDao.findAll();
        for (Seller s : list){
            System.out.println(s);
        }

        System.out.println("\n==== Test 4: Seller insert ====");
        Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4050.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted new id = "+ newSeller.getId());

        System.out.println("\n==== Test 5: Seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Rafael Meloni");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n==== Test 6: Seller Delete ====");
        System.out.print("Enter id for delete test: ");
        int id = scanner.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");


        scanner.close();
    }
}
