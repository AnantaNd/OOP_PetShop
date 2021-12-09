package Product;

import java.util.*;

public abstract class Hewan implements Tanggal {
    private int id;
    private int adpt_fee;
    private String jenis;
    
    Date tgl_masuk;
    Date tgl_keluar;
    
    // Constructor
    public Hewan(int id, int adpt_fee, String jenis){
        this.id = id;
        this.adpt_fee = adpt_fee;
        this.jenis = jenis;
    }
    
    // Setter & Getter
    public void setId(int id){this.id=id;}
    public void setJenis(String jenis){ this.jenis=jenis;}
    public void setAdpt_fee(int adpt_fee){this.adpt_fee=adpt_fee;}
    public int getId(){return this.id;}
    public String getJenis(){return this.jenis;}
    public int getAdpt_fee(){return this.adpt_fee;}
    
    // Interfaces
    @Override
    public void setTglMasuk(Date tgl){this.tgl_masuk=tgl;}
    @Override
    public void setTglKeluar(Date tgl){ this.tgl_keluar=tgl;}
    @Override
    public Date getTglMasuk(){return this.tgl_masuk;}
    @Override
    public Date getTglKeluar(){return this.tgl_keluar;}
    
    // Kelas Abstract dan Method Abstract info();
    public abstract void info();
}
