package com.beiwu.zhou.review1;

import java.util.*;

/**
 * @author zhoubing
 * @date 2021-05-18 09:48
 */
public class S380 {

    static class RandomizedSet {
        // list用来存储值 map用来存储值-> Index
        private List<Integer> list;

        private Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                // 如果里面包含
                return false;
            }

            int lastIndex = list.size();
            list.add(lastIndex, val);
            map.put(val, lastIndex);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                // 如果不包含
                return false;
            }

            // 首先拿到那个需要删除位置的 index
            Integer index = map.get(val);
            int lastIndex = list.size() - 1;
            Integer lastElement = list.get(lastIndex);

            list.set(index, lastElement);

            map.put(lastElement, index);
            list.remove(lastIndex);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            Random random = new Random();
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

    public static void main(String[] args) {
        //test1();
        test2();
        //
        //test3();

    }

    private static void test3() {
        //["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
//[[],[0],[0],[0],[],[0],[0]]
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));

    }

    private static void test2() {
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.getRandom());


    }

    private static void test1() {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
    }

}
