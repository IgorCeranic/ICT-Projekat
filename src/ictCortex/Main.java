package ictCortex;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {





        String[] pjesme1 = {"I Will Follow (3:37)","Twilight (4:23)","An Cat Dubh (4:46)","Into The Heart (3:27)","Out Of Control (4:12)",
        "Stories For Boys (3:04)","The Ocean (1:35)","A Day Without Me (3:12)","Another Time, Another Place (4:31)","The Electric Co. (4:47)",
        "Shadows And Tall Trees (4:36)","Untitled (0:38)"};                     //prvi nacin da se upise
        ArrayList<String> pjesme11 = new ArrayList<>(Arrays.asList(pjesme1));

        String [] pjesme2 = {"Back In The Game (4:57)", "Open Your Heart To The World (4:13)", "Street Rituals (5:11)", "The Limit Of A Man (6:02)",
        "Strange People (4:45)", "Your Balloon Is Rising (5:27)", "The Colour Of... (6:31)", "A Love Uprising (6:20)", "These Life Stories (4:52)",
        "Pushing Your Love (4:41)", "What's Going On (5:58)", "Simplify The Situation (7:57)"};
        ArrayList<String> pjesme22 = new ArrayList<>(Arrays.asList(pjesme2));

        String[] pjesme3 = {"Another Flaming Tune (2:23)","Beguiling The Hours (4:11)", "The Best Weapon (3:28)", "A To B (3:48)", "Breast Stroke (3:29)",
                "Raindrops From Heavens (7:31)", "Restless Mind (4:07)", "B To A (3:52)", "Golden Age (6:29)", "It's Madness (4:50)", "Generous Moon (3:56)"};
        ArrayList<String> pjesme33 = new ArrayList<>(Arrays.asList(pjesme3));

        String [] pjesme4 = {"Barley  (5:07)", "Seems I'm Never Tired Lovin' You (3:43)", "Singing In My Soul (3:46)" ,
                "Southern Nights (4:14)", "What Would I Do Without You (3:17)", "Grace   (4:55)", "Stars Fell On Alabama (3:52)",
                "Every Grain Of Sand (5:29)", "Wash Me Clean (4:34)", "All The Way Here (3:47) "};
        ArrayList<String> pjesme44 = new ArrayList<>(Arrays.asList(pjesme4));

        String [] pjesme5 = {"Bravado (3:43)", "Royals (3:12)" , "Million Dollar Bills (2:20)",
                "The Love Club (3:23)", "Biting Down (3:33)"};
        ArrayList<String> pjesme55 = new ArrayList<>(Arrays.asList(pjesme5));

        String[] pjesme6 = {"Paid (2:34)", "Come Meh Way (3:35)", "Time (4:04)", "Oatmeal (4:56)", "Golden City (2:34)", "Wake Up (5:09)"};

        ArrayList<String> pjesme66 = new ArrayList<>(Arrays.asList(pjesme6));


        /*CompactDisc cd1 = new CompactDisc("U2","Boy",1980,pjesme1.length,pjesme1);
        CompactDisc cd2 = new CompactDisc("Stone Foundation","Live Rituals",2017,pjesme2.length,pjesme2);
        CompactDisc cd3 = new CompactDisc("Gareth Williams & Mary Currie","Flaming Tunes",1985,pjesme3.length,pjesme3);
        CompactDisc cd4 = new CompactDisc("Lizz Wright ","Grace",2017,pjesme4.length,pjesme4);
        CompactDisc cd5 = new CompactDisc("Lorde","The Love Club EP",2017,pjesme5.length,pjesme5);
        CompactDisc cd6 = new CompactDisc("Nadine Shah","Holiday Destination",2017,pjesme6.length,pjesme6);*/


        CompactDisc cd1 = new CompactDisc("U2","Boy",1980,pjesme11.size(),pjesme11);
        CompactDisc cd2 = new CompactDisc("Stone Foundation","Live Rituals",2017, pjesme22.size(),pjesme22);
        CompactDisc cd3 = new CompactDisc("Gareth Williams & Mary Currie","Flaming Tunes",1985,pjesme33.size(),pjesme33);
        CompactDisc cd4 = new CompactDisc("Lizz Wright ","Grace",2017,pjesme44.size(),pjesme44);
        CompactDisc cd5 = new CompactDisc("Lorde","The Love Club EP",2017,pjesme55.size(),pjesme55);
        CompactDisc cd6 = new CompactDisc("Nadine Shah","Holiday Destination",2017,pjesme66.size(),pjesme66);



       CompactDisc[] sviDiskovi = {cd1,cd2,cd3,cd4,cd5,cd6};


        for(int i = 0;i<sviDiskovi.length;i++){
            sviDiskovi[i].getTotalTime(true);
            System.out.println(sviDiskovi[i].getAverage());
        }

      //System.out.println(sviDiskovi[5].getTotalTime(true));

        DomaciFajlovi df = new DomaciFajlovi();

//        df.appendToTextFile(df.fName, cd1);
//        df.appendToTextFile(df.fName, cd2);
//        df.appendToTextFile(df.fName, cd3);
//        df.appendToTextFile(df.fName, cd4);
//        df.appendToTextFile(df.fName, cd5);
//        df.appendToTextFile(df.fName, cd6);


       df.readFromTextFile("C:/Users/Jukazuma/Desktop/PROJEKAT/podaciDisk.txt",10,50,false);



//        CompactDisc[] cds = {cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8};
//        for(CompactDisc c:cds){
//            System.out.println(c.toString());
//        }


    }
}
