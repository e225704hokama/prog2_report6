package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Squirtle extends Pokemon{
    /**
     * コンストラクタ
     * 種族値を代入する。しんかできるようになるレベルを代入する。HPと素早さの個体値が共に７だった場合色違いのマークをpreciousに追加する
     */
    public Squirtle(){
        super();

        this.setterName("ゼニガメ");
        this.setterRaceValue(0, 44);
        this.setterRaceValue(1, 48);
        this.setterRaceValue(2, 65);
        this.setterRaceValue(3, 50);
        this.setterRaceValue(4, 64);
        this.setterRaceValue(5, 43);
        this.setterEvolutionLevel(16);

        if(this.getterIndividualValue(0) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("✨"); //色違いマーク。原作と抽選方法は少し異なるが、金銀では近しい方法が採られていた。
        }
    }

    /**
     * Pokemonクラスのオーバーライド
     * Wartortleのインスタンスを返す
     */
    @Override
    public Pokemon evolution(Trainer trainer){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Wartortle wartortle = new Wartortle();
            wartortle.takeStatus(this);
            if(trainer.getterParty().contains(this)){
                int i = trainer.getterParty().indexOf(this);
                trainer.getterParty().remove(i);
            }
            System.out.println(this.getterName() + "は、" + wartortle.getterName() + "にしんかした！\n");
            return wartortle;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
