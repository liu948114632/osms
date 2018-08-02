package com.itecheasy.test;

import com.itecheasy.common.PageList;
import com.itecheasy.core.fba.*;
import com.itecheasy.core.fba.dao.ReplenishmentOrderDao;
import com.itecheasy.core.order.*;
import com.itecheasy.core.order.dao.OrderAddressAmazonDao;
import com.itecheasy.core.order.dao.OrderAmazonDao;
import com.itecheasy.core.order.dao.OrderProductAmazomDao;
import com.itecheasy.core.order.dao.OrderTrackingProductDao;
import com.itecheasy.core.product.ShopProductService;
import com.itecheasy.core.task.AmozonUpdateReplenishmentShipment;
import com.itecheasy.core.task.AmozonUpdateReplenishmentShipmentImpl;
import com.itecheasy.webservice.amazon.InboundShipmentInfoVO;
import com.itecheasy.webservice.amazon.ListInboundShipmentsResultVO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import java.util.ArrayList;
import java.util.List;

public class SprintTest extends AbstractDependencyInjectionSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "classpath*:applicationContext.xml"  };
	}





//	//1.2
//	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ReplenishmentTaskService replenishmentTaskService = (ReplenishmentTaskService) context.getBean("replenishmentTaskService");
//
//		//new commit   需求1.2test
//		//1019   opretor
//		List<ReplenishmentTaskProduct> replenishmentTaskProducts = new ArrayList<ReplenishmentTaskProduct>();
//		ReplenishmentTaskProduct taskProduct = new ReplenishmentTaskProduct();
//		taskProduct.setCmsProductId(202);
//		taskProduct.setCmsProductCode("DZ004");
//		taskProduct.setReplenishmentNum(24);
//		taskProduct.setStatus(1);
//		taskProduct.setType(1);
//		replenishmentTaskProducts.add(taskProduct);
////		int operator, String taskRemark
//		replenishmentTaskService.createReplenishmentTasksFromFba(replenishmentTaskProducts,1019,"FA180611239006");
//
//
//	}
//
//
//	//1.4
//	@Test
//	public  void test003(){
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		OrderTrackingService orderTrackingService = (OrderTrackingService)context.getBean("orderTrackingService");
//
//		SearchOrderTrackingForm form = new SearchOrderTrackingForm();
//		form.setCurrentPage(1);
//		form.setPageSize(50);
////		form.setCmsProductCode("dz005");
//        form.setCmsProductCode("");
//		PageList<OrderTracking> pageList = orderTrackingService.findOrderTracking(form);
//
//        System.out.println(pageList);
//
//	}
//
//
//	//订单跟踪，cms答复的消息，osms读不到（nullpoint）
	@Test
	public  void test004(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderTrackingMessageService orderTrackingMessageService = (OrderTrackingMessageService)context.getBean("orderTrackingMessageService");

		orderTrackingMessageService.processingOrderTracking();
	}



	public  void test005(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReplenishmentOrderService replenishmentOrderService = (ReplenishmentOrderService)context.getBean("replenishmentOrderService");

		Integer orederId = 2053;
		System.out.println(replenishmentOrderService.getFbaReplenishmentPlanByOrderId(orederId));
	}

	@Test
	public  void test007(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FbaInboundService fbaInboundService = (FbaInboundService)context.getBean("fbaInboundService");

		List<FbaPreInboundItemVO> items = new ArrayList<FbaPreInboundItemVO>();
		FbaPreInboundItemVO fbaPreInboundItemVO = new FbaPreInboundItemVO();
		fbaPreInboundItemVO.setPrimaryPictureCode("");
		fbaPreInboundItemVO.setCmsProductCode("DZ004");
		fbaPreInboundItemVO.setOrderedQuantity(10);
		fbaPreInboundItemVO.setUnitQuantity(5);
		fbaPreInboundItemVO.setSku("LIU-00004");
		fbaPreInboundItemVO.setUnit("");
		items.add(fbaPreInboundItemVO);

		fbaInboundService.updateFbaInboundOrder("id002",1,items,33);

		SWTest swTest = new SWTest();


	}

	@Test
	public  void test008(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AmozonUpdateReplenishmentShipment amozonUpdateReplenishmentShipment = (AmozonUpdateReplenishmentShipment)context.getBean("amozonUpdateReplenishmentShipment");


		ListInboundShipmentsResultVO resultVO = new ListInboundShipmentsResultVO();
		List<InboundShipmentInfoVO> infoVOS = new ArrayList<InboundShipmentInfoVO>();
		InboundShipmentInfoVO vo = new InboundShipmentInfoVO();
		vo.setShipmentStatus("RECEIVING");
		InboundShipmentInfoVO vo2 = new InboundShipmentInfoVO();
		vo.setShipmentStatus("CLOSED");
		infoVOS.add(vo);
		infoVOS.add(vo2);

		resultVO.setInboundShipmentInfoVOList(infoVOS);


		boolean b = amozonUpdateReplenishmentShipment instanceof AmozonUpdateReplenishmentShipmentImpl;
		System.out.println(b ? "ok":"no cast");


//		AmozonUpdateReplenishmentShipmentImpl IMPL001 = (AmozonUpdateReplenishmentShipmentImpl) amozonUpdateReplenishmentShipment;
//		amozonUpdateReplenishmentShipment.updateAmazonOrderStatus(resultVO,5);

	}

}
