package Account;

import static Menu.MainMenu.cls;
import Order.Order;
import Product.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Admin extends Akun{
    private String nama_admin;
    
    // Constructor
    public Admin(String nama_admin, String user, String pass){
        super(user,pass);
        this.nama_admin = nama_admin;
    }
    
    // Setter & Getter
    public void setNama_admin(String nama){this.nama_admin = nama;}
    public String getNama_admin(){return this.nama_admin;}
    
    // Validasi Admin
    public boolean isAdmin(String id, String pass){
        return getUser().equals(id) && getPassword().equals(pass);
    }
    
    @Override
    public void info(){
        System.out.println("Admin\t : " + getNama_admin());
    }

    // CRUD Admin
    public Anjing addAnjing(){
        String nama = null, jenis = null, gender;
        int id, adpt_fee, umur;

        Scanner scan = new Scanner(System.in);
        System.out.print(" ID HEWAN : ");
        id = scan.nextInt();
        scan.nextLine();
        
        System.out.print(" NAMA : ");
        nama = scan.nextLine();
        System.out.print(" USIA (th): ");
        umur = scan.nextInt();
        scan.nextLine();
        
        System.out.print(" JENIS : ");
        jenis = scan.nextLine();
        System.out.print(" KELAMIN (L/P) : ");
        gender = scan.nextLine();
        System.out.print(" FEE : ");
        adpt_fee = scan.nextInt();
        Anjing anj = new Anjing(id, adpt_fee, umur, jenis, nama, gender);
        return anj;
    }
    
    public Kucing addKucing(){
        String nama = null, jenis = null, gender;
        int id, adpt_fee, umur;

        Scanner scan = new Scanner(System.in);
        System.out.print(" ID : ");
        id = scan.nextInt();
        scan.nextLine();
        
        System.out.print(" NAMA : ");
        nama = scan.nextLine();
        System.out.print(" USIA (th): ");
        umur = scan.nextInt();
        scan.nextLine();
        
        System.out.print(" JENIS : ");
        jenis = scan.nextLine();
        System.out.print(" KELAMIN (L/P) : ");
        gender = scan.nextLine();
        System.out.print(" FEE : ");
        adpt_fee = scan.nextInt();
        Kucing kcg = new Kucing(id, adpt_fee, umur, jenis, nama, gender);
        return kcg;
    }
    
    public Aksesoris addAksesoris(){
        Scanner scan = new Scanner(System.in);
        String nama_barang = null, desc = null;
        int id_barang, qty, harga;
        
        System.out.print(" ID BARANG : ");
        id_barang = scan.nextInt();
        scan.nextLine();
        
        System.out.print(" NAMA BARANG : ");
        nama_barang = scan.nextLine();
        System.out.print(" DESKRIPSI BARANG : ");
        desc = scan.nextLine();
        System.out.print(" JUMLAH BARANG : ");
        qty = scan.nextInt();
        System.out.print(" HARGA BARANG : ");
        harga = scan.nextInt();
        
        Aksesoris acc = new Aksesoris(nama_barang, id_barang, qty, harga, desc);
        return acc;
    }
    
    public void editAnjing(ArrayList<Anjing> anjing){
        /* Edit dengan cara Search Nama Produk lalu di dicari indexnya dan masukkan ke temp untuk set list */
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama anjing yang di Edit : ");
        String key = scan.nextLine();
        int temp = searchAnjing(anjing, key);
        if (temp == -1){
            System.out.println("Data Anjing Tidak Ditemukan!");
        } else {
            anjing.set(temp, addAnjing());
            System.out.println("----------Berhasil Diubah----------");
        }
    }
    
    public void editKucing(ArrayList<Kucing> kucing){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama kucing yang di Edit : ");
        String key = scan.nextLine();
        int temp = searchKucing(kucing, key);
        if (temp == -1){
            System.out.println("Data Kucing Tidak Ditemukan!");
        } else {
            kucing.set(temp, addKucing());
            System.out.println("----------Berhasil Diubah----------");
        }
    }
    
    public void editAcc(ArrayList<Aksesoris> acc){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama aksesoris yang di Edit : ");
        String key = scan.nextLine();
        int temp = searchAcc(acc, key);
        if (temp == -1){
            System.out.println("Data Aksesoris Tidak Ditemukan!");
        } else {
            acc.set(temp, addAksesoris());
            System.out.println("----------Berhasil Diubah----------");
        }
    }
    
    public void deleteAnjing(ArrayList<Anjing> anjing){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama anjing yang akan di Hapus : ");
        String key = scan.nextLine();
        int temp = searchAnjing(anjing, key);
        if (temp == -1){
            System.out.println("Data Anjing Tidak Ditemukan!");
        } else {
            anjing.remove(temp);
            System.out.println("----------Berhasil di Hapus----------");
        }
    }
    
    public void deleteKucing(ArrayList<Kucing> kucing){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama kucing yang akan di Hapus : ");
        String key = scan.nextLine();
        int temp = searchKucing(kucing, key);
        if (temp == -1){
            System.out.println("Data Kucing Tidak Ditemukan!");
        } else {
            kucing.remove(temp);
            System.out.println("----------Berhasil di Hapus----------");
        }
    }
    
    public void deleteAcc(ArrayList<Aksesoris> acc){
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama aksesoris yang akan di Hapus : ");
        String key = scan.nextLine();
        int temp = searchAcc(acc, key);
        if (temp == -1){
            System.out.println("Data Aksesoris Tidak Ditemukan!");
        } else {
            acc.remove(temp);
            System.out.println("----------Berhasil di Hapus----------");
        }
    }
    
    public int searchAnjing(ArrayList<Anjing> anjing, String key){
        /* Search by Name */
        for(int i=0; i<anjing.size(); i++){
            if(anjing.get(i).getNama().equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public int searchKucing(ArrayList<Kucing> kucing, String key){
        for(int i=0; i<kucing.size(); i++){
            if(kucing.get(i).getNama().equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public int searchAcc(ArrayList<Aksesoris> acc, String key){
        for(int i=0; i<acc.size(); i++){
            if(acc.get(i).getNama_barang().equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    public int searchNoHp(ArrayList<Customer> user, String key){
        for(int i=0; i<user.size(); i++){
            if(user.get(i).getNohp().equals(key)){
                return i;
            }
        }
        return -1;
    }
    
    // Admin Menu
    public void menu(ArrayList<Customer> member, ArrayList<Anjing> anjing, ArrayList<Kucing> kucing, ArrayList<Aksesoris> acc, ArrayList<Order> order) throws InterruptedException{
        int input;
        do{
            cls();
            Scanner scan = new Scanner(System.in);
            System.out.println("=== [PetShop Admin Panel] ===");
            System.out.println("[1] Add Product");
            System.out.println("[2] Edit Product");
            System.out.println("[3] Delete Product");
            System.out.println("[4] View Product");
            System.out.println("[5] View Member");
            System.out.println("[6] Search Order");
            System.out.println("[7] Logout");
            System.out.println("--------------------");
            System.out.print("Your Input >> ");
            input = scan.nextInt();
            int pilihan;
            switch (input){
            case 1:
            /*------------------------------------------------------------------- ADD PRODUK ------------------------------------------------------------------------------*/
                    cls();
                do{
                    System.out.println("=== Add Product ===");
                    System.out.println("[1] Anjing | [2] Kucing | [3] Aksesoris | [4] Back");
                    System.out.print(">> ");
                    pilihan = scan.nextInt();
                    switch (pilihan){
                        case 1:
                            anjing.add(addAnjing());
                            System.out.println("--- Data Ditambahkan ---");
                            System.out.println("Please wait ...");
                            Thread.sleep(1000);
                            break;
                        case 2:
                            kucing.add(addKucing());
                            System.out.println("--- Data Ditambahkan ---");
                            System.out.println("Please wait ...");
                            Thread.sleep(1000);
                            break;
                        case 3:
                            acc.add(addAksesoris());
                            System.out.println("--- Data Ditambahkan ---");
                            System.out.println("Please wait ...");
                            Thread.sleep(1000);
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Sorry, Wrong Input!");
                            System.out.print("Press wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                    }
                } while (pilihan != 4);
                break;
                
            case 2:
                    cls();
                do{
            /*------------------------------------------------------------------- EDIT PRODUK ------------------------------------------------------------------------------*/
                    System.out.println("=== Edit Product ===");
                    System.out.println("[1] Anjing | [2] Kucing | [3] Aksesoris | [4] Back");
                    System.out.print(">> ");
                    pilihan = scan.nextInt();
                    switch(pilihan){
                        case 1:
                            for(int i=0; i<anjing.size(); i++){
                                System.out.println("[Anjing " + (i+1) +"]");
                                anjing.get(i).info();
                                System.out.println("");
                            }
                            editAnjing(anjing);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 2:
                            for(int i=0; i<kucing.size(); i++){
                                System.out.println("[Kucing " + (i+1) +"]");
                                kucing.get(i).info();
                                System.out.println("");
                            }
                            editKucing(kucing);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 3:
                            for(int i=0; i<acc.size(); i++){
                                System.out.println("[Aksesoris " + (i+1) +"]");
                                acc.get(i).info();
                                System.out.println("");
                            }
                            editAcc(acc);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Sorry, Wrong Input!");
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                    }
                } while (pilihan != 4);
                break;
                
            case 3:
            /*------------------------------------------------------------------- DELETE PRODUK ------------------------------------------------------------------------------*/
                    cls();
                do{
                    System.out.println("=== Delete Product ===");
                    System.out.println("[1] Anjing | [2] Kucing | [3] Aksesoris | [4] Back");
                    System.out.print(">> ");
                    pilihan = scan.nextInt();
                    switch(pilihan){
                        case 1:
                            for(int i=0; i<anjing.size(); i++){
                                System.out.println("[Anjing " + (i+1) +"]");
                                anjing.get(i).info();
                                System.out.println("");
                            }
                            deleteAnjing(anjing);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 2:
                            for(int i=0; i<kucing.size(); i++){
                                System.out.println("[Kucing " + (i+1) +"]");
                                kucing.get(i).info();
                                System.out.println("");
                            }
                            deleteKucing(kucing);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 3:
                            for(int i=0; i<acc.size(); i++){
                                System.out.println("[Aksesoris " + (i+1) +"]");
                                acc.get(i).info();
                                System.out.println("");
                            }
                            deleteAcc(acc);
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Sorry, Wrong Input!");
                            System.out.print("Please wait ...");
                            Thread.sleep(1000);
                            cls();
                            break;
                    }
                } while (pilihan != 4);
                break;
                
            case 4:
            /*------------------------------------------------------------------- VIEW PRODUK ------------------------------------------------------------------------------*/
                cls();
                System.out.println("------------------------\n");
                for(int i=0; i<anjing.size(); i++){
                    System.out.println("[Anjing " + (i+1) +"]");
                    anjing.get(i).info();
                    System.out.println("");
                }
                System.out.println("------------------------\n");
                for(int i=0; i<kucing.size(); i++){
                    System.out.println("[Kucing " + (i+1) +"]");
                    kucing.get(i).info();
                    System.out.println("");
                }
                System.out.println("");
                System.out.println("------------------------\n");
                for(int i=0; i<acc.size(); i++){
                    System.out.println("[Aksesoris " + (i+1) +"]");
                    acc.get(i).info();
                    System.out.println("");
                }
                System.out.println("------------------------");
                System.out.println("[0] Back");
                System.out.print(">> ");
                pilihan = scan.nextInt();
                break;
                
            case 5:
            /*------------------------------------------------------------------- VIEW MEMBER ------------------------------------------------------------------------------*/
                cls();
                System.out.println("------------------------");
                for(int i=0; i<member.size(); i++){
                    System.out.println("[Member " + (i+1) +"]");
                    member.get(i).info();
                    System.out.println("");
                }
                System.out.println("------------------------");
                System.out.println("[0] Back");
                System.out.print(">> ");
                pilihan = scan.nextInt();
                break;
                
            case 6:
            /*------------------------------------------------------------------- VIEW ORDER ------------------------------------------------------------------------------*/
                cls();
                System.out.println("[1] Search ID Pembayaran | [2] Back");
                System.out.print(">> ");
                pilihan = scan.nextInt();
                switch(pilihan){
                    case 1:
                        System.out.print("Masukkan No HP Member : ");
                        String num = scan.next();
                        int idx = searchNoHp(member, num);
                        boolean isOrder = member.get(idx).getListOrder().contains(member.get(idx).getListOrder());
                        if (idx != -1){
                            //0831245
                            if(isOrder){
                                member.get(idx).getListOrder().get(0).info();
                            } else {
                                System.out.println("No Order bro, order gih");
                            }
                        } else {
                            System.out.println("Number not Found");
                        }
                        break;
                }
                break;
            case 7:
            /*------------------------------------------------------------------- LOGOUT ------------------------------------------------------------------------------*/
                System.exit(0);
                break;
            default:
                System.out.println("Sorry, Wrong Input!");
                System.out.print("Please wait ...");
                Thread.sleep(1000);
                break;
            }
        } while (input != 7);
    }
}
