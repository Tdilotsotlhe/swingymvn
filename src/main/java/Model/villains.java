package Model;

public class villains extends Character{

        private String type;
        private String name;
        private int level;
        private Coordinates c =  new Coordinates(0, 0);

        public villains(String name, String XP, String Atk, String Def, String HP) {
            super(name, XP, Atk, Def, HP);
        }

        public Coordinates getC() {
            return c;
        }

        public void setC(int x, int y) {
            this.c = new Coordinates(x, y);
        }

    }

