import java.util.Scanner;

class Vt4main {
  public static Scanner scan = new Scanner(System.in);
  private InsuranceInfo info;

  public static void main(String[] args) {
    String tyyppi, sijainti;
    double arvo = 0;
    int tarkistin = 0, valinta = 0;

    InsInfoContainer container = new InsInfoContainer(); //luodaan tietosäiliöolio

    while(valinta != 2) {
      System.out.println("Lisaa kiinteiston tiedot.");
      do {
        tarkistin = 0;
        System.out.println("Rakennuksen vakuutusarvo:");
        try{
          arvo = scan.nextDouble();
        }
        catch(Exception e){
          System.out.println("Virheellinen syote. Anna uusi syote.");
          scan.nextLine();
          tarkistin = 1;
        }
    } while (tarkistin == 1);

      InsuranceInfo talo = new InsuranceInfo(arvo);
      scan.nextLine();

      do{
        System.out.println("Rakennuksen tyyppi:");
        tarkistin = talo.setTyyppi(scan.nextLine());
      } while (tarkistin == 1);

      do {
        System.out.println("Rakennuksen sijainti:");
        tarkistin = talo.setPaikka(scan.nextLine());
      } while (tarkistin == 1);

      container.addInfo(talo);
      do {
        System.out.println("Haluatko lisata toisen rakennuksen?\n1:Kylla  2:Ei");
        tarkistin = 0;
        try {
          valinta = scan.nextInt();
        }
        catch(Exception e) {
          System.out.println("Virheellinen syote. Anna uusi syote.");
          scan.nextLine();
          tarkistin = 1;
        }
        if(valinta < 1 || valinta > 2){
          System.out.println("Virheellinen syote. Anna uusi syote.");
          tarkistin = 1;
        }
        scan.nextLine();
      } while (tarkistin == 1);
      }

      container.getInfo(); //tulostetaan koko tietosäiliön sisältö

      System.out.println("Hae vakuutusarvoltaan suurempia kohteita.\nVakuutusarvo:");
      do {
        tarkistin = 0;
        try{
          arvo = scan.nextDouble();
        }
        catch(Exception e){
          System.out.println("Virheellinen syote. Anna uusi syote.");
          tarkistin = 1;
        }
        scan.nextLine();
      } while (tarkistin == 1);

      container.minArvo(arvo);

      System.out.println("Hae vakuutusarvoltaan pienempia kohteita.\nVakuutusarvo:");
      do {
        tarkistin = 0;
        try{
          arvo = scan.nextDouble();
        }
        catch(Exception e){
          System.out.println("Virheellinen syote. Anna uusi syote.");
          tarkistin = 1;
        }
        scan.nextLine();
      } while (tarkistin == 1);

      container.maxArvo(arvo);


  }
}
