/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.osms.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.core.prepare.LineOfBusinessSearchForm;
import com.itecheasy.core.prepare.LineOfBusinessService;
import com.itecheasy.core.prepare.LineOfBusinessVO;
import com.itecheasy.core.system.Shop;

import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 09:58
 * @Description:
 */
public class LineOfBusinessWebServiceImpl implements LineOfBusinessWebService {

    private LineOfBusinessService lineOfBusinessService;

    public void setLineOfBusinessService(LineOfBusinessService lineOfBusinessService) {
        this.lineOfBusinessService = lineOfBusinessService;
    }

    @Override
    public LineOfBusinessVO getLineOfBusinessById(Integer LineOfBusinessId, int operatorId) {
        return lineOfBusinessService.getLineOfBusinessById(LineOfBusinessId,operatorId);
    }

    @Override
    public List<Integer> getPowerByOperation(int operatorId) {
        return lineOfBusinessService.getPowerByOperation(operatorId);
    }

    @Override
    public PageList<LineOfBusinessVO> findLineOfBusinessPage(LineOfBusinessSearchForm lineOfBusinessSearchForm) {
       return lineOfBusinessService.findLineOfBusinessPage(lineOfBusinessSearchForm);
    }

    @Override
    public void addLineOfBusiness(LineOfBusinessVO lineOfBusinessVO, int operatorId) {
        lineOfBusinessService.addLineOfBusiness(lineOfBusinessVO,operatorId);
    }

    @Override
    public void updateLineOfBusiness(List<LineOfBusinessVO> lineOfBusinessVOS, int operatorId) {
        lineOfBusinessService.updateLineOfBusiness( lineOfBusinessVOS,  operatorId);
    }

    @Override
    public void cancelLineOfBusiness(Integer lineOfBusinessId, int operatorId) {
        lineOfBusinessService.cancelLineOfBusiness(lineOfBusinessId,  operatorId);
    }

    @Override
    public List<Shop> notBindLineOfBusinessShops() {
        return lineOfBusinessService.getNotBindLineOfBusinessShops();
    }

    @Override
    public LineOfBusinessVO getLineOfBusinessByLineId(Integer LineOfBusinessId, int operatorId) {
        return null;
    }
}
