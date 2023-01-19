package jp.ac.uryukyu.ie.e225704;

public class Ivysaur extends Pokemon{
    public Ivysaur(){
        this.setterName("フシギソウ");
        this.setterRaceValue(0, 60);
        this.setterRaceValue(1, 62);
        this.setterRaceValue(2, 63);
        this.setterRaceValue(3, 80);
        this.setterRaceValue(4, 80);
        this.setterRaceValue(5, 60);
        this.setterEvolutionLevel(32);

    }

    @Override
    public Pokemon evolution(){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Venusaur venusaur = new Venusaur();
            venusaur.takeStatus(this);
            System.out.println(this.getterName() + "は、" + venusaur.getterName() + "にしんかした！");
            return venusaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。");
            return this;
        }
    }
}
