class Tontti {
  private String osoite;
  private String nimi;
  private String pintaAla;
  private Omakotitalo omakotitalo;
  private Rivitalo rivitalo;
  private Kerrostalo kerrostalo;

  public Tontti(){
    //konstruktori, joka aktivoituu tarkastin-olion kutsun yhteydessä
  }

  public Tontti(String nimi, String pintaAla, String osoite){
    this.nimi = nimi;
    this.pintaAla = pintaAla;
    this.osoite = osoite;
  }

  public void nimiSetter(String syote){
    nimi = syote;
  }

  public void pintaAlaSetter(String syote){
    pintaAla = syote;
  }

  public void setRakennus(int huoneistot, int tyyppi){
    if(tyyppi == 1){
      this.omakotitalo = new Omakotitalo(huoneistot);
    }
    if(tyyppi == 2){
      this.rivitalo = new Rivitalo(huoneistot);
    }
    if(tyyppi == 3){
      this.kerrostalo = new Kerrostalo(huoneistot);
    }
  }

  public void setHuoneet(int huoneet, int tyyppi){
    if(tyyppi == 1){
      omakotitalo.setHuoneet(huoneet);
    }
    if(tyyppi == 2){
      rivitalo.setHuoneet(huoneet);
    }
    if(tyyppi == 3){
        kerrostalo.setHuoneet(huoneet);
      }
  }

  public void setHuonePintaAla(int syote, int tyyppi){
    if(tyyppi == 1){
      omakotitalo.setPintaAla(syote);
    }
    if(tyyppi == 2){
      rivitalo.setPintaAla(syote);
    }
    if(tyyppi == 3){
      kerrostalo.setPintaAla(syote);
    }
  }

  public void printRakennus(int tyyppi){
    if(tyyppi == 1){
      omakotitalo.printRakennus();
    }
    if(tyyppi == 2){
      rivitalo.printRakennus();
    }
    if(tyyppi == 3){
      kerrostalo.printRakennus();
    }
  }

  public void setAsukas(String nimi, int tyyppi){
    if(tyyppi == 1){
      omakotitalo.setAsukas(nimi);
    }
    if(tyyppi == 2){
      rivitalo.setAsukas(nimi);
    }
    if(tyyppi == 3){
      kerrostalo.setAsukas(nimi);
    }
  }

  public void printAsukas(int tyyppi){
    if(tyyppi == 1){
      omakotitalo.printAsukas();
    }
    if(tyyppi == 2){
      rivitalo.printAsukas();
    }
    if(tyyppi == 3){
      kerrostalo.printAsukas();
    }

  }

  public void printTontti(){ //Print funktio kaikelle olion sisältämälle tiedolle
    String tontinnimi = "\nTontin Nimi: ";
    String info = tontinnimi + nimi + "\nPinta-ala: " + pintaAla + "\nOsoite: " + osoite;
    System.out.println(info);
  }

  public int nimitarkistin(String syote){ //syötetarkistin tontin sekä asukkaiden nimille
    int n = 0,
    tarkistin = 0;

    while(n < syote.length()){
      if((syote.charAt(n) < '0' || syote.charAt(n) > '9') && (syote.charAt(n) < 'a' || syote.charAt(n) > 'z') && (syote.charAt(n) < 'A' || syote.charAt(n) > 'Z') && syote.charAt(n) != ' '){
        tarkistin = 1;
        break;
      }
      n++;
    }
    return tarkistin;
  }

  public int pintaAlaTarkistin(String syote){ //syötetarkistin tontin sekä rakennuksen pinta-alalle. Käytetään myös muiden desimaalilukujen tarkistamiseen
    int n = 0,
    tarkistin = 0;

    while(n < syote.length()){
      if((syote.charAt(n) < '0' || syote.charAt(n) > '9') && syote.charAt(n) != '.'){
        tarkistin = 1;
        break;
      }
      n++;
    }
    return (tarkistin);
  }



}
