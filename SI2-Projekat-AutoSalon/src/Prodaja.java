public class Prodaja {
    private String datumProdaje;
    private Kupac kupac;
    private Automobil kupljeniAutomobil;
    private Zaposlenik prodavac;

    public Prodaja(Kupac kupac, Automobil kupljeniAutomobil, String datumProdaje, Zaposlenik prodavac){
        this.datumProdaje = datumProdaje;
        this.kupac = kupac;
        this.kupljeniAutomobil = kupljeniAutomobil;
        this.prodavac = prodavac;
    }

    @Override
    public String toString() {
        return "Datum prodaje: " + datumProdaje + "\nKupac: " + kupac + "\nKupljeni automobil: " + kupljeniAutomobil + "\nProdavac: " + prodavac +"\n";
    }
}
