package jp.ac.uryukyu.ie.e225704;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    @Test void takeStatusTest(){
        Bulbasaur bulbasaur1 = new Bulbasaur();
        for(int i=0; i<6; i++){
            bulbasaur1.setterIndividualValue(i, 10);
            bulbasaur1.setterEfortValue(i, 20);
        }
        bulbasaur1.setterLevel(9); //初期値が１で＋９するので１０になる
        Ivysaur ivysaur1 = new Ivysaur();

        ivysaur1.takeStatus(bulbasaur1);

        assertEquals(10, ivysaur1.getterLevel());
        for(int i=0; i<6; i++){
            assertEquals(10, ivysaur1.getterIndividualValue(i));
            assertEquals(20, ivysaur1.getterEfortValue(i));
        }
    }
}
