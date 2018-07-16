package com.itecheasy.headfirst.observer.myObserver;

/**
 * @Auther: liteng
 * @Date: 2018/7/13 17:24
 * @Description:
 */
public interface Pricious {

    void addObserver(Look look);

    void notifyPersonAll();

    void removePersonAll();

    void removePerson(Look person);
//     void setNewPricious(String whatThis,String nextPri,boolean hasNext);
}
