package Controller;


import Model.hero;
import View.heroView;


public class heroController {
    private hero model;
    private heroView view;

    public heroController(hero model, heroView view){
        this.model = model;
        this.view = view;
    }

    public void setHeroName(String newName){
        model.setName(newName);
    }

    public void setHeroType(String newType){
        model.setType(newType);
    }

    public String getHeroName(){
        return model.getName();
    }

    public String getHeroType(){
        return model.getName();
    }

    public void movement(){

    }

    public void updateView(){
        view.printHeroDetails(this.model);
    }
}
