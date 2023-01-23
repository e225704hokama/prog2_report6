package jp.ac.uryukyu.ie.e225704;

public class Ivysaur extends Pokemon{
    /**
     * コンストラクタ
     * 種族値を代入する
     */
    public Ivysaur(){
        super();
        this.setterName("フシギソウ");
        this.setterRaceValue(0, 60);
        this.setterRaceValue(1, 62);
        this.setterRaceValue(2, 63);
        this.setterRaceValue(3, 80);
        this.setterRaceValue(4, 80);
        this.setterRaceValue(5, 60);
        this.setterEvolutionLevel(32);

    }

    /**
     * Pokemonクラスのオーバーライド
     * Venusaurのインスタンスを返す
     */
    @Override
    public Pokemon evolution(Trainer trainer){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Venusaur venusaur = new Venusaur();
            venusaur.takeStatus(this);
            if(trainer.getterParty().contains(this)){
                int i = trainer.getterParty().indexOf(this);
                trainer.getterParty().remove(i);
            }
            System.out.println(this.getterName() + "は、" + venusaur.getterName() + "にしんかした！\n");
            return venusaur;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
