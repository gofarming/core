/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import space.gofarming.entity.Notification;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import space.gofarming.entity.Bid;
import space.gofarming.entity.Offer;

/**
 *
 * @author aida
 */
public class GoFarmingDao {

    private static final Logger LOG = Logger.getLogger(GoFarmingDao.class.getName());

    public void saveBid(Bid bid) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.save(bid);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public List<Bid> fetchBids() {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Query q = mySession.createQuery("from Bid as b order by b.createDate");
            List<Bid> list = (List<Bid>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    public List<Notification> fetchNotifications() {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Query q = mySession.createQuery("from Notification as b");
            List<Notification> list = (List<Notification>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    public void saveOffer(Offer offer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.save(offer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public List<Offer> fetchOffers() {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Query q = mySession.createQuery("from Offer as o order by o.createDate desc");
            List<Offer> list = (List<Offer>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    public void updateOffer(Offer offer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.update(offer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void deleteOffer(Offer offer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(offer);
            tx.commit();
            session.flush();
            session.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void deleteBid(Bid bid) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(bid);
            tx.commit();
            session.flush();
            session.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void updateBid(Bid bid) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.update(bid);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void addNotification(Notification n) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.save(n);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void deleteNotification(Notification note) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(note);
            tx.commit();
            session.flush();
            session.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

}
