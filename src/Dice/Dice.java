package Dice;

public class Dice {
    public int dice4(){
        return (int) ((Math.random() * 4) +1);
    }

    public int dice6(){
        return (int) ((Math.random() * 6) + 1);
    }

    public int dice8(){
        return (int) ((Math.random() * 8) + 1);
    }

    public int dice10(){
        return (int) ((Math.random() * 10) + 1);
    }

    public int dice20(){
        return (int) ((Math.random() * 20) + 1);
    }
}
