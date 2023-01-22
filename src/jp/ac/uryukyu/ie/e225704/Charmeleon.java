package jp.ac.uryukyu.ie.e225704;

public class Charmeleon extends Pokemon{
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

    @Override
    public Pokemon evolution(){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Charizard charizard = new Charizard();
            charizard.takeStatus(this);
            System.out.println(this.getterName() + "は、" + charizard.getterName() + "にしんかした！\n");
            return charizard;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
