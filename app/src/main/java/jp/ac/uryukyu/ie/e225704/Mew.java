package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public class Mew extends Pokemon{
    public Mew(){
        super();

        this.setterName("ใใฅใฆ");
        this.setterPrecious("๐ค");
        this.setterRaceValue(0, 100);
        this.setterRaceValue(1, 100);
        this.setterRaceValue(2, 100);
        this.setterRaceValue(3, 100);
        this.setterRaceValue(4, 100);
        this.setterRaceValue(5, 100);
        this.setterEvolutionLevel(0);
        this.setterEventCounter(3);

        if(this.getterIndividualValue(0) == 7 && this.getterIndividualValue(5) == 7){
            this.setterPrecious("โจ"); //่ฒ้ใใใผใฏใๅไฝใจๆฝ้ธๆนๆณใฏๅฐใ็ฐใชใใใ้้ใงใฏ่ฟใใๆนๆณใๆกใใใฆใใใ
        }
    }

    @Override
    public Pokemon evolution(Trainer trainer){
        System.out.println("ใใฎใใฑใขใณใฏใใใใใชใใใใ ใ\n");
        return this;
        
    }
}
