package Model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Setter
@Getter

public abstract class Character{

    private String Type;




    private  @Length(min = 2, max = 5, message = "wtf") @NotEmpty(message = "cant be empty") @NotBlank(message = "cant be blank") String Name;

  //  @Range(from = 5, to = 10)
    private int Level;
    private String XP;
    private String Atk;
    private String Def;
    private String HP;
    private String[] heroType = new String[]{"Cowboy","Ninja","Chuck Norris", "Jacob Zuma"};


    public Character(@NotEmpty(message = "Name may not be empty") String name, String XP, String Atk, String Def, String HP){
        this.Type = heroType[(int)(Math.random() * ((3 - 0) + 1)) + 0];
        this.Name = name;
        this.Level = 1;
        this.XP = XP;
        this.Atk = Atk;
        this.Def = Def;
        this.HP = HP;
    };





}
