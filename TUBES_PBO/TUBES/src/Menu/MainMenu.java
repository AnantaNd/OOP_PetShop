package Menu;

import Account.*;
import Product.*;
import Order.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    
    // Misc
    /* Clear Console (CMD) */
    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException E) {
            System.out.println(E);
        }
    }
    
    public static void initMenu(Admin admin, ArrayList<Customer> user, ArrayList<Anjing> L_anjing, ArrayList<Kucing> L_kucing, ArrayList<Aksesoris> L_acc, ArrayList<Order> L_order) throws InterruptedException{
        Customer customer;
        int input;
        do{
            cls();
            Scanner scan = new Scanner(System.in);
            System.out.println("=== [PetShop Application] ===");
            System.out.println("[1] Log in");
            System.out.println("[2] Register");
            System.out.println("[0] Exit");
            System.out.println("--------------------");
            System.out.print("Your Input >> ");
            input = scan.nextInt();
            switch(input){    
        /*------------------------------------------------------------------- LOGIN VIEW ------------------------------------------------------------------------------*/
                    case 1:
                        cls();
                        String username, pass;
                        boolean valid_login = false;
                        System.out.println("### Log In ### ");
                        System.out.println("----------------------");
                        // Loop selama valid_login = true
                        do{
                            System.out.print("Username : ");
                            username = scan.next();
                            System.out.print("Password : ");
                            pass = scan.next();

                            // Validasi Admin, jika benar ke "admin.menu"
                            if(admin.isAdmin(username, pass)){
                                valid_login = true;
                                admin.menu(user, L_anjing, L_kucing, L_acc, L_order);
                            } else {
                                // Validasi Customer dengan mencari di List Customer dan mencocokan username dan password
                                // Setelah itu direct ke "user.menu"
                                for (Customer us : user){
                                    if(username.equals(us.getUser()) && pass.equals(us.getPassword())){
                                        customer = us;
                                        valid_login = true;
                                        customer.menu(L_anjing, L_kucing, L_acc);
                                    } else {
                                        System.out.println("Akun salah/tidak terdaftar!\n");
                                        System.out.println("[1] Lanjutkan | [2] Back ");
                                        System.out.print(">> ");
                                        int pil = scan.nextInt();
                                        switch(pil){
                                            case 1:
                                                cls();
                                                break;
                                            case 2:
                                                valid_login = true;
                                        }
                                    }
                                }
                            }
                        } while (!valid_login);
                        break;
        /*------------------------------------------------------------------- REGISTER VIEW ------------------------------------------------------------------------------*/
                    case 2:
                        cls();
                        String nama, alamat, no_hp;

                        System.out.println("### Register ###");
                        System.out.println("----------------------");
                        System.out.print("Nama : ");
                        nama = scan.next();
                        System.out.print("Alamat : ");
                        alamat = scan.next();
                        System.out.print("No Hp : ");
                        no_hp = scan.next();
                        System.out.print("Username : ");
                        username = scan.next();
                        System.out.print("Password : ");
                        pass = scan.next();

                        // Register/Buat Customer lalu dimasukkan ke List User dan Direct ke "user.menu"
                        customer = new Customer(nama, alamat, no_hp, username, pass);
                        user.add(customer);
                        System.out.println("Thanks for registering! please wait, we will redirect to menu ...");
                        Thread.sleep(2500);
                        customer.menu(L_anjing, L_kucing, L_acc);
                        break;
                    case 0:
                        System.out.println("See you ...");
                        System.exit(0);
                        break;
                }
        } while(input != 0);
    }
}
