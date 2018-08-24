package com.itecheasy.core.fba.AgedItemReportCalculateUtil;

import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportDao;
import com.itecheasy.core.fba.dao.AmazonInventoryAgedReportHistoryDao;
import com.itecheasy.core.po.AmazonInventoryAgedReportPO;

import java.util.List;

public abstract class CountAgedItemReportComponent {

    private AmazonInventoryAgedReportDao amazonInventoryAgedReportDao;

    private AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao;

    public AmazonInventoryAgedReportHistoryDao getAmazonInventoryAgedReportHistoryDao() {
        return amazonInventoryAgedReportHistoryDao;
    }

    public void setAmazonInventoryAgedReportHistoryDao(AmazonInventoryAgedReportHistoryDao amazonInventoryAgedReportHistoryDao) {
        this.amazonInventoryAgedReportHistoryDao = amazonInventoryAgedReportHistoryDao;
    }

    public AmazonInventoryAgedReportDao getAmazonInventoryAgedReportDao() {
        return amazonInventoryAgedReportDao;
    }

    public void setAmazonInventoryAgedReportDao(AmazonInventoryAgedReportDao amazonInventoryAgedReportDao) {
        this.amazonInventoryAgedReportDao = amazonInventoryAgedReportDao;
    }

    public abstract List<AmazonInventoryAgedReportPO> cost(List<AmazonInventoryAgedReportPO> item);

}
