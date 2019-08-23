package Model;

import View.gameView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Getter @Setter
//@NoArgsConstructor
public  class Grid {

    private static Grid single_instance = null;
    private Coordinates mapCenter;
    private int[][] newMap;
    private int walls;
   // private int newLevel;
    private ArrayList<villains> villainStack = new ArrayList<villains>();

    public static Grid getInstance()
    {
        if (single_instance == null)
            single_instance = new Grid();

        return single_instance;
    }


    public Grid genMap(int level){
       int newLevel = (level - 1)*5+10-(level%2);
       this.walls = newLevel;
       newMap = new int[newLevel][newLevel];
       this.newMap = newMap;
       this.mapCenter = new Coordinates((newLevel/2), (newLevel/2));
       return this;
   }

   public Coordinates getMapCenter(){
       return this.mapCenter;
   }

   public void genVillains(int level){

        //init villain stack
       villains initVillain = new villains("Villain","0", Integer.toString(1),Integer.toString(1),"100");
       initVillain.setC(1,1);
       this.villainStack.add(initVillain);

//       int XP = (int) (Math.random() * ((13000 - 0) + 1)) + 0;

       int atk = level * 5;
       int def = level * 5;


       //randomly place villain
       //generate position, check for copies before modify;

       //test vill
       for (int i = 0; i < (level * 5); i++) {

           int newLevel = (level- 1) * 5 + 10 - (level % 2);
           int checker = 0;
           villains newerVillain = new villains("Villain", "0", Integer.toString(atk), Integer.toString(atk), "100");
           Coordinates randomCoordsGen;// = new Coordinates(ThreadLocalRandom.current().nextInt(7), ThreadLocalRandom.current().nextInt(7) );

           while (checker == 0) {
               randomCoordsGen = new Coordinates(ThreadLocalRandom.current().nextInt(newLevel),
                       ThreadLocalRandom.current().nextInt(newLevel));

               //stop checking xcheckvill pos before adding, fixed with adding first vbill
               int x = checkVillPos(randomCoordsGen);
               if (x == -1) {
                   newerVillain.setC(randomCoordsGen.getX(), randomCoordsGen.getY());
                   checker = 1;
               }
           }
           //int newLevel = (Integer.parseInt(level) - 1)*5+10-(Integer.parseInt(level)%2);

           //newerVillain.setC(1, 2);
           this.addVillains(newerVillain);

       }

   }

    public void addVillains(villains newVillain){
       villainStack.add(newVillain);
    }

    public void delVillains(villains newVillain){
       villainStack.remove(newVillain);
    }

    public int checkVillPos(Coordinates C){
        gameView gc = new gameView();

       int retVal = -1;
       int villsize = this.villainStack.size();

       for(int i = 0; i < villsize; i++)
       {
           //gc.printVillains(this);

             if( villainStack.get(i).getC().getY() == C.getY() && villainStack.get(i).getC().getX() == C.getX()){
                 retVal = i;
             }
       }
           return retVal;
    }


}
