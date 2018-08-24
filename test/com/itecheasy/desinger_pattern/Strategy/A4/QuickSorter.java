/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.desinger_pattern.Strategy.A4;

public class QuickSorter implements Sorter {
    Comparable[] data;
    public void sort(Comparable[] data) {
        this.data = data;
        qsort(0, data.length - 1);
    }
    private void qsort(int pre, int post) {
        int saved_pre = pre;
        int saved_post = post;
        Comparable mid = data[(pre + post) / 2];
        do {
            while (data[pre].compareTo(mid) < 0) {
                pre++;
            }
            while (mid.compareTo(data[post]) < 0) {
                post--;
            }
            if (pre <= post) {
                Comparable tmp = data[pre];
                data[pre] = data[post];
                data[post] = tmp;
                pre++;
                post--;
            }
        } while (pre <= post);
        if (saved_pre < post) {
            qsort(saved_pre, post);
        }
        if (pre < saved_post) {
            qsort(pre, saved_post);
        }
    }
}
