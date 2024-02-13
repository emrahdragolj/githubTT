import java.util.Scanner;

public class Kupac extends Osoba{
    private int brojKartice;
    private double stanjeNaKartici;

    static Scanner scanner = new Scanner(System.in);

    // Konstruktori

    public Kupac() {
        super();
        this.brojKartice = 0;
        this.stanjeNaKartici = 0.0;
    }
    public Kupac(String ime, String prezime, String datumRodjenja, String email, String brojTelefona, int brojKartice, double stanjeNaKartici) {
        super(ime, prezime, datumRodjenja, email, brojTelefona);
        this.brojKartice = brojKartice;
        this.stanjeNaKartici = stanjeNaKartici;
    }

    // Metode

    public static Kupac dodajKupca() {

        System.out.print("Ime: ");
        String ime = scanner.nextLine();
        System.out.print("Prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("Datum rođenja: ");
        String datumRodjenja = scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("Broj telefona: ");
        String brojTelefona = scanner.nextLine();
        System.out.print("Broj kartice: ");
        int brojKartice = Integer.parseInt(scanner.nextLine());
        System.out.print("Iznos na kartici: ");
        double stanjeNaKartici = Double.parseDouble(scanner.nextLine());

        return new Kupac(ime, prezime,datumRodjenja,email,brojTelefona,brojKartice,stanjeNaKartici);
    }

    public void kupiAutomobil(Automobil auto) {
        if (auto.jeDostupan() && stanjeNaKartici >= auto.getCijena()) {
            stanjeNaKartici -= auto.getCijena();
            auto.setBrojVozila(auto.getBrojVozila()-1);
            System.out.println("Uspješno ste kupili: " + auto);
        } else {
            System.out.println("Autmobil nije dostupan ili nemate dovoljno sredstava na kartici");
        }
    }


    @Override
    public String toString() {
        return  "Ime: '" + getIme() +
                " Prezime: '" + getPrezime() + '\'' +
                ", Broj kartice: '" + brojKartice + '\'' +
                ", Stanje na kartici: " + stanjeNaKartici + '\'' +
                ", Email: '" + getEmail() + '\'' +
                ", Broj telefona: '" + getBrojTelefona() + "\n";
    }
}
