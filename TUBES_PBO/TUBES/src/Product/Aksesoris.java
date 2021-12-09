package Product;

import java.util.*;

public class Aksesoris implements Tanggal {
    private int id_barang;
    private String nama_barang, desc;
    private int qty, harga;
    private Date tgl_masuk = new Date();
    private Date tgl_keluar = new Date();
    
    // Constructor
    public Aksesoris(String nama_barang, int id_barang, int qty, int harga, String desc) {
        this.nama_barang = nama_barang;
        this.id_barang = id_barang;
        this.qty = qty;
        this.harga = harga;
        this.desc = desc;
    }
    
    // Setter Getter
    public void setNama_barang(String nama_barang) {this.nama_barang = nama_barang;}
    public void setId_barang(int id_barang) {this.id_barang = id_barang;}
    public void setHarga(int harga) {this.harga = harga;}
    public void setQty(int qty) {this.qty = qty;}
    public void setDesc(String desc) {this.desc = desc; }

    public String getNama_barang() {return this.nama_barang;}
    public int getId_barang() {return this.id_barang;}
    public int getQty() {return this.qty;}
    public int getHarga() {return this.harga;}
    public String getDesc() {return desc; }


    // Interfaces
    @Override
    public Date getTglMasuk() {return tgl_masuk;}
    
    @Override
    public void setTglMasuk(Date tgl) { this.tgl_masuk = tgl;}
    
    @Override
    public Date getTglKeluar() {return tgl_keluar;}
    
    @Override
    public void setTglKeluar(Date tgl) {this.tgl_keluar = tgl;}
    
    public void info(){
        System.out.println("ID : " + getId_barang());
        System.out.println("Nama Aksesoris : " + getNama_barang());
        System.out.println("Stock Barang : " + getQty());
        System.out.println("Deskripsi : " + getDesc());
        System.out.println("Harga /barang : " + getHarga());
    }
}
