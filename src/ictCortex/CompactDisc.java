package ictCortex;



import java.io.*;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class CompactDisc {

     String imeIzvodjaca;
     String naslov;
     int godinaIzdanja;
     int brPjesama;
    String [] songs;
    ArrayList pjesme;


    public CompactDisc(){};

    public CompactDisc (String izvodjac,String naslov,int godina,int numOfSongs,String[] songs) {
        this.imeIzvodjaca = izvodjac;
        this.naslov = naslov;
        this.godinaIzdanja = godina;
        this.brPjesama = numOfSongs;
        this.songs = songs;
    }

        /*try(BufferedWriter buf = new BufferedWriter(new FileWriter(new File("C:\\Users\\Jukazuma\\Desktop\\PROJEKAT\\podaciIzKonstruktora.txt"),true))){
            buf.write(" \nIzvodjac: " + imeIzvodjaca + "\nNaslov CD-a: " + naslov + " Pjesme: " + "\n" + "\n" );
            for(int i = 0;i<songs.length;i++){
                buf.write(songs[i] + "\n");
            }
            System.out.println("Podaci iz konstruktora upisani u fajl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/


    public CompactDisc (String izvodjac,String naslov,int godina,int numOfSongs,ArrayList pjesme) {
        this.imeIzvodjaca = izvodjac;
        this.naslov = naslov;
        this.godinaIzdanja = godina;
        this.brPjesama = numOfSongs;
        this.pjesme = pjesme;
    }



    public ArrayList getPjesme() {
        return pjesme;
    }

    public void setPjesme(ArrayList pjesme) {
        this.pjesme = pjesme;
    }

    public String getImeIzvodjaca() {
        return imeIzvodjaca;
    }

    public void setImeIzvodjaca(String imeIzvodjaca) {
        this.imeIzvodjaca = imeIzvodjaca;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public int getBrPjesama() {
        return brPjesama;
    }

    public void setBrPjesama(int brPjesama) {
        this.brPjesama = brPjesama;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] pjesme) {
        this.songs = songs;
    }



    @Override
    public String toString() {
        return imeIzvodjaca + " - " + naslov + "[" + godinaIzdanja + "]";
    }



    public String getTotalTime(Boolean ispisi){

        int ukupnoMinuta = 0;
        int ukupnoSekundi = 0;
        int trjanjeMin = 0;
        int trajanjeSek = 0;

       for(int i = 0;i<pjesme.size();i++){
           String str = pjesme.get(i).toString();
           str = str.replaceAll("[^0-9]+", " ");
           trjanjeMin = Integer.parseInt(str.substring(1,2));
           trajanjeSek = Integer.parseInt(str.substring(3,5));
           ukupnoMinuta = ukupnoMinuta + trjanjeMin;
           ukupnoSekundi = ukupnoSekundi + trajanjeSek;

           if(ukupnoSekundi >= 60){
               ukupnoMinuta++;
               ukupnoSekundi = ukupnoSekundi - 60;
           }
       }

       if(ispisi == true)
       {
           System.out.println("Ukupno trajanje pjesama na CD-u je: " + ukupnoMinuta + ":" + ukupnoSekundi);
       }

       return String.valueOf(ukupnoMinuta);
    }


    int prosjekMin = 0;
    int prosjekSek = 0;


    public String getAverage() {

        int ukupnoMinuta = 0;
        int ukupnoSekundi = 0;
        int trjanjeMin = 0;
        int trajanjeSek = 0;

        for(int i = 0;i<pjesme.size();i++){
            String str = String.valueOf(pjesme.get(i));
            str = str.replaceAll("[^0-9]+", " ");
            trjanjeMin = Integer.parseInt(str.substring(1,2));
            trajanjeSek = Integer.parseInt(str.substring(3,5));
            ukupnoMinuta = ukupnoMinuta + trjanjeMin;
            ukupnoSekundi = ukupnoSekundi + trajanjeSek;

            if(ukupnoSekundi >= 60){
                ukupnoMinuta++;
                ukupnoSekundi = ukupnoSekundi - 60;
            }
        }
        //--------------------------------------------------------------------------------
        int sekunde = (ukupnoMinuta * 60 + ukupnoSekundi) / this.getBrPjesama();
        prosjekMin = sekunde / 60;
        prosjekSek = (int) Math.floor(sekunde % 60);

        return "Prosjecno trajanje pjesme na albumu je : " + prosjekMin + ":" + prosjekSek;

    }
}
