package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Mew extends Pokemon{
    public Mew(){
        super();

        this.setterName("ミュウ");
        this.setterPrecious("🤍");
        this.setterRaceValue(0, 100);
        this.setterRaceValue(1, 100);
        this.setterRaceValue(2, 100);
        this.setterRaceValue(3, 100);
        this.setterRaceValue(4, 100);
        this.setterRaceValue(5, 100);
        this.setterEvolutionLevel(0);
        this.setterEventCounter(3);

        if(this.getterIndividualValue(0) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("✨"); //色違いマーク。原作と抽選方法は少し異なるが、金銀では近しい方法が採られていた。
        }
    }

    @Override
    public Pokemon evolution(Trainer trainer){
        System.out.println("このポケモンはしんかしないようだ。\n");
        return this;
        
    }
}
