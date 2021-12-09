package Product;

import java.util.Date;

public abstract interface Tanggal {
    abstract void setTglMasuk(Date tgl_masuk);
    abstract void setTglKeluar(Date tgl_keluar);
    abstract Date getTglMasuk();
    abstract Date getTglKeluar();
}
