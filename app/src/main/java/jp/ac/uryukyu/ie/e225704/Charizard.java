package jp.ac.uryukyu.ie.e225704;

public class Charizard extends Pokemon{
    /**
     * コンストラクタ
     * 種族値を代入する
     */
    public Charizard(){
        this.setterName("リザードン");
        this.setterRaceValue(0, 78);
        this.setterRaceValue(1, 84);
        this.setterRaceValue(2, 78);
        this.setterRaceValue(3, 109);
        this.setterRaceValue(4, 85);
        this.setterRaceValue(5, 100);
        this.setterEvolutionLevel(0);
    }

    /**
     * Pokemonクラスのオーバーライド
     * しんかしないため自身のインスタンスを返す
     */
    @Override
    public Pokemon evolution(Trainer trainer){
        System.out.println("これ以上は成長できなさそうだ。\n");
        return this;
    }
}
