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
import space.gofarming.entity.Buyer;
import space.gofarming.entity.Farmer;
import space.gofarming.entity.Offer;

/**
 *
 * @author aida
 */
public class AdminDao {

    private static final Logger LOG = Logger.getLogger(AdminDao.class.getName());

    public void saveFarmer(Farmer farmer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.save(farmer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public List<Farmer> fetchFarmers() {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Query q = mySession.createQuery("from Farmer as b order by b.registerDate desc");
            List<Farmer> list = (List<Farmer>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    public void saveBuyer(Buyer buyer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.save(buyer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public List<Buyer> fetchBuyers() {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Query q = mySession.createQuery("from Buyer as o order by o.registerDate desc");
            List<Buyer> list = (List<Buyer>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

    public void updateFarmer(Farmer furmer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.update(furmer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void deleteFarmer(Farmer farmer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(farmer);
            tx.commit();
            session.flush();
            session.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void deleteBuyer(Buyer farmer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(farmer);
            tx.commit();
            session.flush();
            session.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

    public void updateBuyer(Buyer buyer) {
        try {
            Session mySession = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = mySession.beginTransaction();
            mySession.update(buyer);
            tx.commit();
            mySession.flush();
            mySession.close();
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
    }

}
