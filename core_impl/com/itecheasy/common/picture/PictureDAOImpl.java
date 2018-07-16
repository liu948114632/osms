package com.itecheasy.common.picture;

import java.util.List;

import com.itecheasy.common.BaseDAOImpl;
import com.itecheasy.common.po.PictureStorePO;
import com.itecheasy.common.po.PictureStoreRule;
import com.itecheasy.common.po.PictureUrlRule;

public class PictureDAOImpl extends BaseDAOImpl<PictureStorePO, String>
  implements PictureDAO
{
  @SuppressWarnings("unchecked")
public List<PictureStoreRule> getAllPictureStoreRule()
  {
    return (List<PictureStoreRule>)getHibernateTemplate().loadAll(PictureStoreRule.class);
  }

  @SuppressWarnings("unchecked")
public List<PictureUrlRule> getAllPictureUrlRule()
  {
    return getHibernateTemplate().loadAll(PictureUrlRule.class);
  }
}