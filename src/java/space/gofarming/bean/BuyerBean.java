/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class BuyerBean implements Serializable {

    private String productName;
    private Date untilDate;
    private Float bidPrice;
    private GoFarmingDao dao;
    private List<Bid> bidList;
    private Date bidEndDate;
    private Integer bidVolume;
    private String bidVolumeType;
    private String bidCurrency;
    private String bidLocation;
    private String bidDescription;

    private final Map<Integer, String> bidStatusMap = new HashMap<>();

    {
        bidStatusMap.put(1, "NEW");
        bidStatusMap.put(2, "CLOSED");
        bidStatusMap.put(3, "IN PROGRESS");
    }

    public String bidStatusDescription(Bid bid) {
        if (bidStatusMap.containsKey(bid.getStatus())) {
            return bidStatusMap.get(bid.getStatus());
        } else {
            return "UNKNOWN";
        }
    }

    @PostConstruct
    public void init() {

//        this.bidStatusMap = new HashMap<>();
        this.dao = new GoFarmingDao();
        this.bidList = new ArrayList<>();
        this.bidList = new ArrayList<>();
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Date getUntilDate() {
        return untilDate;
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
    public BuyerBean() {
//        this.bidList = dao.fetchBids();
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public String getBidLocation() {
        return bidLocation;
    }

    public void setBidLocation(String bidLocation) {
        this.bidLocation = bidLocation;
    }

    public String getBidDescription() {
        return bidDescription;
    }

    public void setBidDescription(String bidDescription) {
        this.bidDescription = bidDescription;
    }

    public void addNewBid() {
        Bid bid = new Bid();
        bid.setProductName("pn");
        dao.saveBid(bid);
    }

    public String getBidCurrency() {
        return bidCurrency;
    }

    public void setBidCurrency(String bidCurrency) {
        this.bidCurrency = bidCurrency;
    }

    public String getBidVolumeType() {
        return bidVolumeType;
    }

    public void setBidVolumeType(String bidVolumeType) {
        this.bidVolumeType = bidVolumeType;
    }

    public Integer getBidVolume() {
        return bidVolume;
    }

    public void setBidVolume(Integer bidVolume) {
        this.bidVolume = bidVolume;
    }

    public Float getBidPrice() {
        return bidPrice;
    }

    public Date getBidEndDate() {
        return bidEndDate;
    }

    public void setBidEndDate(Date bidEndDate) {
        this.bidEndDate = bidEndDate;
    }

    public void addNewBid2() {
        Bid bid = new Bid();
        bid.setProductName(productName);
        bid.setCreateDate(new Date());
//        bid.setCurrency(bidCurrency);
        bid.setEndDate(bidEndDate);
//        bid.setFarmerId("farmer");
//        bid.setLocation(bidLocation);
//        bid.setPrice(bidPrice);
        bid.setVolume(bidVolume);
//        bid.setVolumeType(bidVolumeType);
//        bid.setDescription(bidDescription);
        bid.setStatus(1);
        dao.saveBid(bid);
        fetchBids();
    }

    public void fetchBids() {
        this.bidList = dao.fetchBids();
    }

    public void closeBid(Bid bid) {
        bid.setStatus(2);
//        bid.setCloseDate(new Date());
        dao.updateBid(bid);
    }

    public void deleteBid(Bid bid) {
        dao.deleteBid(bid);
        fetchBids();
    }

}
