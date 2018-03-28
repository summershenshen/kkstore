package com.daoimp;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CartDao;
import com.model.Cart;
import com.model.MySessionFactory;

@Repository
public class CartImp implements CartDao{
	@Autowired
	public MySessionFactory mySessionFactory;
	
	public List<?> query() {
		Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(Cart.class);
        list = c.list();
        return list;
	}

	public Boolean isExist(String id) {
		Session session = mySessionFactory.getSession();
        List list;
        Criteria c = session.createCriteria(Cart.class);
        c.add(Restrictions.eq("id", id));
        return (c.list().size() > 0);
	}

	public void delete(String id) {
		Session session = mySessionFactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Cart cart;

        cart = (Cart) session.load(Cart.class, id);
        session.delete(cart);
        tx.commit();
		
	}

	public void deleteAll() {
		Session session = mySessionFactory.getSession();

        org.hibernate.Transaction tx = session.beginTransaction();
        Criteria c = session.createCriteria(Cart.class);
        Iterator iter = c.list().iterator();
        while (iter.hasNext()) {
        		Cart cart = (Cart) iter.next();
        		session.delete(cart);
        }
        tx.commit();
		
	}

	public void modify(String id, int newBuyNum) {
		Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Cart cart;
        cart = (Cart) session.load(Cart.class, id);
        cart.setBuyNum(newBuyNum);
        tx.commit();
		
	}

	public void add(Cart cart) {
		Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(cart);
        tx.commit();
	}

	public Cart queryById(String id) {
		Session session = mySessionFactory.getSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Cart cart;
        cart = (Cart) session.load(Cart.class, id);
        tx.commit();
        return cart;
	}
	
//	public static void main(String[] args) {
//		CartImp cartImp = new CartImp();
//		Cart cart = new Cart();
//		cart.setId("1");
//		cart.setBuyNum(4);
//		cartImp.add(cart);
//		if (cartImp.isExist("1"))
//			System.out.println("exist!");
//		else
//			System.out.println("no exist");
//	}

}
