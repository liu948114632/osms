/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: liteng
 * @Date: 2018/8/3 16:32
 * @Description:
 */
public class MapUtils<F> {
    private List<F> existOrderItem;
    private List<F> notExistOrderItem;

    public  List<F> getExistOrderItem() {
        return existOrderItem;
    }

    public void setExistOrderItem(List<F> existOrderItem) {
        this.existOrderItem = existOrderItem;
    }

    public List<F> getNotExistOrderItem() {
        return notExistOrderItem;
    }

    public void setNotExistOrderItem(List<F> notExistOrderItem) {
        this.notExistOrderItem = notExistOrderItem;
    }

    public static <V,S> MapUtils<V> collectionCompareCollection(Map<S, V> tempMap, List<S> stringList) {
        List<V> existOrderItem = new ArrayList<V>();
        List<V> notExistOrderItem = new ArrayList<V>();
        //根据sku来比较或者cmsCode来比较
        for (Map.Entry<S, V> newItem : tempMap.entrySet()) {
            if (stringList.contains(newItem.getKey())) {
                existOrderItem.add(newItem.getValue());
            } else {
                notExistOrderItem.add(newItem.getValue());
            }
        }
        MapUtils<V> compareMapC = new MapUtils<V>();
        compareMapC.setExistOrderItem(existOrderItem);
        compareMapC.setNotExistOrderItem(notExistOrderItem);
        return compareMapC;
    }

}
