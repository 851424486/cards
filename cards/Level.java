package cards;

import java.util.ArrayList;

public class Level {
    //牌的等级
    //同花顺＞同花＞四条>顺子＞三条＞两对＞对子＞散牌
    //0: 散牌   1：对子  2：两对  3：三条  4: 顺子 5:四条 6: 同花  7: 同花顺
    public static int levelDefine(ArrayList<Card> cards){
        int level=0;
        if(duiZi(cards)){
            level=1;
        }
        if(liangDui(cards)){
            level=2;
        }
        if(sanTiao(cards)){
            level=3;
        }
        if(shunZi(cards)){
            level=4;
        }
        if(siTiao(cards)){
            level=5;
        }
        if(tongHua(cards)){
            level=6;
        }
        if(tongHuaShun(cards)){
            level=7;
        }
        return level;
    }

    //同花：如果是同花返回true，不是返回false
    private static boolean tongHua(ArrayList<Card> cards){
        Boolean flag=true;
        for(int i=0;i<4;i++){
            if(cards.get(i).getSuit()!=cards.get(i+1).getSuit()){
                //不是同花
                return false;
            }
        }
        //是同花
        return true;
    }

    //顺子：
    private static boolean shunZi(ArrayList<Card> cards){
        for(int i=0;i<4;i++){
            if((cards.get(i).getNumber()-cards.get(i+1).getNumber())!=1){
                //不是顺子
                return false;
            }
        }
        //是顺子
        return true;
    }

    //同花顺：
    private static boolean tongHuaShun(ArrayList<Card> cards){
        if(tongHua(cards)&&shunZi(cards)){
            //是同花顺
            return true;
        }else{
            //不是同花顺
            return false;
        }
    }

    //四条
    private static boolean siTiao(ArrayList<Card> cards){
        for(int i=0;i<2;i++){
            if(cards.get(i).getNumber()==cards.get(i+1).getNumber() &&
                    cards.get(i+1).getNumber()== cards.get(i+2).getNumber() &&
                    cards.get(i+2).getNumber()== cards.get(i+3).getNumber() ){
                return true;
            }
        }
        return false;
    }

    //三条
    private static boolean sanTiao(ArrayList<Card> cards){
        for(int i=0;i<3;i++){
            if(cards.get(i).getNumber()==cards.get(i+1).getNumber() &&
                    cards.get(i+1).getNumber()== cards.get(i+2).getNumber()){
                //是三条
                return true;
            }
        }
        //不是三条
        return false;
    }

    //两对
    private static boolean liangDui(ArrayList<Card> cards){
        int num=0;
        for(int i=0;i<4;i++){
            if(cards.get(i).getNumber()==cards.get(i+1).getNumber()){
                num++;
            }
        }
        if(num==2){
            //是两对
            return true;
        }else{
            //不是两对
            return false;
        }
    }

    //对子
    private static boolean duiZi(ArrayList<Card> cards){
        for(int i=0;i<4;i++){
            if(cards.get(i).getNumber()==cards.get(i+1).getNumber()){
                //是对子
                return true;
            }
        }
        //不是对子
        return false;
    }


}
