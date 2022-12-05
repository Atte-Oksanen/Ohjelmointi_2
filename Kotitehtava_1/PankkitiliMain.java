import java.util.Scanner;

class PankkitiliMain {

  public static Scanner scan= new Scanner(System.in);

  public static void main(String[] args) {
    PankkitiliMain ObjKayttaja = new PankkitiliMain();
    Pankkitili ObjTili = new Pankkitili(0, "\0", "\0");



    ObjTili.AsetaKayttaja(ObjKayttaja.LisaaKayttaja());
    ObjTili.AsetaTilinumero(ObjKayttaja.LisaaTilinumero());
    ObjTili.AsetaSaldo(ObjKayttaja.LisaaSaldo());
    System.out.println("Kayttajan nimi: " + ObjTili.NoudaKayttaja() + " Tilinumero: " + ObjTili.NoudaTilinumero() + " Saldo: " + ObjTili.NoudaSaldo());
    ObjTili.Nosto(ObjKayttaja.NostaRahaa(ObjTili.NoudaSaldo()));
    System.out.println("Kayttajan nimi: " + ObjTili.NoudaKayttaja() + " Tilinumero: " + ObjTili.NoudaTilinumero() + " Saldo: " + ObjTili.NoudaSaldo());
    scan.close();
  }

  private String LisaaKayttaja(){ //Pyydetään käyttäjältä nimi ja palautetaan se main-metodiin. Ohjelma tarkistaa onko syöte oikeanlainen.
    int n = 0, len=0, tester;
    String kayttaja;

    do {
      tester = 1;
      System.out.println("Syota kayttajan nimi");
      kayttaja = scan.nextLine();
      len = kayttaja.length();

      while (n < len) {
        if ((kayttaja.charAt(n) < 65 || kayttaja.charAt(n) > 90) && (kayttaja.charAt(n) < 97 || kayttaja.charAt(n) > 122) && kayttaja.charAt(n) != 32){
          System.out.println("Virheellinen syote.");
          tester = 0;
          break;
        }
        n++;
        }
        n = 0;
      } while (tester == 0);
      return kayttaja;

  }

  private String LisaaTilinumero(){ // Pyydetään käyttäjältä tilinumero string-muotoisena ja palautetaan se main-metodiin. Sisältää syötteentarkistuksen.

      int n = 0, len = 0, tester;
      String tilinumero;

      do {
        tester = 1;
        System.out.println("Syota tilinumero");
        tilinumero = scan.nextLine();
        len = tilinumero.length();

        while (n < len) {
          if (tilinumero.charAt(n) < 48 || tilinumero.charAt(n) > 57){
            System.out.println("Virheellinen syote.");
            tester = 0;
            break;
          }
          n++;

          }
          n = 0;
        } while (tester == 0);
        return tilinumero;
  }

  private double LisaaSaldo() { // Pyydetään käyttäjältä saldo double-muotoisena ja palautetaan se main-metodiin. Sisältää syötteentarkistuksen.

    double saldo = 0;
    int tester;

    do {
        System.out.println("Syota saldo");
        try {
          saldo = scan.nextDouble();
          tester = 1;
        }
        catch (Exception e) {
          scan.nextLine();
          System.out.println("Virheellinen syote");
          tester = 0;
        }
    } while (tester == 0);

    return saldo;

  }

  private double NostaRahaa(double saldo) { //käyttäjältä pyydetään noston määrä double-muotoisena ja palautetaan se main metodiin. Sisältää syötteentarkistuksen.

    double nosto = 0;
    int tester;

    do {
        System.out.println("Syota nostettava summa");
        try {
          nosto = scan.nextDouble();
          tester = 1;
        }
        catch (Exception e) {
          scan.nextLine();
          System.out.println("Virheellinen syote");
          tester = 0;
        }
       if (saldo < nosto) {
          System.out.println("Tililla ei riittavasti katetta");
        }
    } while (tester == 0 || saldo < nosto);

    return (nosto);
  }

}
