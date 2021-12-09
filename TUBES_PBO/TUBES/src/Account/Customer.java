package Account;

import static Menu.MainMenu.cls;
import Order.*;
import Product.*;
import java.util.*;

public class Customer extends Akun {
    private String nama, alamat, no_hp;
    private ArrayList<Order> L_Order = new ArrayList<Order>();
    private Order orderan = new Order(this);
    
    // Constructor
    public Customer(String nama, String alamat, String no_hp, String user, String pass){
        super(user,pass);
        this.nama = nama; 
        this.no_hp = no_hp;
        this.alamat = alamat;
    }

    // Setter & Getter
    public void setNama(String nama) {this.nama = nama;}
    public void setAlamat(String alamat) { this.alamat = alamat;}
    public void setNohp(String nohp){this.no_hp = nohp;}
    public void addListOrder(Order order){this.L_Order.add(order);}
    public String getNama() {return this.nama;}
    public String getAlamat() {return this.alamat;}
    public String getNohp() {return this.no_hp;}
    public ArrayList<Order> getListOrder(){return this.L_Order;}
    
    @Override
    public void info(){
        System.out.println("Nama\t : " + getNama());
        System.out.println("Alamat\t : " + getAlamat());
        System.out.println("No HP\t : " + getNohp());
    }
    
    // Customer Menu
    public void menu(ArrayList<Anjing> L_anjing, ArrayList<Kucing> L_kucing, ArrayList<Aksesoris> L_acc) throws InterruptedException{
        int input;
        do{
            cls();
            Scanner scan = new Scanner(System.in);
            System.out.println("=== [PetShop Menu] ===");
            System.out.println("[1] Order Product");
            System.out.println("[2] View Order");
            System.out.println("[3] View User");
            System.out.println("[4] Logout");
            System.out.println("--------------------");
            System.out.print("Your Input >> ");
            input = scan.nextInt();
            switch(input){
                case 1:
        /*------------------------------------------------------------------- NAMPILIN SEMUA PRODUK ------------------------------------------------------------------------------*/
                    cls();
                    System.out.println("### === [Order Product] ==== ###");
                    System.out.println("------------------------");
                    for(int i=0; i<L_anjing.size(); i++){
                        System.out.println("[Anjing " + (i+1) +"]");
                        L_anjing.get(i).info();
                        System.out.println("");
                    }
                    System.out.println("------------------------");
                    for(int i=0; i<L_kucing.size(); i++){
                        System.out.println("[Kucing " + (i+1) +"]");
                        L_kucing.get(i).info();
                        System.out.println("");
                    }
                    System.out.println("------------------------");
                    for(int i=0; i<L_acc.size(); i++){
                        System.out.println("[Aksesoris " + (i+1) + "]");
                        L_acc.get(i).info();
                        System.out.println("");
                    }
        /*------------------------------------------------------------------- MASUKIN SEMUA PRODUK KE ORDER ------------------------------------------------------------------------------*/
                    int pil;
                    do{
                        System.out.println("===================================================");
                        System.out.println("Pilih Product yang ingin di order :");
                        System.out.print("[1] Anjing, [2] Kucing , [3] Aksesoris, [4] Back : ");
                        pil = scan.nextInt();
                        int num;
                        switch (pil) {
            /*------------------------------------------------------------------- ADD ANJING KE ORDERAN ------------------------------------------------------------------------------*/
                            case 1:
                                try{
                                    System.out.println("Masukkan Nomor Anjing : ");
                                    num = scan.nextInt() - 1;
                                    orderan.addAnjing(L_anjing.get(num));
                                } catch (Exception e){
                                    System.out.println("Data Tidak Ditemukan");
                                }
                                break;
            /*------------------------------------------------------------------- ADD KUCING KE ORDERAN ------------------------------------------------------------------------------*/
                            case 2:
                                try{
                                    System.out.println("Masukkan Nomor Kucing : ");
                                    num = scan.nextInt() - 1;
                                    orderan.addKucing(L_kucing.get(num));
                                } catch (Exception e){
                                    System.out.println("Data Tidak Ditemukan");
                                }
                                break;
            /*------------------------------------------------------------------- ADD AKSESORIS KE ORDERAN ------------------------------------------------------------------------------*/
                            case 3:
                                try{
                                    System.out.println("Masukkan Nomor Produk Aksesoris : ");
                                    num = scan.nextInt() - 1;
                                    orderan.addAcc(L_acc.get(num));
                                } catch (Exception e){
                                    System.out.println("Data Tidak Ditemukan");
                                }
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Sorry, Wrong Input!");
                                break;
                        }                        
                    } while (pil != 4);   
                    break;
                case 2:
        /*------------------------------------------------------------------- TAMPILIN SEMUA ORDER JIKA ADA ------------------------------------------------------------------------------*/
                    cls();
                    if(this.orderan != null){
                        //this.orderan.info();
                        for(int i=0; i < L_Order.size(); i++){
                                        getListOrder().get(i).info();
                        }
                    }else{
                        System.out.println("Tidak ada Pesanan");
                        break;
                    }
                    do{
                        System.out.println("[1] Bayar Di Tempat | [2] Batalkan | [3] Back");
                        System.out.print(">> ");
                        pil = scan.nextInt();
                        switch(pil){
                            case 1:
                                cls();
                                if (orderan != null){
                                    addListOrder(orderan);
                                    System.out.println("ID Pembayaran " + getNohp());
                                    for(int i=0; i < L_Order.size(); i++){
                                        getListOrder().get(i).info();
                                    }
                                    System.out.println("");
                                    System.out.println("Tunjukkan ID Pembayaran pada Kasir di TOKO!");
                                } else {
                                    System.out.println("Tidak ada Pesanaan");
                                }
                                break;
                            case 2:
                                cls();
                                if(orderan != null){
                                    orderan.resetAll();
                                    System.out.println("--- Pesanan Dibatalkan ---");
                                } else {
                                    System.out.println("Tidak ada Pesanan");
                                }
                                break;
                            default:
                                System.out.println("Sorry, Wrong Input");
                                break;
                        }
                    } while (pil != 3);
                    break;
                case 3:
        /*------------------------------------------------------------------- TAMPILIN USER YANG LOGIN ------------------------------------------------------------------------------*/
                    cls();
                    System.out.println("========= [User Info] =========");
                    System.out.println("Nama\t : " + getNama());
                    System.out.println("Alamat\t : " + getAlamat());
                    System.out.println("No HP\t : " + getNohp());
                    System.out.println("===============================");
                    System.out.println("[0] Back");
                    System.out.print(">> ");
                    pil = scan.nextInt();
                    break;
                case 4:
        /*------------------------------------------------------------------- LOGOUT ------------------------------------------------------------------------------*/
                    System.exit(0);
                    System.out.println("Log Out");
                    break;
                default:
                    System.out.println("Sorry, Wrong Input!");
                    System.out.print("Please wait ...");
                    Thread.sleep(1000);
                    break;
            }
        } while (input != 4);
    }
    
}
