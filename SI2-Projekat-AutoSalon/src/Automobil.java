public class Automobil {
    private String marka;
    private String model;
    private int godinaProizvodnje;
    private int kubikaza;
    private double cijena;
    private String boja;
    private int brojVozila;

    //Konstruktori
    public Automobil(String marka, String model, int godinaProizvodnje, String boja, int kubikaza, double cijena, int brojVozila){
        this.marka = marka;
        this.model = model;
        this.godinaProizvodnje = godinaProizvodnje;
        this.kubikaza = kubikaza;
        this.cijena = cijena;
        this.boja = boja;
        this.brojVozila = brojVozila;
    }

    // Getteri i Setteri
    public String getMarka() {
        return marka;
    }
    public String getModel() {
        return model;
    }
    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }
    public double getCijena() {
        return cijena;
    }
    public String getBoja() {
        return boja;
    }
    public int getBrojVozila() {
        return brojVozila;
    }
    public void setBrojVozila(int brojVozila) {
        this.brojVozila = brojVozila;
    }

    // Metode

    public boolean jeDostupan() {
        return this.brojVozila != 0;
    }

    public String toCSV() {
        return marka + "," + model + "," + godinaProizvodnje + "," + boja + ","+ kubikaza + "," + cijena + "," + brojVozila;
    }

    @Override
    public String toString() {
        return  "Marka: '" + marka + '\'' +
                ", Model: '" + model + '\'' +
                ", Godina proizvodnje: " + godinaProizvodnje +
                ", Kubikaza: " + kubikaza +
                ", cijena: " + cijena +
                ", boja: '" + boja + '\'' +
                ", brojVozila: " + brojVozila + "\n";
    }
}
