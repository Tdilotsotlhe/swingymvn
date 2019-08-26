package Model;


import View.gameView;
import Controller.MyFileWriter;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


public class hero extends Character {

    private String type;
    // @NotNull(message = "Name cannot be null")

    // @Size(max = 2, message = "piss off")
   // private String name;
   // private int level;
    private Coordinates c = new Coordinates(0, 0);

    public hero(String name, String XP, String Atk, String Def, String HP) {
        super(name, XP, Atk, Def, HP);
    }

    public Coordinates getC() {
        return c;
    }

    public void setC(int x, int y) {
        this.c = new Coordinates(x, y);
    }



    public void move(char direction) {
        gameView gv = new gameView();
        int newLevel = (this.getLevel() - 1) * 5 + 10 - (this.getLevel() % 2);
        System.out.println(newLevel);
        System.out.println(this.getLevel());

        switch (java.lang.Character.toLowerCase(direction)) {
            case 'w':
            //    System.out.println("Pressed W");
                //double check the <= condition
                if (this.getC().getY() < newLevel && this.getC().getY() >= 0) {
                    this.c.setY(this.getC().getY() + 1);
                } else {
                    System.out.println("You have reached the end of the dungeon, Congratulations");
                    gainXPWall();
                    gv.wallEndsGame();
                    //save game
                    String heroSave = this.getName() + "," + this.getAtk() + "," + this.getDef() + "," + this.getHP() + "," + this.getXP() + "," + this.getLevel();
                    System.out.println("SAVING GAME........");
                    MyFileWriter.saveHero(heroSave, this);
                    System.exit(0);
                }
                break;
            case 'a':
              //  System.out.println("Pressed a");
                if (this.getC().getX() < newLevel && this.getC().getX() > 0 ) {
                    this.c.setX(this.getC().getX() - 1);
                } else {
                    gainXPWall();
                    gv.wallEndsGame();
                    //save game
                    String heroSave = this.getName() + "," + this.getAtk() + "," + this.getDef() + "," + this.getHP() + "," + this.getXP() + "," + this.getLevel();
                    System.out.println("SAVING GAME........");
                    MyFileWriter.saveHero(heroSave, this);
                    System.exit(0);
                }

                break;
            case 's':
              //  System.out.println("Pressed s");
                if (this.getC().getY() < newLevel && this.getC().getY() > 0) {
                    this.c.setY(this.getC().getY() - 1);
                } else {
                    gainXPWall();
                    gv.wallEndsGame();
                    //save game
                    String heroSave = this.getName() + "," + this.getAtk() + "," + this.getDef() + "," + this.getHP() + "," + this.getXP() + "," + this.getLevel();
                    System.out.println("SAVING GAME........");
                    MyFileWriter.saveHero(heroSave, this);
                    System.exit(0);
                }

                break;
            case 'd':
            //    System.out.println("Pressed d");
                if (this.getC().getX() < newLevel && this.getC().getY() >= 0) {
                    this.c.setX(this.getC().getX() + 1);
                } else {
                    gainXPWall();
                    gv.wallEndsGame();
                    //save game

                    String heroSave = this.getName() + "," + this.getAtk() + "," + this.getDef() + "," + this.getHP() + "," + this.getXP() + "," + this.getLevel();
                  //move this
                    System.out.println("SAVING GAME........");
                    MyFileWriter.saveHero(heroSave, this);
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Invalid move");
                break;
        }
    }

    public void constraints(hero h, Grid g) {

    }

    public void gainXPWall() {
        this.setXP(Integer.toString(Integer.parseInt(this.getXP()) + 500));
        if(Integer.parseInt(this.getXP()) > ((this.getLevel()) * 1000 + 1 << (this.getLevel() + 1)) * 450){
            //move this
            System.out.println("YOU HAVE LEVELED UP");
            //set level
            this.setLevel(this.getLevel() + 1);
            System.exit(0);
        }
    }


}
