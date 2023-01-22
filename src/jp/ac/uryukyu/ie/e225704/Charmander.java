package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Charmander extends Pokemon{
    public Charmander(){
        super();

        this.setterName("ヒトカゲ");
        this.setterRaceValue(0, 39);
        this.setterRaceValue(1, 52);
        this.setterRaceValue(2, 43);
        this.setterRaceValue(3, 60);
        this.setterRaceValue(4, 55);
        this.setterRaceValue(5, 50);
        this.setterEvolutionLevel(16);

        if(this.getterIndividualValue(0) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("✨"); //色違いマーク。原作と抽選方法は少し異なるが、金銀では近しい方法が採られていた。
        }
    }

    @Override
    public Pokemon evolution(){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Charmeleon charmeleon = new Charmeleon();
            charmeleon.takeStatus(this);
            System.out.println(this.getterName() + "は、" + charmeleon.getterName() + "にしんかした！\n");
            return charmeleon;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
