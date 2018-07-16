package com.itecheasy.common.attachment;

import java.util.List;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.po.AttachmentStore;
import com.itecheasy.common.po.AttachmentStoreRule;

public class AttachmentDAOImpl extends BaseDAOImpl<AttachmentStore, String>
  implements AttachmentDAO
{
  @SuppressWarnings("unchecked")
public List<AttachmentStoreRule> getAllAttachmentStoreRule()
  {
    return getHibernateTemplate().loadAll(AttachmentStoreRule.class);
  }
}