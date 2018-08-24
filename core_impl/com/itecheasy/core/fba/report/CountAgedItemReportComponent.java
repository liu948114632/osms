/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.fba.report;

import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.text.ParseException;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/7/2 14:05
 * @Description:
 */
public interface CountAgedItemReportComponent {

    public abstract List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> item) throws ParseException;

}
