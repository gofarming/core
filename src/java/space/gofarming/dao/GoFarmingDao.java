/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import space.gofarming.entity.Bid;

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

}
