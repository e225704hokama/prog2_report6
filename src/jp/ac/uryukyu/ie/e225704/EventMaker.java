package jp.ac.uryukyu.ie.e225704;
import java.util.Random;

public class EventMaker {
    private String[] enemys = {"キャタピー", "ワンリキー", "イシツブテ", "ゴース", "メノクラゲ", "コイキング"};
    

    protected void battle(Pokemon pokemon){ //レベル上げ、努力値振りをするメソッド
        int encount = new Random().nextInt(6);
        if(pokemon.getterLevel()<pokemon.maxLevel){
            pokemon.setterLevel(1);

            if(pokemon.getterEfortValue(encount)<252){
                pokemon.setterEfortValue(encount, new Random().nextInt(8));
            }
            System.out.println(enemys[encount] + "を倒した。レベルが" + pokemon.getterLevel() + "になった！\n");

            if(pokemon.getterLevel() == 100 && pokemon.getterMedal()){ //レベルが最大になった証
                pokemon.setterPrecious("🎖");
                pokemon.setterMedal();
            }
            
        }
        else{
            System.out.println("もう戦ってくれる相手がいないようだ。\n");
        }
        
    }

    protected void randomEvent(Pokemon pokemon){
    }

    
}
