package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Bulbasaur extends Pokemon{
    public Bulbasaur(){
        this.setterName("フシギダネ");
        for(int i=0; i<6; i++){
            this.setterIndividualValue(i, new Random().nextInt(32));
        }

        this.setterRaceValue(0, 45);
        this.setterRaceValue(1, 49);
        this.setterRaceValue(2, 49);
        this.setterRaceValue(3, 65);
        this.setterRaceValue(4, 65);
        this.setterRaceValue(5, 45);

        this.setterLevel(1);
        this.setterEvolutionLevel(16);
        if(this.getterIndividualValue(3) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("✨"); //色違いマーク。原作と抽選方法は少し異なるが、金銀では近しい方法が採られていた。
        }
    }

    @Override
    public Pokemon evolution(){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Ivysaur ivysaur = new Ivysaur();
            ivysaur.takeStatus(this);
            System.out.println(this.getterName() + "は、" + ivysaur.getterName() + "にしんかした！");
            return ivysaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。");
            return this;
        }
    }
}
