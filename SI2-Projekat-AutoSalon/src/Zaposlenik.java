public class Zaposlenik extends Osoba{
    private String pozicija;
    private int godinaZaposljenja;

    //Konstruktori
    public Zaposlenik(String ime, String prezime, String datumRodjenja, String email, String brojTelefona, String pozicija, int godinaZaposljenja) {
        super(ime, prezime, datumRodjenja, email, brojTelefona);
        this.pozicija = pozicija;
        this.godinaZaposljenja = godinaZaposljenja;
    }

    // Metode
    public String toCSV() {
        return ime + "," + prezime + "," + datumRodjenja + "," + email + ","+ brojTelefona + "," + pozicija + "," + godinaZaposljenja;
    }

    @Override
    public String toString() {
        return  "Ime: '" + getIme() +
                " Prezime: '" + getPrezime() + '\'' +
                ", Pozicija: '" + pozicija + '\'' +
                ", Godina zaposljenja: " + godinaZaposljenja + "\n";
    }
}
