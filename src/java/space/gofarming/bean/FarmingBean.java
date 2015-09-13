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
import space.gofarming.entity.Notification;
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
    private Date offerEndDate;
    private Float offerPrice;
    private Integer offerVolume;
    private String offerVolumeType;
    private String offerCurrency;
    private String offerLocation;
    private String offerDescription;
    private Offer selectedOffer;
    private Boolean deliveryAvailable;
    private List<Notification> noteList;

    private final Map<Integer, String> offerStatusMap = new HashMap<>();

    {
        offerStatusMap.put(1, "NEW");
        offerStatusMap.put(2, "CLOSED");
        offerStatusMap.put(3, "IN PROGRESS");
    }

    public String offerStatusDescription(Offer offer) {
        if (offerStatusMap.containsKey(offer.getStatus())) {
            return offerStatusMap.get(offer.getStatus());
        } else {
            return "UNKNOWN";
        }
    }

    @PostConstruct
    public void init() {

//        this.offerStatusMap = new HashMap<>();
        this.dao = new GoFarmingDao();
        this.bidList = new ArrayList<>();
        this.offerList = new ArrayList<>();
    }

    public Offer getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(Offer selectedOffer) {
        this.selectedOffer = selectedOffer;
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
    public FarmingBean() {
//        this.bidList = dao.fetchBids();
    }

    public List<Bid> getBidList() {
        return bidList;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public String getOfferLocation() {
        return offerLocation;
    }

    public void setOfferLocation(String offerLocation) {
        this.offerLocation = offerLocation;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public void addNewBid() {
        Bid bid = new Bid();
        bid.setProductName("pn");
        dao.saveBid(bid);
    }

    public String getOfferCurrency() {
        return offerCurrency;
    }

    public void setOfferCurrency(String offerCurrency) {
        this.offerCurrency = offerCurrency;
    }

    public String getOfferVolumeType() {
        return offerVolumeType;
    }

    public void setOfferVolumeType(String offerVolumeType) {
        this.offerVolumeType = offerVolumeType;
    }

    public Integer getOfferVolume() {
        return offerVolume;
    }

    public void setOfferVolume(Integer offerVolume) {
        this.offerVolume = offerVolume;
    }

    public Float getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Float offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Date getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(Date offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    public Boolean getDeliveryAvailable() {
        return deliveryAvailable;
    }

    public void setDeliveryAvailable(Boolean deliveryAvailable) {
        this.deliveryAvailable = deliveryAvailable;
    }

    public List<Notification> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Notification> noteList) {
        this.noteList = noteList;
    }

    public void addNewOffer() {
        Offer offer = new Offer();
        offer.setProductName(productName);
        offer.setCreateDate(new Date());
        offer.setCurrency(offerCurrency);
        offer.setEndDate(offerEndDate);
        offer.setFarmerId("farmer");
        offer.setLocation(offerLocation);
        offer.setPrice(offerPrice);
        offer.setVolume(offerVolume);
        offer.setVolumeType(offerVolumeType);
        offer.setDescription(offerDescription);
        offer.setStatus(1);
        offer.setDeliveryAvailable(deliveryAvailable);
        dao.saveOffer(offer);
        fetchOffers();
    }

    public void fetchBids() {
        this.bidList = dao.fetchBids();
    }

    public void fetchOffers() {
        this.offerList = dao.fetchOffers();
    }

    public void closeOffer(Offer offer) {
        offer.setStatus(2);
        offer.setCloseDate(new Date());
        dao.updateOffer(offer);
    }

    public void deleteOffer(Offer offer) {
        dao.deleteOffer(offer);
        fetchOffers();
    }

    public void fetchNotifications() {
        this.noteList = dao.fetchNotifications();
    }

    public void selectOffer(Offer offer) {
        this.selectedOffer = offer;
    }
    
    public void deleteNotification(Notification note) {
        dao.deleteNotification(note);
        fetchNotifications();
    }

}
