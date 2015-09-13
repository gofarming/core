/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import space.gofarming.dao.AdminDao;
import space.gofarming.entity.Buyer;
import space.gofarming.entity.Farmer;

/**
 *
 * @author aida
 */
@ManagedBean
@SessionScoped
public class AdminBean implements Serializable {

    private String farmerFullname, farmerContactNumber, farmerEmail, farmerLocation;
    private String buyerFullname, buyerContactNumber, buyerEmail, buyerLocation;
    private AdminDao dao;
    private List<Farmer> farmerList;
    private List<Buyer> buyerList;

    /**
     * Creates a new instance of AdminBean
     */
    public AdminBean() {
    }

    @PostConstruct
    public void init() {
        dao = new AdminDao();
    }

    public String getFarmerFullname() {
        return farmerFullname;
    }

    public void setFarmerFullname(String farmerFullname) {
        this.farmerFullname = farmerFullname;
    }

    public String getFarmerContactNumber() {
        return farmerContactNumber;
    }

    public void setFarmerContactNumber(String farmerContactNumber) {
        this.farmerContactNumber = farmerContactNumber;
    }

    public String getFarmerEmail() {
        return farmerEmail;
    }

    public void setFarmerEmail(String farmerEmail) {
        this.farmerEmail = farmerEmail;
    }

    public String getBuyerFullname() {
        return buyerFullname;
    }

    public void setBuyerFullname(String buyerFullname) {
        this.buyerFullname = buyerFullname;
    }

    public String getBuyerContactNumber() {
        return buyerContactNumber;
    }

    public void setBuyerContactNumber(String buyerContactNumber) {
        this.buyerContactNumber = buyerContactNumber;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getFarmerLocation() {
        return farmerLocation;
    }

    public void setFarmerLocation(String farmerLocation) {
        this.farmerLocation = farmerLocation;
    }

    public String getBuyerLocation() {
        return buyerLocation;
    }

    public void setBuyerLocation(String buyerLocation) {
        this.buyerLocation = buyerLocation;
    }

    public List<Farmer> getFarmerList() {
        return farmerList;
    }

    public void setFarmerList(List<Farmer> farmerList) {
        this.farmerList = farmerList;
    }

    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    public void addFarmer() {
        Farmer farmer = new Farmer();
        farmer.setFullname(farmerFullname);
        farmer.setContactNumber(farmerContactNumber);
        farmer.setEmail(farmerEmail);
        farmer.setLocation(farmerLocation);
        farmer.setRegisterDate(new Date());
        farmer.setStatus(1);
        dao.saveFarmer(farmer);
        fetchFarmerList();
    }

    public void addBuyer() {
        Buyer buyer = new Buyer();
        buyer.setFullname(buyerFullname);
        buyer.setContactNumber(buyerContactNumber);
        buyer.setEmail(buyerEmail);
        buyer.setLocation(buyerLocation);
        buyer.setRegisterDate(new Date());
        buyer.setStatus(1);
        dao.saveBuyer(buyer);
        fetchBuyerList();
    }

    public void fetchFarmerList() {
        this.farmerList = dao.fetchFarmers();
    }

    public void fetchBuyerList() {
        this.buyerList = dao.fetchBuyers();
    }

}
