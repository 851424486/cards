package cards;

import java.util.ArrayList;

public class Compare {
    public static void compare(Cards blackCards,Cards whiteCards){
        ArrayList<Card> black=blackCards.getCards();
        ArrayList<Card> white=whiteCards.getCards();

        if(blackCards.getLevel()>whiteCards.getLevel()){
            //黑方比白方的牌等级高
            System.out.println("黑方获胜---黑方的牌型等级更高");
        }
        else if(blackCards.getLevel()<whiteCards.getLevel()){
            ////黑方比白方的牌等级低
            System.out.println("白方获胜---白方的牌型等级更高");
        }
        //黑方和白方的牌等级相等,先判断双方的牌的number是否一样
        else if(tie(black,white)){
            System.out.println("平局");
        }
        //黑方和白方的牌等级相等,并且双方的牌的number不完全一样
        else if(blackCards.getLevel()==whiteCards.getLevel()){
            //都是散牌
            if(blackCards.getLevel()==0){
                if(sanPaiComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是散牌");
                }else{
                    System.out.println("白方获胜---双方的牌型都是散牌");
                }
            }
            //都是对子
            else if(blackCards.getLevel()==1){
                if(duiZiComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是对子");
                }else{
                    System.out.println("白方获胜---双方的牌型都是对子");
                }
            }
            //都是两对
            else if(blackCards.getLevel()==2){
                if(liangDuiComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是两对");
                }else{
                    System.out.println("白方获胜---双方的牌型都是两对");
                }
            }
            //都是三条
            else if(blackCards.getLevel()==3){
                if(sanTiaoComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是三条");
                }else{
                    System.out.println("白方获胜---双方的牌型都是三条");
                }
            }
            //都是顺子
            else if(blackCards.getLevel()==4){
                if(shunZiComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是顺子");
                }else{
                    System.out.println("白方获胜---双方的牌型都是顺子");
                }
            }
            //都是四条
            else if(blackCards.getLevel()==5){
                if(siTiaoComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是四条");
                }else{
                    System.out.println("白方获胜---双方的牌型都是四条");
                }
            }
            //都是同花
            else if(blackCards.getLevel()==6){
                if(tongHuaComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是同花");
                }else{
                    System.out.println("白方获胜---双方的牌型都是同花");
                }
            }
            //都是同花顺
            else if(blackCards.getLevel()==7){
                if(tongHuaShunComp(black,white)){
                    System.out.println("黑方获胜---双方的牌型都是同花顺");
                }else{
                    System.out.println("白方获胜---双方的牌型都是同花顺");
                }
            }
        }
    }

    private static boolean tie(ArrayList<Card> black,ArrayList<Card> white){
        for(int i=0;i<5;i++){
            if(black.get(i).getNumber()!=white.get(i).getNumber()){
                return false;
            }
        }
        return true;
    }

    private static boolean sanPaiComp(ArrayList<Card> black,ArrayList<Card> white){
        boolean flag=true;
        for(int i=0;i<5;i++){
            if(black.get(i).getNumber()<white.get(i).getNumber()){
                //白方的牌大
                return false;
            }
        }
        return true;
    }

    private static boolean duiZiComp(ArrayList<Card> black,ArrayList<Card> white){
        //记录对子在ArrayList里的索引
        int duiZiBlack=0;
        int duiZiWhite=0;
        //找到对子在ArrayList里的索引
        for(int i=0;i<4;i++){
            if(black.get(i).getNumber()==black.get(i+1).getNumber()){
                duiZiBlack=i;
            }
        }
        for(int i=0;i<4;i++){
            if(white.get(i).getNumber()==white.get(i+1).getNumber()){
                duiZiWhite=i;
            }
        }
        //判断双方的对子的大小
        //black的对子大
        if(black.get(duiZiBlack).getNumber()>white.get(duiZiWhite).getNumber()){
            return true;
        }
        //white的对子大
        else if(black.get(duiZiBlack).getNumber()<white.get(duiZiWhite).getNumber()){
            return false;
        }
        //双方的对子大小相等
        else{
            //先把ArrayList里的对子移除，还剩下3个
            black.remove(duiZiBlack);
            black.remove(duiZiBlack);
            white.remove(duiZiWhite);
            white.remove(duiZiWhite);
            for(int i=0;i<3;i++){
                if(black.get(i).getNumber()>white.get(i).getNumber()){
                    return true;
                }else if(black.get(i).getNumber()<white.get(i).getNumber()){
                    return false;
                }
            }
        }
        return false;
    }

    private static boolean liangDuiComp(ArrayList<Card> black,ArrayList<Card> white){
        //记录对子在ArrayList里的索引
        ArrayList<Integer> liangDuiBlack=new ArrayList<>();
        ArrayList<Integer> liangDuiWhite=new ArrayList<>();
        //找到对子在ArrayList里的索引
        for(int i=0;i<4;i++){
            if(black.get(i).getNumber()==black.get(i+1).getNumber()){
                liangDuiBlack.add(i);
            }
        }
        for(int i=0;i<4;i++){
            if(white.get(i).getNumber()==white.get(i+1).getNumber()){
                liangDuiWhite.add(i);
            }
        }
        //判断双方的对子的大小
        //black的较大的对子大
        if(black.get(liangDuiBlack.get(0)).getNumber()>white.get(liangDuiWhite.get(0)).getNumber()){
            return true;

        }
        //white的较大的对子大
        else if(black.get(liangDuiBlack.get(0)).getNumber()<white.get(liangDuiWhite.get(0)).getNumber()){
            return false;
        }
        //双方的较大的对子大小相等
        else {
            //比较较小的对子
            //black的较小的对子大
            if (black.get(liangDuiBlack.get(1)).getNumber() > white.get(liangDuiWhite.get(1)).getNumber()) {
                return true;
            }
            //white的较小的对子大
            else if (black.get(liangDuiBlack.get(1)).getNumber() < white.get(liangDuiWhite.get(1)).getNumber()) {
                return false;
            }
            //双方的较小的对子大小相等
            else {
                //black里单独的那个数的索引
                int blackIndex = 10 - liangDuiBlack.get(0) * 2 - 2 - liangDuiBlack.get(1) * 2;
                //white里单独的那个数的索引
                int whiteIndex = 10 - liangDuiWhite.get(0) * 2 - 2 - liangDuiWhite.get(1) * 2;
                //比较单独的那张牌的大小
                if (black.get(blackIndex).getNumber() > white.get(whiteIndex).getNumber()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    private static boolean sanTiaoComp(ArrayList<Card> black,ArrayList<Card> white){
        int valueBlack=0;
        int valueWhite=0;
        for(int i=0;i<3;i++){
            if(black.get(i).getNumber()==black.get(i+1).getNumber() &&
                    black.get(i+1).getNumber()==black.get(i+2).getNumber()){
                valueBlack=black.get(i).getNumber();
            }
        }
        for(int i=0;i<3;i++){
            if(white.get(i).getNumber()==white.get(i+1).getNumber() &&
                    white.get(i+1).getNumber()==white.get(i+2).getNumber()){
                valueWhite=white.get(i).getNumber();
            }
        }
        if(valueBlack>valueWhite){
            return true;
        }else{
            return false;
        }
    }

    private static boolean shunZiComp(ArrayList<Card> black,ArrayList<Card> white){
        if(black.get(0).getNumber()>white.get(0).getNumber()){
            return true;
        }else{
            return false;
        }
    }

    private static boolean siTiaoComp(ArrayList<Card> black,ArrayList<Card> white){
        int valueBlack=0;
        int valueWhite=0;
        for(int i=0;i<4;i++){
            if(black.get(i).getNumber()==black.get(i+1).getNumber()){
                valueBlack=black.get(i).getNumber();
            }
        }
        for(int i=0;i<4;i++){
            if(white.get(i).getNumber()==white.get(i+1).getNumber()){
                valueWhite=white.get(i).getNumber();
            }
        }
        if(valueBlack>valueWhite){
            return true;
        }else{
            return false;
        }
    }

    private static boolean tongHuaComp(ArrayList<Card> black,ArrayList<Card> white){
        return sanPaiComp(black,white);
    }

    private static boolean tongHuaShunComp(ArrayList<Card> black,ArrayList<Card> white){
        return shunZiComp(black,white);
    }


}
