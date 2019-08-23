package Controller;

import View.heroView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Model.hero;
import java.util.ArrayList;
import java.io.*;

import java.io.*;
public class MyFileWriter {
    public static void saveHero(String str, hero h)
    {
        try {

            // Open given file in append mode.
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();

          //  builder.setPrettyPrinting().serializeNulls();

            String saveclass = gson.toJson(h);
            BufferedWriter out = new BufferedWriter(new FileWriter("heros.txt", true));
            out.write(saveclass + "\n");
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }


    public static hero loadHero() throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        File file = new File("heros.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        hero testh = null;
            while ((st = br.readLine()) != null) {
                testh = gson.fromJson(st, hero.class);
                heroView hv = new heroView();
                hv.printHeroStats(testh);

            }
            return testh;


    }
}
