class Property {
  private String tyyppi;
  private String paikka;

//luokka ei sisällä parametrillista konstruktoria, sillä oliota luodessa tieto ei ole vielä saatavilla
  public int setTyyppi(String type){ //metodi, jolla asetetaan arvo muuttujalle 'tyyppi'. Sisältää syötteentarkistuksen.
    int tarkistin = 0,
    n = 0;
    while(n < type.length()){
      tarkistin = 0;
      if((type.charAt(n) < 'a' || type.charAt(n) > 'z') && (type.charAt(n) < 'A' || type.charAt(n) > 'Z')){
        tarkistin = 1;
        break;
      }
      n++;
    }

    if(tarkistin != 1){
      tyyppi = type;
    }
    else{
      System.out.println("Virheellinen syote. Anna uusi syote.");
    }
    return(tarkistin);
    }

  public int setPaikka(String loc){// Metodi, jolla asetetaan arvo muuttujaan 'paikka'. Sisältää syötteentarkistuksen.
    int tarkistin = 0,
    n = 0;
    while(n < loc.length()){
      tarkistin = 0;
      if((loc.charAt(n) < 'a' || loc.charAt(n) > 'z') && (loc.charAt(n) < 'A' || loc.charAt(n) > 'Z') && (loc.charAt(n) < '0' || loc.charAt(n) > '9') && loc.charAt(n) != ' '){
        tarkistin = 1;
        break;
      }
      n++;
    }

    if(tarkistin != 1){
      paikka = loc;
    }
    else{
      System.out.println("Virheellinen syote. Anna uusi syote.");
    }
    return(tarkistin);
  }

    public void print(){
      System.out.println("Rakennuksen tyyppi: " + tyyppi + "\nRakennuksen sijainti: " + paikka);
    }

  }
