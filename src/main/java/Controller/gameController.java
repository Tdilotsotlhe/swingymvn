package Controller;


import Model.Coordinates;
import Model.hero;
import Model.villains;
import Model.Grid;
import View.gameView;
import View.heroView;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class gameController {

//    public static void main(String[] args) {
//        System.out.println("testing");
//    }
    //drawmap
    public void fight_sim(hero h, villains v) {

        Grid newGrid = Grid.getInstance();
        //hero details
        heroView heroViewer = new heroView();
        gameView gv = new gameView();

        int heroatk = Integer.parseInt(h.getAtk());
        int herodef =Integer.parseInt(h.getDef());
        int herohp = Integer.parseInt(h.getHP());
        //viallain details
        int villatk = Integer.parseInt(v.getAtk());
        int villdef =Integer.parseInt(v.getDef());
        int villhp = Integer.parseInt(v.getHP());

        while(villhp > 0 && herohp > 0){
            //get HP,atk,def
            villhp -= (heroatk - villdef);
            int arp = ThreadLocalRandom.current().nextInt(3);
            if(villhp <= 0){
                System.out.println("Villain is dead");


                //give artifact

                switch (arp){
                    case 1: //atk bonus
                        System.out.println("recieved attack artifact");
                        gainXP(h,v, 0);
                        h.setAtk(Integer.toString((Integer.parseInt(h.getAtk()) + 10)));
                        heroViewer.printHeroDetails(h);
                       // gv.printVillains(newGrid);
                        break;
                    case 2://def bonus
                        System.out.println("recieved defence artifact");
                        gainXP(h,v, 0);
                        h.setDef(Integer.toString((Integer.parseInt(h.getDef()) + 10)));
                        heroViewer.printHeroDetails(h);
                    //    gv.printVillains(newGrid);
                        break;
                    case 3://hp bonus
                        System.out.println("recieved hp artifact");
                        gainXP(h,v, 0);
                        h.setHP(Integer.toString((Integer.parseInt(h.getHP()) + 10)));
                        heroViewer.printHeroDetails(h);
                      //  gv.printVillains(newGrid);
                        break;
                    default:
                        gainXP(h,v, 0);
                        break;
                }

                newGrid.getVillainStack().remove(v); //delete villain


            }
            if(herohp <= 0){
                System.out.println("you are dead");
                System.exit(0);
            }
            if(villhp > 0) {
                herohp -= (villatk);
            }
//            if(arp > 3 && villhp <= 0){
//                //generic XP gain
//                gainXP(h,v, 0);
//            }

        }

   }

   public void gainXP(hero hw, villains vw, int wall){

        if(wall == 1){
            int oldXP = Integer.parseInt(hw.getXP()) + 500;
            hw.setXP(Integer.toString(oldXP));
        }

       int randomizer = ThreadLocalRandom.current().nextInt(Integer.parseInt(vw.getAtk()) + 600, Integer.parseInt(vw.getAtk()) + 800)+ Integer.parseInt(hw.getXP());
       hw.setXP(Integer.toString(randomizer + Integer.parseInt(hw.getXP())));
       //call a view to announce new XP
       System.out.println("You new XP:" + hw.getXP()+ "XP");
       //check level
       if(Integer.parseInt(hw.getXP()) >= ((hw.getLevel() + 1) * 1000 + (Math.pow(hw.getLevel(), 2) *450))){
           System.out.println("YOU HAVE LEVELED UP");
           //set level
           hw.setLevel(hw.getLevel() + 1);
           //reset grid
           Grid newGrid = Grid.getInstance();
           newGrid.genMap(hw.getLevel());
           newGrid.getVillainStack().clear();
           newGrid.genVillains(hw.getLevel());
           hw.setC(newGrid.getMapCenter().getX(), newGrid.getMapCenter().getY());
       }


   }

   public int runfight(){
     return ThreadLocalRandom.current().nextInt(0, 1);
   }

   public int combatInput(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("1) Fight");
       System.out.println("2) Run");


       while (!scanner.hasNextInt())
       {

           scanner.nextLine(); //clear the invalid input before prompting again
           System.out.println("Please enter a valid option ");
       }

       int selection = scanner.nextInt();
       return selection;
   }

}



