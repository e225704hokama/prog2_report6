package jp.ac.uryukyu.ie.e225704;

public class Venusaur extends Pokemon{
    public Venusaur(){
        this.setterName("フシギバナ");
        this.setterRaceValue(0, 80);
        this.setterRaceValue(1, 82);
        this.setterRaceValue(2, 83);
        this.setterRaceValue(3, 100);
        this.setterRaceValue(4, 100);
        this.setterRaceValue(5, 80);
        this.setterEvolutionLevel(0);
    }

    @Override
    public Pokemon evolution(Trainer trainer){
        System.out.println("これ以上は成長できなさそうだ。\n");
        return this;
    }
}
