package com.beiwu.zhou;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhoubing
 * @date 2021-05-11 16:20
 */
public class SolutionNo1436 {
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();

        for (List<String> path : paths) {
            // start  end
            map.put(path.get(0), path.get(1));
        }

        for (String value : map.values()) {
            // value 是终点  如果有终点不在map里作为一个key 那代表它就是终点
            if (!map.containsKey(value)){
                return value;
            }
        }
        // 没有找到 有环
        return null;

    }
}
