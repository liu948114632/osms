package com.itecheasy.headfirst.observer.myObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/13 17:24
 * @Description:
 */
public class PriciousData implements Pricious {

    //大家关注的信息
    private String whatThis;
    private String nextPri;
    private boolean hasNext;

    //观察者的集合
    private List<Look> personList = new ArrayList<Look>();

    //这个却是给observer调用的
    @Override
    public void addObserver(Look look) {
        if (look != null) {
            this.personList.add(look);
        }
    }



    @Override
    public void removePerson(Look person) {
        int indexOf = this.personList.indexOf(person);
        if (indexOf>0) {
            this.personList.remove(indexOf);
        }

    }

    @Override
    public void removePersonAll() {
        this.personList.clear();
    }

    //只改变全局变量
    public void setNewPricious(String whatThis,String nextPri,boolean hasNext){
        this.whatThis = whatThis;
        this.hasNext = hasNext;
        this.nextPri = nextPri;
        notifyPersonAll();
    }

    //只是通知观察者们，负责遍历
    @Override
    public void notifyPersonAll() {
        for (Look person : personList) {
            person.updateCondition( whatThis, nextPri, hasNext);
        }
    }

    //只通知某一个观察者的方法

}
