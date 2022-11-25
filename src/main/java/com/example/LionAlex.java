package com.example;

import java.util.List;

public class LionAlex extends Lion {


    public LionAlex(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }

    public List<String> getFriends(){
        return List.of("Марти", "Глория", "Мелман");
    }

    @Override
    public int getKittens(){
        return 0;
    }
}
