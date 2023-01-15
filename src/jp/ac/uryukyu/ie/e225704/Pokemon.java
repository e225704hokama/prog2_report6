package jp.ac.uryukyu.ie.e225704;

import java.util.Random;

public abstract class Pokemon {
    String name;
    int[] raceValue = new int[6];
    int[] individualValue = new int[6];
    int[] efortValue = new int[6];
    int level;
    final int maxLevel = 100;
    int evolutionLevel;
    int[] status = new int[6];

    public void battle(){
        int encount = new Random().nextInt(6);
        if(this.level<maxLevel){
            this.level += 1;

            if(this.efortValue[encount]<252){
                this.efortValue[encount] += new Random().nextInt(8);
            }
            switch (encount){
                case 0 :
                System.out.println("キャタピーを倒した。レベルが１あがった！");
                break;
                case 1 :
                System.out.println("ワンリキーを倒した。レベルが１あがった！");
                break;
                case 2 :
                System.out.println("イシツブテを倒した。レベルが１あがった！");
                break;
                case 3 :
                System.out.println("ゴースを倒した。レベルが１あがった！");
                break;
                case 4 :
                System.out.println("メノクラゲを倒した。レベルが１あがった！");
                break;
                case 5 :
                System.out.println("コイキングを倒した。レベルが１あがった！");
                break;
            }
        }
        else{
            System.out.println("もう戦ってくれる相手がいないようだ。");
        }
        
    }

    public abstract void evolution();

    public void summary(){
        System.out.println(this.name + "　　Lv." + this.level);
        System.out.println("つよさ");
        

        int statuss;
        for(int i=0; i<6; i+=1){
            statuss = this.raceValue[i];
            System.out.println(statuss);
        }
        
    }
}
