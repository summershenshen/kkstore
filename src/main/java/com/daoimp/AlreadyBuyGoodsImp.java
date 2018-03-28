package com.daoimp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.AlreadyBuyGoodsDao;
import com.model.AlreadyBuyGoods;
import com.model.Goods;
import com.model.MySessionFactory;
@Repository
public class AlreadyBuyGoodsImp implements AlreadyBuyGoodsDao{

	@Autowired
	public MySessionFactory mySessionFactory;

	public List<?> query() {
		Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(AlreadyBuyGoods.class);
        list = c.list();
        return list;
	}

	public void delete(String id)
    {

        Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        AlreadyBuyGoods alreadyBuyGoods;

        alreadyBuyGoods = (AlreadyBuyGoods) session.load(AlreadyBuyGoods.class, id);
        session.delete(alreadyBuyGoods);
        tx.commit();
    }

	public void add(AlreadyBuyGoods alreadyBuyGoods)
    {

        Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(alreadyBuyGoods);
        tx.commit();
    }

}
