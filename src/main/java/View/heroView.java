package View;

import Model.hero;
import org.jetbrains.annotations.NotNull;

public class heroView {

    public void printHeroDetails(@NotNull hero curHero){

        //display all details
        System.out.println(curHero.getName());
        System.out.println(curHero.getType());
    }

    public void createHero(){

        System.out.println("Please enter Hero name: ");
    }

    public void printHeroLoc(@NotNull hero newHero){
       System.out.println("Your Location - X:" + newHero.getC().getX() + " Y: " + newHero.getC().getY());
    }



    public void printHeroStats(@NotNull hero newHero){
        System.out.println("Hero Details,");
        System.out.println("Name : " + newHero.getName());
        System.out.println("Atk : " + newHero.getAtk());
        System.out.println("Def : " + newHero.getDef());
        System.out.println("HP : " + newHero.getHP());
        System.out.println("XP : " + newHero.getXP());
        System.out.println("Level : " + newHero.getLevel());
    }
}
