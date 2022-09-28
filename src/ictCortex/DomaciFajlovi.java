package ictCortex;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class DomaciFajlovi {

    CompactDisc cd = new CompactDisc();

    public String fName = new String("C:\\Users\\Jukazuma\\Desktop\\PROJEKAT\\podaciDisk.txt");

    public void appendToTextFile(String fName, CompactDisc cd) {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(fName, true))) {
            buf.write(cd.getImeIzvodjaca() + "\n" + cd.getNaslov() + "\n" + cd.getGodinaIzdanja() +  " " + cd.getBrPjesama() + "\n");
            for (int i = 0; i < cd.pjesme.size(); i++) {
                buf.write(cd.pjesme.get(i).toString() + "\n");
            }
            System.out.println("Uspjeno upisani podaci u fajl");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Greska pri upisivanju podataka u fajl!");
        }
    }


    public void readFromTextFile(String fName, int minLength, int maxLength, boolean toFile) {

        ArrayList<CompactDisc> cds = new ArrayList<CompactDisc>();
        try {
            File myFile = new File(fName);
            Scanner scan = new Scanner(myFile);

            int i = 1;
            int brPjesama = 0;

            ArrayList pjesme1 = new ArrayList();
            CompactDisc cd = new CompactDisc();
            String data = "";
            boolean newLine = false;
            while (scan.hasNextLine()) {
                if (newLine == true) {
                    newLine = false;
                } else {
                    data = scan.nextLine();
                }
                int test = brPjesama + 4;
                if (i == 1) {
                    cd.setImeIzvodjaca(data);
                } else if (i == 2) {
                    cd.setNaslov(data);
                } else if (i == 3) {
                    cd.setGodinaIzdanja(Integer.parseInt(data.substring(0, data.length() - 3)));
                    cd.setBrPjesama(Integer.parseInt(data.substring(data.length() - 2, data.length())));

                    brPjesama = Integer.parseInt(data.substring(data.length() - 2, data.length()));
                } else if (i > 3 && i < test) {
                    pjesme1.add(data);
                }
                if (i >= test) {

                    i = 0;
                    cd.setPjesme(pjesme1);
                    if (Integer.parseInt(cd.getTotalTime(false)) > minLength
                            && Integer.parseInt(cd.getTotalTime(false)) < maxLength) {
                        cds.add(cd);
                    }
                    cd = new CompactDisc();
                    pjesme1 = new ArrayList();
                    brPjesama = 0;
                    newLine = true;
                }
                i++;
            }
            cd.setPjesme(pjesme1);
            if (Integer.parseInt(cd.getTotalTime(false)) > minLength
                    && Integer.parseInt(cd.getTotalTime(false)) < maxLength) {
                cds.add(cd);
            }
            if (toFile == false) {
                for (int i1 = 0; i1 < cds.size(); i1++) {

                    System.out.println("Ukupno trajanje pjesama na albumu " +
                            cds.get(i1).imeIzvodjaca + "-" + cds.get(i1).naslov + " " + "[" + cds.get(i1).godinaIzdanja
                                    + "]" + " je " + cds.get(i1).getTotalTime(false) + " minuta");
                }
            } else {
                try {
                    FileWriter file = new FileWriter("C:/Users/Jukazuma/Desktop/PROJEKAT/rezultat.txt", true);
                    for (int i1 = 0; i1 < cds.size(); i1++) {
                        file.write(cds.get(i1).imeIzvodjaca + "-" + cds.get(i1).naslov + " " + "["
                                + cds.get(i1).godinaIzdanja + "]" + " " + cds.get(i1).getTotalTime(false)
                                + " minuta" + "\n");
                        System.out.println("Podaci upisani u fajl...");
                    }
                    file.close();
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    System.out.println("");
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Doslo je do greske.");
            e.printStackTrace();
        }
    }



}