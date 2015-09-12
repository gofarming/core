/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import space.gofarming.dao.GoFarmingDao;
import space.gofarming.entity.Bid;
import space.gofarming.entity.Offer;

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
    private List<Bid> bidList;
    private List<Offer> offerList;

    @PostConstruct
    public void init() {
        this.dao = new GoFarmingDao();
        this.bidList = new ArrayList<>();
        this.offerList = new ArrayList<>();
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
//        this.bidList = dao.fetchBids();
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void addNewBid() {
        Bid bid = new Bid();
        bid.setProductName("pn");
        dao.saveBid(bid);
    }

    public void addNewOffer() {
        Offer offer = new Offer();
        offer.setProductName("pn");
        dao.saveOffer(offer);
        fetchOffers();
    }

    public void fetchBids() {
        this.bidList = dao.fetchBids();
    }

    public void fetchOffers() {
        this.offerList = dao.fetchOffers();
    }

}
