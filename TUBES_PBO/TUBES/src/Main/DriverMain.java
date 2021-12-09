package Main;

import static Menu.MainMenu.*;
import Account.*;
import Product.*;
import Order.*;
import java.util.*;

public class DriverMain {

    public static void main(String[] args) throws InterruptedException {
        // Create Object
        Admin admin = new Admin("admin baik", "admin", "password");
        Customer user;
        ArrayList<Customer> userList = new ArrayList<Customer>();
        ArrayList<Anjing> anjingList = new ArrayList<Anjing>();
        ArrayList<Kucing> kucingList = new ArrayList<Kucing>();
        ArrayList<Aksesoris> accList = new ArrayList<Aksesoris>();
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        // Add Object (Hardcode)
        Customer c1 = new Customer("abang", "di rumah", "0812345", "abang", "pass123");
        Customer c2 = new Customer("kokorobet", "di sana", "0831246", "koko", "pass123");
        userList.add(c1);
        userList.add(c2);
        Anjing a1 = new Anjing(1, 5000, 4, "buldog", "bobi", "L");
        Anjing a2 = new Anjing(2, 4000, 2, "husky", "lola", "P");
        Anjing a3 = new Anjing(3, 4000, 2, "labrador", "joni", "L");
        Anjing a4 = new Anjing(4, 4000, 2, "doberman", "bili", "P");
        anjingList.add(a1);
        anjingList.add(a2);
        anjingList.add(a3);
        anjingList.add(a4);
        Kucing k1=new Kucing(1, 5000, 4, "anggora", "lala", "P");
        Kucing k2=new Kucing(2, 5000, 4, "spink", "berus", "L");
        Kucing k3=new Kucing(3, 5000, 4, "persia", "oren", "L");
        Kucing k4=new Kucing(4, 5000, 4, "bengal", "lili", "P");
        kucingList.add(k1);
        kucingList.add(k2);
        kucingList.add(k3);
        kucingList.add(k4);
        Aksesoris acc1 = new Aksesoris("Leash", 1, 10, 1000, "tali ikat untuk perliharaan");
        Aksesoris acc2 = new Aksesoris("Chew", 2, 10, 2000, "mainan kunyah untuk peliharaan");
        accList.add(acc1);
        accList.add(acc2);
        
        Order o1 = new Order(c1);
        o1.addAnjing(a3);
        o1.addKucing(k1);
        o1.addAcc(acc1);
        
       Order o2 = new Order(c2);
       o2.addAnjing(a2);
       
       userList.get(0).addListOrder(o1);
       userList.get(1).addListOrder(o2);
        
        /* Login Admin 
        *  admin | password
        *  
        *  Login Customer
        *  abang | pass123
        */
        
        initMenu(admin, userList, anjingList, kucingList, accList, orderList);
    }
    
}
