package jp.ac.uryukyu.ie.e225704;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EventMakerTest {
    @Test void battleTest(){
        EventMaker eventMaker1 = new EventMaker();
        Bulbasaur bulbasaur1 = new Bulbasaur();
        int thisLevel = bulbasaur1.getterLevel();

        eventMaker1.battle(bulbasaur1);

        assertEquals(thisLevel + 1, bulbasaur1.getterLevel());
    }
}
