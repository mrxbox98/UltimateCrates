package me.mrxbox98.UltimateCrates.crates;

import com.google.gson.Gson;
import me.mrxbox98.UltimateCrates.UltimateCrates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Crate {

    public ArrayList<CrateReward> rewards = new ArrayList<>();

    public static ArrayList<Crate> crates = new ArrayList<>();

    public String name;

    public int id;

    public Crate(String name)
    {
        this.id = new Random().nextInt();
        this.name=name;
        crates.add(this);

        save();
    }

    public CrateReward roll()
    {
        double roll = Math.random()*100;

        double stack=0;
        for(CrateReward crateReward: rewards)
        {
            if(stack<roll && stack+crateReward.getChance()>roll)
            {
                return crateReward;
            }
        }
        return null;
    }

    public String toGson()
    {
        Gson gson = new Gson();

        return gson.toJson(this);
    }

    public void save()
    {
        File folder = new File(UltimateCrates.instance.getDataFolder()+"/crates/");

        folder.mkdir();

        try {
            File file = new File(UltimateCrates.instance.getDataFolder()+"/crates/"+ id+".json");

            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);

            fileWriter.write(toGson());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static Crate fromJson(File file)
    {
        String str="";

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scanner.hasNext())
        {
            str+=scanner.next();
        }

        Gson gson = new Gson();
        return gson.fromJson(str, Crate.class);
    }



}
