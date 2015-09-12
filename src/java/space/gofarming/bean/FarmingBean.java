/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.bean;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import space.gofarming.dao.GoFarmingDao;
import space.gofarming.entity.Bid;

/**
 *
 * @author aida
 */
@ManagedBean
@SessionScoped
public class FarmingBean implements Serializable {

    private String productName;
    private Date untilDate;
    private Float bidPrice;
    private GoFarmingDao dao;

    @PostConstruct
    public void init() {
        this.dao = new GoFarmingDao();
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public void setBidPrice(Float bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * Creates a new instance of FarmingBeann
     */
    public FarmingBean() {
    }

    public void addNewBid() {
        Bid bid = new Bid();
        bid.setProduct("111");
        dao.saveBid(bid);
    }

}
