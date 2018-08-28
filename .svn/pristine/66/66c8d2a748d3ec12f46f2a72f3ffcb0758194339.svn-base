/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.operation;

import com.itecheasy.common.PageList;
import com.itecheasy.core.system.Shop;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/11 16:46
 * @Description:
 */
public interface ShowAmazonAgedReportService {

     /**
      * 需要同步亚马逊库龄报告的店铺
      * @return
      */
     public abstract List<Shop> getSyncAgedShop() ;


     /**
      * 亚马逊库龄报告
      * @param amazonAgedReportForm
      * @return
      */
     public abstract PageList<AmazonAgedReportVO> getAmazonAgedReport(AmazonAgedReportForm amazonAgedReportForm) ;

     /**
      * 通过店铺id和sku查出对应的库龄报告
      * 
      * @param sku
      * @param shopId
      * @return
      */
     public abstract AmazonAgedReportVO  getAmazonAgedReport(String sku,int shopId);


     /**
      * 加入清仓跟踪
      * @param sku
      * @param shopId
      * @return
      */
     public abstract void  addToClearTracking(List<String> sku,int shopId,int operatorId);


}
