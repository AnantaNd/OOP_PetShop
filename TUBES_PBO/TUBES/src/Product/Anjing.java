package Product;

public class Anjing extends Hewan{
    private String nama;
    private String gender;
    private int umur;

    // Constructor 
    public Anjing(int id, int adpt_fee, int umur, String jenis, String nama, String gender) {
        super(id, adpt_fee, jenis);
        this.nama = nama;
        if (gender.equals("P") || gender.equals("p")){
            this.gender = "Betina";
        } else if (gender.equals("L") || gender.equals("l")){
            this.gender = "Jantan";
        }
        this.umur = umur;
    }
    
    // Setter & Getter
    public void setNama(String nama){this.nama=nama;}
    public void setGender(String gender){this.gender=gender;}
    public void setUmur(int umur){this.umur=umur;}
    public String getNama(){return this.nama;}
    public String getGender(){return this.gender;}
    public int getUmur(){return this.umur;}
    
    @Override
    public void info(){
        System.out.println("Nama\t: " + getNama());
        System.out.println("Gender\t: " + getGender());
        System.out.println("Umur\t: " + getUmur());
        System.out.println("Ras\t: " + super.getJenis());
        System.out.println("Fee\t: " + super.getAdpt_fee());
    }
}