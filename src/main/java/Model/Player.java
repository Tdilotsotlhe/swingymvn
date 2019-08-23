package Model;



import java.util.ArrayList;

public class Player {

    private ArrayList<hero> heroList = new ArrayList<hero>();

    public void addHeroList(hero newHero) {
        heroList.add(newHero);

    }

    public void removeHeroList(hero newHero) {
        heroList.remove(newHero);
    }

    public void loadHeroList(){
        //read heros from file
    }

    public void saveHeroList(){
        //save heroList to file

    }
}
