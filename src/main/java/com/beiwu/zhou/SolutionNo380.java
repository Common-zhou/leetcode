package com.beiwu.zhou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author zhoubing
 * @date 2021-05-12 14:37
 */
public class SolutionNo380 {

    static class RandomizedSet {
        // 使用一个HashMap来存储  key是值 value是index
        HashMap<Integer, Integer> map;

        // 使用一个list来存储值 这样可以随机获得值
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                // 已经存在 返回false
                return false;
            }

            map.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                // 不存在 返回false
                return false;
            }

            Integer index = map.get(val);
            Integer lastElement = list.get(list.size() - 1);

            list.set(index, lastElement);
            list.remove(list.size() - 1);
            // 需要更新lastElement的下标
            map.put(lastElement, index);

            map.remove(val);
            return true;

        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }


    public static void main(String[] args) {

        // 初始化一个空的集合。
        //RandomizedSet randomSet = new RandomizedSet();
        //System.out.println(randomSet.insert(0));
        //System.out.println(randomSet.insert(1));
        //System.out.println(randomSet.remove(0));
        //System.out.println(randomSet.insert(2));
        //System.out.println(randomSet.remove(1));
        //System.out.println(randomSet.getRandom());

        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(0));


    }
}
