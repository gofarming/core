/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Query q = mySession.createQuery("from Offer as o order by o.createDate");
            List<Offer> list = (List<Offer>) q.list();
            mySession.close();
            return list;
        } catch (Exception e) {
            LOG.log(Level.INFO, e.getMessage());
        }
        return null;
    }

}
