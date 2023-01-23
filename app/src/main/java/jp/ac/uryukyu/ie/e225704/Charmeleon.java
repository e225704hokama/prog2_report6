package jp.ac.uryukyu.ie.e225704;

public class Charmeleon extends Pokemon{
    /**
     * コンストラクタ
     * 種族値を代入する
     */
    public Charmeleon(){
        super();
        this.setterName("リザード");
        this.setterRaceValue(0, 58);
        this.setterRaceValue(1, 64);
        this.setterRaceValue(2, 58);
        this.setterRaceValue(3, 80);
        this.setterRaceValue(4, 65);
        this.setterRaceValue(5, 80);
        this.setterEvolutionLevel(36);

    }

    /**
     * Pokemonクラスのオーバーライド
     * Charizardのインスタンスを返す
     */
    @Override
    public Pokemon evolution(Trainer trainer){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Charizard charizard = new Charizard();
            charizard.takeStatus(this);
            if(trainer.getterParty().contains(this)){
                int i = trainer.getterParty().indexOf(this);
                trainer.getterParty().remove(i);
            }
            System.out.println(this.getterName() + "は、" + charizard.getterName() + "にしんかした！\n");
            return charizard;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
