package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Bulbasaur extends Pokemon{
    public Bulbasaur(){
        this.name = "フシギダネ";
        this.individualValue[0] = new Random().nextInt(32);
        this.individualValue[1] = new Random().nextInt(32);
        this.individualValue[2] = new Random().nextInt(32);
        this.individualValue[3] = new Random().nextInt(32);
        this.individualValue[4] = new Random().nextInt(32);
        this.individualValue[5] = new Random().nextInt(32);

        this.raceValue[0] = 45;
        this.raceValue[1] = 49;
        this.raceValue[2] = 49;
        this.raceValue[3] = 65;
        this.raceValue[4] = 65;
        this.raceValue[5] = 45;

        this.level = 1;
        this.evolutionLevel = 16;
    }

    @Override
    public Pokemon evolution(){
        if(this.level >= this.evolutionLevel){
            Ivysaur ivysaur = new Ivysaur();
            System.out.println(this.name + "は、" + ivysaur.name + "にしんかした！");
            return ivysaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。");
            return this;
        }
    }
}
