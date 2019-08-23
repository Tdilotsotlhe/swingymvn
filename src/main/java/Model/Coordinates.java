package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coordinates {


    private int x;
    private int y;




    //check border limits per move and validate using annotations
    public void moveUp(){
        this.x++;
    }

    public void moveDown(){
        this.x++;
    }

    public void moveLeft(){
        this.y--;
    }

    public void moveRight(){
        this.y++;
    }

}
