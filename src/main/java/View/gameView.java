package View;

import Model.*;

public class gameView {

    public void directions(){
        System.out.println("Select a direction to move");
        System.out.println("w) North");
        System.out.println("a) South");
        System.out.println("s) East");
        System.out.println("d) West");
    }

    public void Obstacle(){
        System.out.println("You have encountered an obstacle...Try Going a different direction fool");
        System.out.println("w) North");
        System.out.println("a) South");
        System.out.println("s) East");
        System.out.println("d) West");
    }

    public void wallEndsGame(){
        System.out.println("You have reached the end of the dungeon, CONGRATS... game over...bye....");
    }

    public void Enemy(){
        System.out.println("You have encountered an Enemy...");
        System.out.println("1) Fight");
        System.out.println("2) Run");
    }

    public void LevelUp(){
        System.out.println("You have Leveled Up...");

    }

    public void Death(){
        System.out.println("The young Warrior was no match for Debo...your dead");
    }

    public void printVillains(Grid villstack){


        for (villains v : villstack.getVillainStack()) {
            System.out.println(v.getName());
            System.out.println(v.getC().getX() + "   " + v.getC().getY());
        }

            //display all details


    }

    public void fightorrun() {
        System.out.println(" fight or run, time to go night night nigger");
    }

    public void ran() {
        System.out.println("your hero ranaway");
    }

    public void quitGame() {
        System.out.println("WE are quitting...BYE");
    }

    public void savingGame() {
        System.out.println("SAVING GAME........");
    }

    public void intro() {
        System.out.println("LOOOONG, LOOOOoooooOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("NG.......Ago...");
        System.out.println("One man, One Desire..... he coded swingy on the fourth floor.......");
        System.out.println("and the mob wanted in....");

    }

    public void villLoc() {
        System.out.println("the villains are located here:");
    }







}
