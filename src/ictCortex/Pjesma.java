package ictCortex;

import java.time.Duration;

public class Pjesma {

    public String naziv;
    public double minuti;
    public double sekunde;

    @Override
    public String toString() {
        return  naziv + " (" + minuti + ":" + sekunde+ ")";
    }

    public Pjesma(String naslov, double minuti, double sekunde){
        this.naziv = naslov;
        this.minuti = minuti;
        if(sekunde>59){
            sekunde = 59;
        }
        this.sekunde = sekunde;

    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naslov) {
        this.naziv = naslov;
    }

    public double getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public double getSekunde() {
        return sekunde;
    }

    public void setSekunde(int sekunde) {
        this.sekunde = sekunde;
    }
}
