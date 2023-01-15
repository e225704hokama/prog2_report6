package jp.ac.uryukyu.ie.e225704;

public class Venusaur extends Pokemon{
    public Venusaur(){
        this.name = "フシギバナ";
        this.raceValue[0] = 60;
        this.raceValue[1] = 62;
        this.raceValue[2] = 63;
        this.raceValue[3] = 80;
        this.raceValue[4] = 80;
        this.raceValue[5] = 60;
        this.evolutionLevel = 0;
    }

    @Override
    public Pokemon evolution(){
        System.out.println("これ以上は成長できなさそうだ。");
        return this;
    }
}
