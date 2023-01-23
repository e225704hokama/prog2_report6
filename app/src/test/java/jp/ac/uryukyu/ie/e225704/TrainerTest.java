package jp.ac.uryukyu.ie.e225704;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    @Test void summaryTest(){
        Bulbasaur bulbasaur1 = new Bulbasaur();
        for(int i=0; i<6; i++){
            bulbasaur1.setterIndividualValue(i, 31);
        }
        bulbasaur1.setterEfortValue(3, 252);
        bulbasaur1.setterEfortValue(5, 252);
        bulbasaur1.setterLevel(49);

        bulbasaur1.calcStatus(); 

        //テスト方法がよくわからなかったので、ネット上のポケモンステータス計算サイトの結果と照らし合わせている
        assertEquals(120, bulbasaur1.getterStatus(0));
        assertEquals(69, bulbasaur1.getterStatus(1));
        assertEquals(69, bulbasaur1.getterStatus(2));
        assertEquals(117, bulbasaur1.getterStatus(3));
        assertEquals(85, bulbasaur1.getterStatus(4));
        assertEquals(97, bulbasaur1.getterStatus(5));
    }
}
