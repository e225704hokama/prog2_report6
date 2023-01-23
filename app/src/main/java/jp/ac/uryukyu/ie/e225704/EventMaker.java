package jp.ac.uryukyu.ie.e225704;
import java.util.Random;
import java.util.Scanner;

public class EventMaker {
    private String[] enemys = {"キャタピー", "ワンリキー", "イシツブテ", "ゴース", "メノクラゲ", "コイキング"};
    
    /**
     * ポケモンのレベルを上げ、努力値をランダムに上げるメソッド
     * @param pokemon　レベル、努力値を上げるポケモンのインスタンス
     */
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

    /**
     * ランダムでイベントを発生させるメソッド
     * @param trainer　イベントを体験するトレーナーのインスタンス。一部イベントメソッドを呼び出すために必要
     * @param pokemon　イベントを体験するポケモンのインスタンス
     */
    protected void randomEvent(Trainer trainer, Pokemon pokemon){
        int eventIndex = new Random().nextInt(500);
        
        if(eventIndex >= 0 && eventIndex <= 9 && pokemon.getterEventCounter(0)){ //2％イベント
            System.out.println("ランダムイベント　〜 オツキミやま 〜");
            System.out.println("\n\n\n\nオツキミやまでおどるピッピたちを見つけた！\n" + pokemon.getterName() + "と一緒に岩陰からこっそり観察した。\n\n二人は望月の思い出💚を共有した！\n");
            pokemon.setterPrecious("💚");
            pokemon.setterEventCounter(0);
        }
        if(eventIndex >= 10 && eventIndex <= 14 && pokemon.getterEventCounter(1)){ //1％イベント
            System.out.println("ランダムイベント　〜 サントアンヌ号 〜");
            System.out.println("\n\n\n\n幸運にもサントアンヌ号のクルーズ乗船券が当選した！\n" + pokemon.getterName() + "は大海原に圧倒されたいた。\n\n二人は潮風の思い出💙を共有した！\n");
            pokemon.setterPrecious("💙");
            pokemon.setterEventCounter(1);
        }
        if(eventIndex == 15 && pokemon.getterEventCounter(2)){ //0.2％イベント
            System.out.println("ランダムイベント　〜 ジムリーダー 〜");
            System.out.println("\n\n\n\nたまたま訪れた街でジムリーダーのカツラさんに出会った！\n" + pokemon.getterName() + "を見せると良く育てらてると褒めてもらえた。\n\n二人は燦燦の思い出🧡を共有した！\n");
            pokemon.setterPrecious("🧡");
            pokemon.setterEventCounter(2);
        }
        if(eventIndex == 16 && pokemon.getterEventCounter(3)){ //0.2%イベント。捕獲率は1/3なので、ミュウの捕獲確率は0.07%
            System.out.println("ランダムレアイベント　〜 まぼろしのポケモン 〜");
            System.out.println("\n\n\n？！？！野生のミュウが現れた！！！\n\n\n\n\n\n\n\n");
            this.mewEvent(trainer, pokemon);
            
            
        }
        
    }

    /**
     * ミュウ捕獲イベントを実行するメソッド
     * @param trainer　イベントを体験するトレーナーのインスタンス。捕獲時にtrainerのpartyにミュウを追加する
     * @param pokemon　イベントを体験するポケモンのインスタンス
     */
    protected void mewEvent(Trainer trainer, Pokemon pokemon){
        boolean con = true;
        Scanner scanner = new Scanner(System.in);

        while(con){
            System.out.println("どうする？　たたかう＝b、つかまえる＝c");
            String select = scanner.next();

            switch(select){
                case "b" :
                System.out.println("\nいけ！" + pokemon.getterName() + "．．．と思ったら、ミュウはこちらに気づき逃げてしまった。\n二人は夢幻のような思い出🤍を共有した\n");
                pokemon.setterPrecious("🤍");
                pokemon.setterEventCounter(3);
                break;

                case "c" :
                int chatchIndex = new Random().nextInt(9);
                
                if(trainer.getterParty().size() < 5){
                    System.out.println("いけ！　モンスターボール！");
                    
                    if(chatchIndex < 3){
                        System.out.println("グル．．．\nホゲ！　　ボールから出てしまった。ミュウは逃げ出した。\n");
                        break;
                    }
                    if(chatchIndex >= 3 && chatchIndex <= 5){
                        System.out.println("グル．．．\nグル．．．\nホゲ！　　ボールから出てしまった。ミュウは逃げ出した。\n");
                        break;
                    }
                    if(chatchIndex > 5){
                        System.out.println("グル．．．\nグル．．．\nグル．．．\nカチッ！　　やった！ミュウをつかまえた！\n二人は白熱の思い出🤍を共有した！\n");
                        pokemon.setterPrecious("🤍");
                        pokemon.setterEventCounter(3);
                        trainer.setterParty(new Mew());
                        break;
                    }
                }
                else{
                    System.out.println("これ以上は育てるのは身がもたない．．．\n");
                    continue;
                }
                default :
                continue;
            }
            con = false;
        }
    }
}
