package cards;

import java.util.ArrayList;

public class Sort {

    //冒泡排序 从大到小排序
    public static ArrayList<Card> sort(ArrayList<Card> cards){
        for(int i=4;i>0;i--){
            for(int j=0;j<i;j++){
                if(smaller(cards.get(j),cards.get(j+1))){
                    exch(cards,j,j+1);
                }
            }
        }
        return cards;
    }

    //比较c1的number是否小于c2的number
    private static boolean smaller(Card c1,Card c2){
        int c1Int=c1.getNumber();
        int c2Int=c2.getNumber();
        if(c1Int<c2Int){
            return true;
        }else{
            return false;
        }
    }

    //交换位置
    private static void exch(ArrayList<Card> cards,int i,int j){
        Card card;
        card=cards.get(i);
        cards.set(i,cards.get(j));
        cards.set(j,card);
    }

}
