package Controller;

import Model.Coordinates;
import Model.Grid;
import Model.Player;
import Model.hero;
import View.gameView;
import View.heroView;
import View.mainView;

import org.hibernate.validator.constraints.Length;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Set;

import static java.lang.annotation.ElementType.*;

//
//import java.util.Scanner;
public class Main {




    public static void main(String[] args) throws IOException {

        Player newPlayer = new Player();

        MainMenu();
//        String[] userHeroDetails =mv createHero();
//        hero newHero = new hero(userHeroDetails[1],userHeroDetails[2],userHeroDetails[3],userHeroDetails[4],userHeroDetails[5]);
//        heroView newmain = new heroView();
//        heroController controller = new heroController(newHero, newmain);
//        controller.updateView();
//        newHero.setC(10, 20);
//        controller.updateView();
    }

//    public static String[] createHero(){
//        //gather info, move this fuynction
//        String[] newHero = new String[6];
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(" Enter Hero Name:");
//        try {
//            newHero[0] = scanner.next();
//            // do stuff
//        } catch (InputMismatchException e){
//             System.out.println("enter proper name nigger");
//        }
//
//        int selection = Integer.parseInt(scanner.next());
//
//        newHero[1] = "Jesus";
//        newHero[2] = "Holy Mabn";
//        newHero[3] = "0";
//        newHero[4] = "5";
//        newHero[5] = "5";
//
//        return newHero;
//    }

    public static void MainMenu() throws IOException {

        Scanner scanner = new Scanner(System.in);
        hero newHero = null;

        int looper = 1;
        int startGame = 0;
        mainView mmView = new mainView();
        while (looper == 1){
            int selection = 0;
            mmView.mainMenu();

            while (!scanner.hasNextInt())
            {
                scanner.nextLine(); //clear the invalid input before prompting again
                mmView.valOption();
            }

            selection = scanner.nextInt();

            switch(selection){
                case 1:
                    heroView heroViews = new heroView();
                    heroViews.createHero();
                    String newName = scanner.next();
                    //validate XP/LEVEL1
                    newHero = new hero(newName,"1","10","10","100");
                  //  System.out.println(selection);
                    looper = 0;
                    startGame = 1;
                    break;
                case 2:
                    newHero = MyFileWriter.loadHero();
                    looper = 0;
                    startGame = 1;
                    break;
                default:
                    break;
            }

        }


        //add escape key
        String input = "this is user input";
     //   System.out.println(input + "Controls: W - UP, A - LEFT , S - DOWN, D - RIGHT, OPTIONS - 1, 2, 3...");
        Grid newGrid = Grid.getInstance();
        newGrid.genMap(newHero.getLevel());
        newHero.setC(newGrid.getMapCenter().getX(), newGrid.getMapCenter().getY());


        gameView gv = new gameView();
        heroView hv = new heroView();
        gameController gc = new gameController();
        //generate villains
        newGrid.genVillains(newHero.getLevel());
        hv.printHeroStats(newHero);
        //gv.printVillains(newGrid);
        int vilPos;
        mainView mv = new mainView();
       // gv.printVillains(newGrid);
        //intro
        gv.intro();

        while (startGame == 1){

            gv.villLoc();
            gv.printVillains(newGrid);
            hv.printHeroLoc(newHero);

            mv.directions();

            //add fight and run sim
            input = scanner.next();
            if (input.equals("exit")){

                String heroSave = newHero.getName() + "," + newHero.getAtk() + "," + newHero.getDef() + "," + newHero.getHP() + "," + newHero.getXP() + "," + newHero.getLevel();

                MyFileWriter.saveHero(heroSave, newHero);
                        gv.savingGame();
                        gv.quitGame();
                        //save to fwile
                        System.exit(0);


                 }else{

                //undo movement when nrunnign
                Coordinates oldCoords = new Coordinates(newHero.getC().getX(), newHero.getC().getY());

                //move dat bastard
                newHero.move(input.charAt(0));
                hv.printHeroLoc(newHero);
                 //gv.printVillains(newGrid);

                //check if theres anybody there...
                if((vilPos = newGrid.checkVillPos(newHero.getC())) > -1)
                    {
                        gv.fightorrun();

                        while(true) {

                            int rand = gc.runfight();
                            int combin = gc.combatInput();
                            if (combin == 2 && rand == 1) {
                                gv.ran();
                                //reset cooordinates to orignal
                                newHero.setC(oldCoords.getX(), oldCoords.getY());
                                break;
                                //reset cooordinates to orignal
                            } else if (combin == 1 || (combin == 2 && rand  == 0)) {
                                gc.fight_sim(newHero, newGrid.getVillainStack().get(vilPos));
                                hv.printHeroDetails(newHero);
                                break;
                            }else{

                                gv.invalidMove();
                            }
                        }
                    }


                 }


        }

    }


}
