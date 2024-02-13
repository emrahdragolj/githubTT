public class Osoba {
    protected String ime;
    protected String prezime;
    protected String datumRodjenja;
    protected String email;
    protected String brojTelefona;

    public Osoba(){
        this.ime = "";
        this.prezime = "";
        this.datumRodjenja = "";
        this.email = "";
        this.brojTelefona = "";
    }

    public Osoba(String ime, String prezime, String datumRodjenja, String email, String brojTelefona){
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.brojTelefona = brojTelefona;
    }

    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public String getEmail() {
        return email;
    }
    public String getBrojTelefona() {
        return brojTelefona;
    }
}
