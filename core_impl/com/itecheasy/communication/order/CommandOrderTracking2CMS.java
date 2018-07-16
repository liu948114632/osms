package com.itecheasy.communication.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.itecheasy.common.attachment.AttachmentService;
import com.itecheasy.common.util.CollectionUtils;
import com.itecheasy.common.util.DateUtils;
import com.itecheasy.core.BussinessException;
import com.itecheasy.core.CommunicationException;
import com.itecheasy.core.order.OrderTracking;
import com.itecheasy.core.order.OrderTrackingProduct;
import com.itecheasy.core.order.OrderTrackingProductAttachment;
import com.itecheasy.core.system.Merchandiser;
import com.itecheasy.core.system.SystemService;
import com.itecheasy.core.user.ProfileService;
import com.itecheasy.webservice.client.CMSOrderClient;
import com.itecheasy.webservice.cms.order.OrderTrackingAttachment;
import com.itecheasy.webservice.cms.order.OrderTrackingItem;

/**
 * @author whw
 * @date 2017-8-23
 * @description 通讯订单跟踪
 * @version
 */
public class CommandOrderTracking2CMS {
	private SystemService systemService;
	private ProfileService profileService;
	private AttachmentService attachmentService;

	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	private int convert2cmsUserId(int systemUserId) {
		if(systemUserId==0) return 0;
		Merchandiser m = systemService.getMerchandiserbyUserId(systemUserId);
		return m != null ? m.getId() : 0;
	}

	public void addOrderTrackingToCMS(OrderTracking tracking, int operatorId, Boolean isAdd) {
		int cmsUserId = convert2cmsUserId(operatorId);
		com.itecheasy.webservice.cms.order.OrderTracking ctracking = new com.itecheasy.webservice.cms.order.OrderTracking();
		ctracking.setCode(tracking.getCode());
		ctracking.setType(tracking.getType());
		ctracking.setOrderCode(tracking.getOrderCode());
		ctracking.setConsultationUserId(convert2cmsUserId(tracking.getConsultationUserId()));
		ctracking.setCreateUserId(convert2cmsUserId(tracking.getCreateUserId()));
		if (isAdd) {
			ctracking.setCreatedtype(1);
		} else {
			ctracking.setId(tracking.getId());
		}
		if (CollectionUtils.isNotEmpty(tracking.getProducts())) {
			List<OrderTrackingItem> itemList = new ArrayList<OrderTrackingItem>();
			OrderTrackingItem item = null;
			for (OrderTrackingProduct product : tracking.getProducts()) {
				item = new OrderTrackingItem();
				item.setContent(product.getConsultationContent());
				item.setReplyUserId(cmsUserId);
				item.setProductId(product.getCmsProductId());
				itemList.add(item);
			}
			ctracking.setTrackingItems(itemList);
		}
		CMSOrderClient.setOrderTracking(ctracking, profileService.getUserByID(operatorId));
	}

	public void replyOrderTrackingToCMS(OrderTracking orderTracking, int operatorId) {
		int cmsUserId = convert2cmsUserId(operatorId);
		com.itecheasy.webservice.cms.order.OrderTracking cmsOrderTracking = new com.itecheasy.webservice.cms.order.OrderTracking();
		cmsOrderTracking.setCode(orderTracking.getCode());
		cmsOrderTracking.setType(orderTracking.getType());
		cmsOrderTracking.setOrderCode(orderTracking.getOrderCode());
		cmsOrderTracking.setConsultationUserId(convert2cmsUserId(orderTracking.getConsultationUserId()));
		List<OrderTrackingItem> itemList = new ArrayList<OrderTrackingItem>();
		for (OrderTrackingProduct product : orderTracking.getProducts()) {
			OrderTrackingItem item = new OrderTrackingItem();

			item.setContent(product.getConsultationContent());
			item.setReplyUserId(cmsUserId);
			item.setProductId(product.getCmsProductId());
			item.setReplyTime(DateUtils.getXMLGregorianCalendar(new Date()));
			item.setReplyContent(product.getBranchRemark());
			item.setStatus(orderTracking.getStatus());
			List<com.itecheasy.webservice.cms.order.OrderTrackingAttachment> attachList = new ArrayList<com.itecheasy.webservice.cms.order.OrderTrackingAttachment>();
			if (CollectionUtils.isNotEmpty(product.getAttachments())) {
				for (OrderTrackingProductAttachment atth : product.getAttachments()) {
					OrderTrackingAttachment at = new OrderTrackingAttachment();
					int pos = atth.getOriginalFileName().lastIndexOf(".");
					String ext = atth.getOriginalFileName().substring(pos);
					try {
						String name=CMSOrderClient.uploadAttachment(
								FileUtils.readFileToByteArray(attachmentService.getAttachmentFile(atth.getFileCode())),
								ext);
						at.setAttachmentName(name);
					} catch (IOException e) {
						e.printStackTrace();
						at.setAttachmentName(atth.getOriginalFileName());
					}
					at.setAttachmentCode(atth.getFileCode());
					at.setOrderTrackingItemId(product.getId());
					attachList.add(at);
				}
			}
			item.setOrderTrackingAttachments(attachList);
			itemList.add(item);
		}
		cmsOrderTracking.setTrackingItems(itemList);
		try {
			CMSOrderClient.replyOrderTrackingToCMS(cmsOrderTracking, cmsUserId);
		} catch (CommunicationException e) {
			throw new BussinessException(e.toString());
		}
	}

	public void setOrderTrackingRemark(String code, int operator, String remark) {
		CMSOrderClient.setOrderTrackingRemark(code, convert2cmsUserId(operator), remark);
	}

	public void upateOrderTrackingConsultationUserIdToCMS(int userId, List<String> orderTrackingCodes) {
		CMSOrderClient.setConsultationUser(orderTrackingCodes, profileService.getUserByID(userId));
	}

	public void deleteOrderTrackingByIdToCMS(List<String> codes) {
		CMSOrderClient.delOrderTracking(codes);
	}

	public void completeOrderTrackingToCMS(List<String> code) {
		CMSOrderClient.completeOrderTrackingToCMS(code);
	}

}
