/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.core.prepare;

import com.itecheasy.common.PageList;
import com.itecheasy.common.util.BeanUtils;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.HqlUtils;
import com.itecheasy.core.po.LineOfBusinessPO;
import com.itecheasy.core.prepare.dao.LineOfBusinessDao;
import com.itecheasy.core.system.Shop;
import com.itecheasy.osms.system.SystemWebService;

import java.util.*;

/**
 * @Auther: liteng
 * @Date: 2018/8/24 10:00
 * @Description:
 */
public class LineOfBusinessServiceImpl implements LineOfBusinessService {

    private SystemWebService systemWebService;

    private LineOfBusinessDao lineOfBusinessDao;

    public static String generatorUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public void setSystemWebService(SystemWebService systemWebService) {
        this.systemWebService = systemWebService;
    }

    public void setLineOfBusinessDao(LineOfBusinessDao lineOfBusinessDao) {
        this.lineOfBusinessDao = lineOfBusinessDao;
    }

    @Override
    public LineOfBusinessVO getLineOfBusinessById(Integer LineOfBusinessId, int operatorId) {

//        String connectIds = HqlUtils.jointCriteriaInt(LineOfBusinessId);
//        List<LineOfBusinessPO> lineOfBusinessPOS = lineOfBusinessDao.findListByHql("from LineOfBusinessPO where id in ("+ connectIds +")");

        LineOfBusinessPO lineOfBusinessPO = lineOfBusinessDao.getObject(LineOfBusinessId);


        return BeanUtils.copyProperties(lineOfBusinessPO, LineOfBusinessVO.class);
    }

    //权限控制
    @Override
    public List<Integer> getPowerByOperation(int operatorId) {
        List<Shop> shopList = systemWebService.getShopsByUserId(operatorId);

        //all line of business
        List<LineOfBusinessPO> allLineOfBusinessPO = lineOfBusinessDao.getAll();

//        List<LineOfBusinessPO> listByHql = lineOfBusinessDao.findListByHql("from LineOfBusinessPO where lineOfBusinessName= ? ",
//                            new Object[]{});

        //key 业务线名称   val 业务线的店铺
        Map<String, List<Integer>> stringListHashMap = new HashMap<String, List<Integer>>();
        for (LineOfBusinessPO lineOfBusinessPO : allLineOfBusinessPO) {
            if (!stringListHashMap.containsKey(lineOfBusinessPO.getLineOfBusinessId())) {
                stringListHashMap.put(lineOfBusinessPO.getLineOfBusinessId(), new ArrayList<Integer>());
            }
            stringListHashMap.get(lineOfBusinessPO.getLineOfBusinessId()).add(lineOfBusinessPO.getBusinessBindShopId());
        }

        Set<String> userHasPermission = new HashSet<String>();
        for (Map.Entry<String, List<Integer>> stringListEntry : stringListHashMap.entrySet()) {
            for (Shop shop : shopList) {
                if (stringListEntry.getValue().contains(shop.getId())) {
                    boolean isAdd = userHasPermission.add(stringListEntry.getKey());
                }
            }
        }

        Set<LineOfBusinessPO> userHasLineOfBusinessPOS = new HashSet<LineOfBusinessPO>();
        for (LineOfBusinessPO lineOfBusinessPO : allLineOfBusinessPO) {
            for (String lineOfBusinessId : userHasPermission) {
                if (lineOfBusinessPO.getLineOfBusinessId().equals(lineOfBusinessId)) {
                    userHasLineOfBusinessPOS.add(lineOfBusinessPO);
                }
            }
        }

        List<Integer> userHasLineOfBusinessList = new ArrayList<Integer>();
        for (LineOfBusinessPO userHasLineOfBusinessPO : userHasLineOfBusinessPOS) {
            userHasLineOfBusinessList.add(userHasLineOfBusinessPO.getId());
        }

        return userHasLineOfBusinessList;
    }

    @Override
    public PageList<LineOfBusinessVO> findLineOfBusinessPage(LineOfBusinessSearchForm lineOfBusinessSearchForm) {

        //获取该用户所有的业务线id
        List<Integer> LineOfBusinessIdList = getPowerByOperation(lineOfBusinessSearchForm.getOperatorId());

        String hql = "";
        if (CollectionUtils.isNotEmpty(LineOfBusinessIdList)) {
            String connectIds = HqlUtils.jointCriteriaInt(LineOfBusinessIdList);
            hql = " FROM LineOfBusinessPO where id in ( " + connectIds + " ) ";

        } else {
            hql = " FROM LineOfBusinessPO ";
        }


        PageList<LineOfBusinessPO> pageListByHql = lineOfBusinessDao.findPageListByHql(lineOfBusinessSearchForm.getCurrentPage(),
                lineOfBusinessSearchForm.getPageSize(), hql);

//        List<LineOfBusinessVO> lineOfBusinessVOS = BeanUtils.copyList(pageListByHql.getData(), LineOfBusinessVO.class);



        //key lineId
        Map<String,List<LineOfBusinessPO>> stringListMap = new HashMap<String, List<LineOfBusinessPO>>();
        for (LineOfBusinessPO datum : pageListByHql.getData()) {
            if (!stringListMap.containsKey(datum.getLineOfBusinessId())){
                stringListMap.put(datum.getLineOfBusinessId(),new ArrayList<LineOfBusinessPO>());
            }
            stringListMap.get(datum.getLineOfBusinessId()).add(datum);
        }

        List<LineOfBusinessVO> resultVOS = new ArrayList<LineOfBusinessVO>();
        for (Map.Entry<String, List<LineOfBusinessPO>> stringListEntry : stringListMap.entrySet()) {
            LineOfBusinessVO lineOfBusinessVO = BeanUtils.copyProperties(stringListEntry.getValue().get(0), LineOfBusinessVO.class);

            List<Integer> shopIds = new ArrayList<Integer>();
            for (LineOfBusinessPO lineOfBusinessPO : stringListEntry.getValue()) {
                shopIds.add(lineOfBusinessPO.getBusinessBindShopId());
            }
            lineOfBusinessVO.setBusinessBindShopIdList(shopIds);
            resultVOS.add(lineOfBusinessVO);
        }

        PageList<LineOfBusinessVO> pageList = new PageList<LineOfBusinessVO>();
        pageList.setPage(pageListByHql.getPage());
        pageList.setData(resultVOS);

        return pageList;
    }

    @Override
    public void addLineOfBusiness(LineOfBusinessVO lineOfBusinessVO, int operatorId) {

        String uuid = generatorUUID();

        List<LineOfBusinessPO> lineOfBusinessPOS = new ArrayList<LineOfBusinessPO>();
        Date date = new Date();
        for (Integer shopId : lineOfBusinessVO.getBusinessBindShopIdList()) {
            LineOfBusinessPO lineOfBusinessPO = new LineOfBusinessPO();
            lineOfBusinessPO.setCreateTime(date);
            lineOfBusinessPO.setLastUpdateTime(date);

            lineOfBusinessPO.setLineOfBusinessName(lineOfBusinessVO.getLineOfBusinessName());
            lineOfBusinessPO.setLineOfBusinessExplain(lineOfBusinessVO.getLineOfBusinessExplain());
            lineOfBusinessPO.setLineOfBusinessStatus(lineOfBusinessVO.getLineOfBusinessStatus());
            lineOfBusinessPO.setNormalProductStockCycle(lineOfBusinessVO.getNormalProductStockCycle());
            lineOfBusinessPO.setSuperLongPrepareProductStockCycle(lineOfBusinessVO.getSuperLongPrepareProductStockCycle());
            lineOfBusinessPO.setLineOfBusinessId(uuid);

            lineOfBusinessPO.setBusinessBindShopId(shopId);

            lineOfBusinessPOS.add(lineOfBusinessPO);
        }

        lineOfBusinessDao.addObject(lineOfBusinessPOS);
    }


    /**
     * 更新一条业务线下的所有的信息
     *
     * @param lineOfBusinessVO
     * @param operatorId
     */
    public void updateLineOfBusinessSingle(LineOfBusinessVO lineOfBusinessVO, int operatorId) {

        List<LineOfBusinessPO> lineOfBusinessPOS = lineOfBusinessDao.findListByHql("from LineOfBusinessPO where lineOfBusinessId = ? ",
                new Object[]{lineOfBusinessVO.getLineOfBusinessId()});

        List<Integer> oldBusinessBindShopIdList = new ArrayList<Integer>();
        for (LineOfBusinessPO lineOfBusinessPO : lineOfBusinessPOS) {
            oldBusinessBindShopIdList.add(lineOfBusinessPO.getBusinessBindShopId());
        }

        List<Integer> newBusinessBindShopIdList = lineOfBusinessVO.getBusinessBindShopIdList();


        Set<Integer> set = new HashSet<Integer>(newBusinessBindShopIdList);
        set.retainAll(oldBusinessBindShopIdList);   //这里面全部都是共有的(交集)

        newBusinessBindShopIdList.removeAll(set);

        Date date = new Date();
        //原有的信息需要更新
        if (set.size() > 0) {
            for (Integer integer : set) {
                List<LineOfBusinessPO> hasExist = lineOfBusinessDao.findListByHql
                        ("from LineOfBusinessPO where lineOfBusinessId = ? and businessBindShopId =? ",
                                new Object[]{lineOfBusinessVO.getLineOfBusinessId(), integer});
                if (CollectionUtils.isNotEmpty(hasExist)) {

                    hasExist.get(0).setLastUpdateTime(date);
                    hasExist.get(0).setLineOfBusinessExplain(lineOfBusinessVO.getLineOfBusinessExplain());
                    hasExist.get(0).setLineOfBusinessName(lineOfBusinessVO.getLineOfBusinessName());
                    hasExist.get(0).setLineOfBusinessStatus(lineOfBusinessVO.getLineOfBusinessStatus());

                    lineOfBusinessDao.updateObject(hasExist);
                }

            }
        }else  if (set.size()==0){
            for (Integer old : oldBusinessBindShopIdList) {
                List<LineOfBusinessPO> hasExist = lineOfBusinessDao.findListByHql
                        ("from LineOfBusinessPO where lineOfBusinessId = ? and businessBindShopId =? ",
                                new Object[]{lineOfBusinessVO.getLineOfBusinessId(), old});
                if (CollectionUtils.isNotEmpty(hasExist)) {
                    hasExist.get(0).setLastUpdateTime(date);
                    hasExist.get(0).setLineOfBusinessExplain(lineOfBusinessVO.getLineOfBusinessExplain());
                    hasExist.get(0).setLineOfBusinessName(lineOfBusinessVO.getLineOfBusinessName());
                    hasExist.get(0).setLineOfBusinessStatus(lineOfBusinessVO.getLineOfBusinessStatus());
                    lineOfBusinessDao.updateObject(hasExist);
                }
            }
        }



        //这些是新绑定的shop
        if (CollectionUtils.isNotEmpty(newBusinessBindShopIdList)) {
            for (Integer integer : newBusinessBindShopIdList) {
                LineOfBusinessPO lineOfBusinessPO = BeanUtils.copyProperties(lineOfBusinessVO, LineOfBusinessPO.class);
                lineOfBusinessPO.setCreateTime(date);
                lineOfBusinessPO.setLastUpdateTime(date);

                lineOfBusinessPO.setBusinessBindShopId(integer);
                lineOfBusinessDao.addObject(lineOfBusinessPO);
            }
        }


    }


    public void updateLineOfBusinessSingleRTX(LineOfBusinessVO lineOfBusinessVO, int operatorId) {



    }


    public List<Shop> getNotBindLineOfBusinessShops() {

        List<LineOfBusinessPO> allLineOfBusiness = lineOfBusinessDao.getAll();

        List<Integer> shopIds = new ArrayList<Integer>();
        for (LineOfBusinessPO lineOfBusiness : allLineOfBusiness) {
            shopIds.add(lineOfBusiness.getBusinessBindShopId());
        }


        List<Shop> shops = systemWebService.getShops();

        for (Iterator<Shop> it = shops.iterator(); it.hasNext(); ) {
            Shop sp = it.next();
            if (shopIds.contains(sp.getId())) {
                it.remove();
            }
        }


        return shops;
    }

    /**
     * 批量操作
     *
     * @param lineOfBusinessVOS
     * @param operatorId
     */
    @Override
    public void updateLineOfBusiness(List<LineOfBusinessVO> lineOfBusinessVOS, int operatorId) {

        for (LineOfBusinessVO lineOfBusinessVO : lineOfBusinessVOS) {
            updateLineOfBusinessSingle(lineOfBusinessVO, operatorId);
        }


//        List<LineOfBusinessPO> dataBaseLineOfBusinessPOS = new ArrayList<LineOfBusinessPO>();
//        for (LineOfBusinessVO lineOfBusinessVO : lineOfBusinessVOS) {
//            LineOfBusinessPO dataBasePO = lineOfBusinessDao.getObject(lineOfBusinessVO.getId());
//            dataBaseLineOfBusinessPOS.add(dataBasePO);
//        }
//
//        if (CollectionUtils.isNotEmpty(dataBaseLineOfBusinessPOS)) {
//            Date date = new Date();
//
//            //dataBase查出来的其实是一个
//            for (LineOfBusinessVO lineOfBusinessVO : lineOfBusinessVOS) {
//                for (LineOfBusinessPO dataBaseLineOfBusinessPO : dataBaseLineOfBusinessPOS) {
//                    if (dataBaseLineOfBusinessPO.getLineOfBusinessName().trim().equals(lineOfBusinessVO.getLineOfBusinessName().trim())) {
//                        lineOfBusinessVO.setLastUpdateTime(date);
//
//                        dataBaseLineOfBusinessPO.setSuperLongPrepareProductStockCycle(lineOfBusinessVO.getSuperLongPrepareProductStockCycle());
//                        dataBaseLineOfBusinessPO.setNormalProductStockCycle(lineOfBusinessVO.getNormalProductStockCycle());
//
//                        dataBaseLineOfBusinessPO.setLineOfBusinessStatus(lineOfBusinessVO.getLineOfBusinessStatus());
//                        dataBaseLineOfBusinessPO.setLineOfBusinessExplain(lineOfBusinessVO.getLineOfBusinessExplain());
//                        dataBaseLineOfBusinessPO.setLineOfBusinessName(lineOfBusinessVO.getLineOfBusinessName());
//
//                        Integer integer = lineOfBusinessVO.getBusinessBindShopIdList().get(0);
//                        dataBaseLineOfBusinessPO.setBusinessBindShopId(integer);
//                    }
//                }
//            }
//
//            List<LineOfBusinessPO> lineOfBusinessPOS = BeanUtils.copyList(lineOfBusinessVOS, LineOfBusinessPO.class);
//            lineOfBusinessDao.updateObject(lineOfBusinessPOS);
//        }

    }

    @Override
    public void cancelLineOfBusiness(Integer lineOfBusinessId, int operatorId) {

        List<LineOfBusinessPO> lineOfBusinessPOS = lineOfBusinessDao.findListByHql("from LineOfBusinessPO where lineOfBusinessId = ? ",
                new Object[]{lineOfBusinessId});
        for (LineOfBusinessPO lineOfBusinessPO : lineOfBusinessPOS) {
            lineOfBusinessPO.setLineOfBusinessStatus(2);
        }
        lineOfBusinessDao.updateObject(lineOfBusinessPOS);
        lineOfBusinessDao.flush();
    }
}
