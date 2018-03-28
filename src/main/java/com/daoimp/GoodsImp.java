package com.daoimp;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.GoodsDao;
import com.model.Goods;
import com.model.MySessionFactory;
@Repository
public class GoodsImp implements GoodsDao{
	@Autowired
	public MySessionFactory mySessionFactory;
	
	public List query()
    {

        Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(Goods.class);
        list = c.list();
        return list;
    }
	
	public Goods queryById(String id) {
		Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Goods goods;
        goods = (Goods) session.load(Goods.class, id);
        tx.commit();
        return goods;
	}

	
	public List queryWantToBuy()
    {
        Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(Goods.class);
        c.add(Restrictions.eq("wantToBuy", (byte)1));
        list = c.list();
        return list;
    }

	public void delete(String id)
    {

        Session session = mySessionFactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Goods goods;

        goods = (Goods) session.load(Goods.class, id);
        session.delete(goods);
        tx.commit();
    }

	public void modify(String id, Goods newGoods)
    {

        Session session = mySessionFactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Goods goods;
        goods = (Goods) session.load(Goods.class, id);
        goods.setName(newGoods.getName());
        goods.setAbstract1(newGoods.getAbstract1());
        goods.setIntroduction(newGoods.getIntroduction());
        goods.setImage(newGoods.getImage());
        goods.setPrice(newGoods.getPrice());
        goods.setAlreadyBuy(newGoods.getAlreadyBuy());
        goods.setWanttoBuy(newGoods.isWanttoBuy());
        goods.setStore(newGoods.getStore());
        tx.commit();
    }

	public void add(Goods goods)
    {

        Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(goods);
        tx.commit();
    }

	public Boolean idExist(String id) {
		Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(Goods.class);
        c.add(Restrictions.eq("id", id));
        return (c.list().size() > 0);
        
	}
}
