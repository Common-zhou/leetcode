package com.beiwu.zhou.review1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhoubing
 * @date 2021-05-17 17:44
 */
public class S1436 {
    public String destCity(List<List<String>> paths) {
        // 这个map用来存放： 可以从什么地方到达的另外地方
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }

        //for (Set<Map.Entry<String, String>>entrySet : map.entrySet()) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // 如果 start里有 但是结束里面却没有 它就代表
            String start = entry.getKey();
            String end = entry.getValue();
            if (map.containsKey(end)) {
                // 说明终点在map中是存在的
                continue;
            } else {
                return end;
            }

        }
        return "";

    }

}
