class InsuranceInfo {
  private double arvo;
  private Property kiinteisto;


  public InsuranceInfo(double arvo) {
    kiinteisto = new Property();
    this.arvo = arvo;
  }

  public int setTyyppi(String type) {
    return(kiinteisto.setTyyppi(type));
  }

  public int setPaikka(String loc) {
    return(kiinteisto.setPaikka(loc));
  }

  public int print() {
    kiinteisto.print();
    System.out.println("Rakennuksen vakuutusarvo: " + arvo);
    return(0);
  }

  public double getArvo(){
    return(arvo);
  }
}
