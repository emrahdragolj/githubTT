import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AutoSalon {
    private ArrayList<Automobil> dostupniAutomobili;
    private ArrayList<Zaposlenik> zaposlenici;
    private ArrayList<Prodaja> evidencijaProdaja;

    Scanner scanner = new Scanner(System.in);

    // Konstruktori
    public AutoSalon () {
        this.dostupniAutomobili = citajAutomobil("src/automobili.csv");
        this.zaposlenici = citajZaposlenika("src/zaposlenici.csv");
        this.evidencijaProdaja = new ArrayList<>();
    }

    //Getteri i setteri

    public ArrayList<Automobil> getDostupniAutomobili() {
        if (dostupniAutomobili.isEmpty()) {
            citajAutomobil("src/automobili.csv");
        }
        return dostupniAutomobili;
    }
    public ArrayList<Prodaja> getEvidencijaProdaja() {
        return evidencijaProdaja;
    }
    public ArrayList<Zaposlenik> getZaposlenici() {
        if (zaposlenici.isEmpty()) {
            citajZaposlenika("src/zaposlenici.csv");
        }
        return zaposlenici;
    }

    // Metode

    // Dodavanje u liste
    public void dodajNovuProdaju(Prodaja prodaja) {
        this.evidencijaProdaja.add(prodaja);
    }

    // Pretraga

    public ArrayList<Automobil> pretraziPoImenu (String marka, String model) {
        ArrayList<Automobil> rezultatPretrage = new ArrayList<>();
        for(Automobil auto : dostupniAutomobili) {
            if (auto.getMarka().equalsIgnoreCase(marka) && auto.getModel().equalsIgnoreCase(model)) {
                rezultatPretrage.add(auto);
            }
        }
        return rezultatPretrage;
    }
    public ArrayList<Automobil> pretraziPoMarki (String marka) {
        ArrayList<Automobil> rezultatPretrage = new ArrayList<>();
        for(Automobil auto : dostupniAutomobili) {
            if (auto.getMarka().equalsIgnoreCase(marka)) {
                rezultatPretrage.add(auto);
            }
        }
        return rezultatPretrage;
    }
    public ArrayList<Automobil> pretraziPoCijeni (double minCijena, double maxCijena) {
        ArrayList<Automobil> rezultatPretrage = new ArrayList<>();
        for(Automobil auto : dostupniAutomobili) {
            if (auto.getCijena() >= minCijena && auto.getCijena() <= maxCijena) {
                rezultatPretrage.add(auto);
            }
        }
        return rezultatPretrage;
    }

    public Automobil dodajAutomobil() {
        System.out.print("Marka: ");
        String marka = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Godina proizvodnje: ");
        int godinaProizvodnje = Integer.parseInt(scanner.nextLine());
        System.out.print("Boja: ");
        String boja = scanner.nextLine();
        System.out.print("Kubikaza: ");
        int kubikaza = Integer.parseInt(scanner.nextLine());
        System.out.print("Cijena: ");
        double cijena = Double.parseDouble(scanner.nextLine());
        System.out.print("Broj vozila: ");
        int brojVozila = Integer.parseInt(scanner.nextLine());

        return new Automobil(marka, model, godinaProizvodnje, boja, kubikaza, cijena, brojVozila);
    }

    public Zaposlenik dodajZaposlenika() {
        System.out.print("Ime: ");
        String ime = scanner.nextLine();
        System.out.print("Prezime: ");
        String prezime = scanner.nextLine();
        System.out.print("Datum rođenja: ");
        String datumRodjenja= scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.print("Broj telefona: ");
        String brojTelefona = scanner.nextLine();
        System.out.print("Pozicija: ");
        String pozicija = scanner.nextLine();
        System.out.print("Godina zapošljenja: ");
        int godinaZaposljenja = Integer.parseInt(scanner.nextLine());

        return new Zaposlenik(ime, prezime, datumRodjenja, email, brojTelefona, pozicija, godinaZaposljenja);
    }

    public Automobil pronadjiAutomobil(String marka, String model, String boja, int godina) {
        for (Automobil auto: dostupniAutomobili) {
            if (auto.getMarka().equalsIgnoreCase(marka) && auto.getModel().equalsIgnoreCase(model) && auto.getBoja().equalsIgnoreCase(boja) && auto.getGodinaProizvodnje()==godina) {
                return auto;
            }
        }
        return null;
    }

    public Zaposlenik pronadjiZaposlenika(String ime, String prezime) {
        for (Zaposlenik zaposlenik: zaposlenici) {
            if (zaposlenik.getIme().equalsIgnoreCase(ime) && zaposlenik.getPrezime().equalsIgnoreCase(prezime)) {
                return zaposlenik;
            }
        }
        return null;
    }

    // Dodavanje i citanje podataka
    public void sacuvajAutomobil(String file, Automobil auto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(auto.toCSV());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sacuvajZaposlenika(String file, Zaposlenik zaposlenik) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(zaposlenik.toCSV());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Automobil> citajAutomobil(String file) {
        ArrayList<Automobil> automobili = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while((line=reader.readLine()) != null) {
                String[] podaci = line.split(",");
                String marka = podaci[0].trim();
                String model = podaci[1].trim();
                int godinaProizvodnje = Integer.parseInt(podaci[2].trim());
                String boja = podaci[3].trim();
                int kubikaza = Integer.parseInt(podaci[4].trim());
                double cijena = Double.parseDouble(podaci[5].trim());
                int brojVozila = Integer.parseInt(podaci[6].trim());
                Automobil auto = new Automobil(marka, model, godinaProizvodnje, boja, kubikaza,cijena,brojVozila);
                automobili.add(auto);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return automobili;
    }

    public ArrayList<Zaposlenik> citajZaposlenika(String file) {
        ArrayList<Zaposlenik> zaposlenici = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while((line=reader.readLine()) != null) {
                String[] podaci = line.split(",");
                String ime = podaci[0].trim();
                String prezime = podaci[1].trim();
                String datumRodjenja = podaci[2].trim();
                String email = podaci[3].trim();
                String brojTelefona = podaci[4].trim();
                String pozicija = podaci[5].trim();
                int godinaZaposljenja = Integer.parseInt(podaci[6].trim());
                Zaposlenik zaposlenik = new Zaposlenik(ime, prezime, datumRodjenja, email, brojTelefona, pozicija, godinaZaposljenja);
                zaposlenici.add(zaposlenik);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return zaposlenici;
    }

    @Override
    public String toString() {
        return  "Dostupni automobili = " + dostupniAutomobili +
                "\nZaposlenici=" + zaposlenici +
                "\nEvidencija prodaja=" + evidencijaProdaja;
    }
}
