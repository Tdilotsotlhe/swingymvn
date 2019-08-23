package View;

public class mainView {

    public void mainMenu(){
        System.out.println("Welcome to SWINGY!!!!!!!!!!!!!!");
        System.out.println(" 1) Create New Hero");
        System.out.println(" 2) Select Previously Created Hero");
    }

    public void directions(){
        System.out.println("Select a direction to move");
        System.out.println("w) North");
        System.out.println("a) South");
        System.out.println("s) East");
        System.out.println("d) West");
    }

    public void valOption() {
        System.out.println("Please enter a valid option ");
    }

}
