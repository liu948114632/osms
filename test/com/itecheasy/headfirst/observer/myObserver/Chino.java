package com.itecheasy.headfirst.observer.myObserver;

/**
 * @Auther: liteng
 * @Date: 2018/7/13 17:25
 * @Description:
 */
public class Chino implements Look,Show {
    private String whatThis;    //这个
    private String nextPri; //上一个
    private boolean hasNext;

    private Pricious pricious;


    public Chino(Pricious pricious){
        this.pricious = pricious;
        pricious.addObserver(this);
    }

    public void remove(Pricious pricious){
        pricious.removePerson(this);
    }


    @Override
    public void updateCondition(String whatThis, String nextPri, boolean hasNext) {
        this.nextPri = this.whatThis;
        this.whatThis =whatThis;
        this.hasNext = hasNext;
    }


    public String getWhatThis() {
        return whatThis;
    }

    public String getNextPri() {
        return nextPri;
    }
}
