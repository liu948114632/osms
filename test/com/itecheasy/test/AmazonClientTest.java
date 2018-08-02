package com.itecheasy.test;

import com.itecheasy.core.fba.FbaInboundService;
import com.itecheasy.webservice.client.AmazonClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import static org.junit.Assert.*;

public class AmazonClientTest<V> {


    public void init() {

    }

    private <T> Future<T> newFuture(final T response) {
        FutureTask<T> t = new FutureTask(new Callable<T>() {
            public T call() {
                return response;
            }
        });
        t.run();
        return t;
    }



    private <T> List<T> cashFutures(List<Future<T>> futures) {
        List<T> values = new ArrayList<T>();
        for (Future<T> future : futures) {
            try {
                values.add(future.get());
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }

        return values;
    }

//    public <F>,<E> F,E void genericMethod(Class<F> tClass)throws InstantiationException , IllegalAccessException{
//        F instance = tClass.newInstance();
////        return instance;
//    }


    private V key;

    public AmazonClientTest(V key) { //泛型构造方法形参key的类型也为V，V的类型由外部指定
//        this.key = key;
    }




    public  List<String>  getKey(List<String> param){

        return param;
    }
}