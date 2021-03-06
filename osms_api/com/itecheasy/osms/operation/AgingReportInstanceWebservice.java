/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.operation;

import com.itecheasy.common.PageList;
import com.itecheasy.core.operation.AmazonAgedReportForm;
import com.itecheasy.core.operation.AmazonAgedReportVO;
import com.itecheasy.core.system.Shop;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/10 17:33
 * @Description:
 */
@WebService
public interface AgingReportInstanceWebservice {


    public abstract List<Shop> getSyncAgedShop();

    /**
     * 分页查询
     * public PageList<FbaInboundPlanVO> getFbaInboundPlanList(int shopId, int page, int pageSize, String sku,String productCode,int operatorId) {
     *
     */
    public abstract PageList<AmazonAgedReportVO> showAmazonAgedReport(@WebParam(name = "amazonAgedReportForm")
                                                         AmazonAgedReportForm amazonAgedReportForm);


    /**
     * 加入清仓跟踪
     * @param skus
     * @param shopId
     * @return
     */
    public abstract void  addToClearTracking(@WebParam(name = "skus")List<String> skus,
                                             @WebParam(name = "shopId")int shopId,
                                             @WebParam(name = "operatorId")int operatorId);
}
