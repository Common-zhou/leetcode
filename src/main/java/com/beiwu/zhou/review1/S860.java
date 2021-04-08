package com.beiwu.zhou.review1;

/**
 * @author zhoubing
 * @date 2021-04-08 10:19
 */
public class S860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                //收费5元
                five++;
            } else if (bills[i] == 10) {
                // 如果收费十元  检查有没有五元
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    // 找不开
                    return false;
                }
            } else if (bills[i] == 20) {
                int left = 15;
                if (ten > 0) {
                    left -= 10;
                    ten--;
                }
                while (left > 0) {
                    if (five > 0) {
                        five--;
                        left -= 5;
                    }else{
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
