package com.beiwu.zhou.review2;

/**
 * @author zhoubing
 * @date 2021-04-20 23:44
 */
public class S860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;

        for (int bill : bills) {
            if (bill == 5) {
                // 如果是5元 可以直接收上
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    // 来了十元的 但是没有五元的 无法找开
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                int left = 15;
                if (ten != 0) {
                    ten--;
                    left -= 10;
                }
                while (left != 0) {
                    if (five == 0) {
                        return false;
                    }
                    left -= 5;
                    five--;
                }

            }
        }

        return true;
    }


}
