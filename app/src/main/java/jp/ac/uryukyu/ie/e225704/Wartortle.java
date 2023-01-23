package jp.ac.uryukyu.ie.e225704;

public class Wartortle extends Pokemon{
    public Wartortle(){
        super();
        this.setterName("カメール");
        this.setterRaceValue(0, 59);
        this.setterRaceValue(1, 63);
        this.setterRaceValue(2, 80);
        this.setterRaceValue(3, 65);
        this.setterRaceValue(4, 80);
        this.setterRaceValue(5, 58);
        this.setterEvolutionLevel(36);

    }

    @Override
    public Pokemon evolution(Trainer trainer){
        if(this.getterLevel() >= this.getterEvolutionLevel()){
            Blastoise blastoise = new Blastoise();
            blastoise.takeStatus(this);
            if(trainer.getterParty().contains(this)){
                int i = trainer.getterParty().indexOf(this);
                trainer.getterParty().remove(i);
            }
            System.out.println(this.getterName() + "は、" + blastoise.getterName() + "にしんかした！\n");
            return blastoise;
        }
        else{
            System.out.println("思い上がり過ぎたようだ。\n");
            return this;
        }
    }
}
