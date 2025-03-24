package application;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;


public class Program {
    public static void main(String[] args) {

        Department department = new Department(1,"Books");

        Seller seller = new Seller(1,"Rafael","rafaelmeloni@gmail.com",new Date(),4000.50,department);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);


    }
}
