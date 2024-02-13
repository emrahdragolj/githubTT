import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public void mainMenu() {
        System.out.println("------------------- Auto Salon --------------------");
        System.out.println("---------------- Odaberite opciju -----------------");
        System.out.println();
        System.out.println("(1) Prikaži automobile       (2) Dodaj automobil");
        System.out.println("(3) Prikaži zaposlenike      (4) Dodaj zaposlenika");
        System.out.println("(5) Evidencija prodaja       (6) Kupi automobil");
        System.out.println("(7) Pretraži po imenu        (8) Pretraži po marki");
        System.out.println("(9) Pretraži po cijeni       (0) Izlaz");
    }

    public void pokreni() {
        Scanner scanner = new Scanner(System.in);
        AutoSalon autoSalon = new AutoSalon();
        int izbor;
        while (true){
            try {
                mainMenu();
                izbor = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if (izbor == 0) {
                    System.out.println("Dovidjenja");
                    break;
                }
                String marka;
                switch (izbor) {
                    case 1:
                        System.out.println(autoSalon.citajAutomobil("src/automobili.csv"));
                        System.out.println();
                        break;
                    case 2:
                        Automobil auto = autoSalon.dodajAutomobil();
                        autoSalon.sacuvajAutomobil("src/automobili.csv", auto);
                        break;
                    case 3:
                        System.out.println(autoSalon.citajZaposlenika("src/zaposlenici.csv"));
                        System.out.println();
                        break;
                    case 4:
                        Zaposlenik zaposlenik = autoSalon.dodajZaposlenika();
                        autoSalon.sacuvajZaposlenika("src/zaposlenici.csv", zaposlenik);
                        break;
                    case 5:
                        System.out.println(autoSalon.getEvidencijaProdaja());
                        System.out.println();
                        break;
                    case 6:
                        kupiAutomobil(autoSalon);
                        break;
                    case 7:
                        System.out.println("Unesite marku automobila: ");
                        marka = scanner.nextLine();
                        System.out.println("Unesite model automobila: ");
                        String model = scanner.nextLine();
                        System.out.println(autoSalon.pretraziPoImenu(marka, model));
                        if (autoSalon.pretraziPoImenu(marka,model).isEmpty()) System.out.println("Automobil nije dostupan");
                        System.out.println();
                        break;
                    case 8:
                        System.out.println("Unesite marku automobila: ");
                        marka = scanner.nextLine();
                        System.out.println(autoSalon.pretraziPoMarki(marka));
                        if (autoSalon.pretraziPoMarki(marka).isEmpty()) System.out.println("Automobil nije dostupan");
                        System.out.println();
                        break;
                    case 9:
                        System.out.println("Unesite minimalnu cijenu automobila: ");
                        double minCijena = Double.parseDouble(scanner.nextLine());
                        System.out.println("Unesite maksimalnu cijenu automobila: ");
                        double maxCijena = Double.parseDouble(scanner.nextLine());
                        System.out.println();
                        System.out.println(autoSalon.pretraziPoCijeni(minCijena, maxCijena));
                        break;
                    default:
                        System.out.println("Nepoznata opcija. Pokušajte ponovo.");
                        System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Greška pri unosu. Molimo vas unesite ispravan broj.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Došlo je do nepredviđene greške. Pokušajte ponovo.");
                e.printStackTrace();
            }
        }
    }


    public void kupiAutomobil(AutoSalon autoSalon) {
        System.out.println("Unesite podatke o kupcu");
        Kupac kupac = Kupac.dodajKupca();

        System.out.println("Trenutno dostupni automobili: ");
        System.out.println(autoSalon.getDostupniAutomobili());

        System.out.println("Unesite podatke o automobilu koji želite kupiti: ");
        System.out.println("Marka: ");
        String marka = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Boja: ");
        String boja = scanner.nextLine();
        System.out.println("Godina proizvodnje: ");
        int godProizvodnje = Integer.parseInt(scanner.nextLine());

        Automobil kupljeniAutomobil = autoSalon.pronadjiAutomobil(marka, model, boja, godProizvodnje);

        if (kupljeniAutomobil==null) {
            System.out.println("Automobil nije pronadjen.");
            return;
        }

        System.out.println("Unesite podatke o zaposleniku: ");
        System.out.println("Trenutni zaposlenici: ");
        System.out.println(autoSalon.getZaposlenici());
        System.out.println("Ime: ");
        String ime = scanner.nextLine();
        System.out.println("Prezime: ");
        String prezime = scanner.nextLine();

        Zaposlenik prodavac = autoSalon.pronadjiZaposlenika(ime, prezime);
        if (prodavac==null) {
            System.out.println("Zaposlenik ne postoji");
        }

        System.out.println("Unesite datum prodaje: ");
        String datum = scanner.nextLine();

        kupac.kupiAutomobil(kupljeniAutomobil);
        Prodaja prodaja = new Prodaja(kupac, kupljeniAutomobil, datum, prodavac);
        autoSalon.dodajNovuProdaju(prodaja);
    }
}


