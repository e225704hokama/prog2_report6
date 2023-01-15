package jp.ac.uryukyu.ie.e225704;

public class Ivysaur extends Pokemon{
    public Ivysaur(){
        this.name = "フシギソウ";
        this.raceValue[0] = 60;
        this.raceValue[1] = 62;
        this.raceValue[2] = 63;
        this.raceValue[3] = 80;
        this.raceValue[4] = 80;
        this.raceValue[5] = 60;
        this.evolutionLevel = 32;

    }

    @Override
    public Pokemon evolution(){
        if(this.level >= this.evolutionLevel){
            Venusaur venusaur = new Venusaur();
            System.out.println(this.name + "は、" + venusaur.name + "にしんかした！");
            return venusaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。");
            return this;
        }
    }
}
