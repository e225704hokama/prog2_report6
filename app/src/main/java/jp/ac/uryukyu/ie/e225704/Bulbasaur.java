package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Bulbasaur extends Pokemon{
    /**
     * コンストラクタ
     * 種族値を代入する。しんかできるようになるレベルを代入する。HPと素早さの個体値が共に７だった場合色違いのマークをpreciousに追加する
     */
    public Bulbasaur(){
        super();

        this.setterName("フシギダネ");
        this.setterRaceValue(0, 45);
        this.setterRaceValue(1, 49);
        this.setterRaceValue(2, 49);
        this.setterRaceValue(3, 65);
        this.setterRaceValue(4, 65);
        this.setterRaceValue(5, 45);
        this.setterEvolutionLevel(16);

        if(this.getterIndividualValue(0) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("✨"); //色違いマーク。原作と抽選方法は少し異なるが、金銀では近しい方法が採られていた。
        }
    }

    /**
     * Pokemonクラスのオーバーライド
     * Ivysaurのインスタンスを返す
     */
    @Override
    public Pokemon evolution(Trainer trainer){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Ivysaur ivysaur = new Ivysaur();
            ivysaur.takeStatus(this);
            if(trainer.getterParty().contains(this)){
                int i = trainer.getterParty().indexOf(this);
                trainer.getterParty().remove(i);
            }
            System.out.println(this.getterName() + "は、" + ivysaur.getterName() + "にしんかした！\n");
            return ivysaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
