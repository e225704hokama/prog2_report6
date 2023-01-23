package jp.ac.uryukyu.ie.e225704;

public class Blastoise extends Pokemon{
    public Blastoise(){
        this.setterName("カメックス");
        this.setterRaceValue(0, 79);
        this.setterRaceValue(1, 83);
        this.setterRaceValue(2, 100);
        this.setterRaceValue(3, 85);
        this.setterRaceValue(4, 105);
        this.setterRaceValue(5, 78);
        this.setterEvolutionLevel(0);
    }

    @Override
    public Pokemon evolution(Trainer trainer){
        System.out.println("これ以上は成長できなさそうだ。\n");
        return this;
    }
}
