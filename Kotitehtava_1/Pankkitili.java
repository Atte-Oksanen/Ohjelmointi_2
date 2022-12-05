
class Pankkitili {
  private String tilinumero;
  private String kayttaja;
  private double saldo;


  public Pankkitili(double saldo, String kayttaja, String tilinumero){

  }

  public void AsetaKayttaja(String syote) {
    kayttaja = syote;
  }

  public String NoudaKayttaja() {
    return kayttaja;
  }

  public void AsetaSaldo(double nosto) {
    saldo = nosto;
  }

  public double NoudaSaldo() {
    return saldo;
  }

  public void AsetaTilinumero(String syote){
    tilinumero = syote;
  }

  public String NoudaTilinumero() {
    return tilinumero;
  }

  public void Nosto(double nosto){
    saldo = saldo - nosto;
  }
}
