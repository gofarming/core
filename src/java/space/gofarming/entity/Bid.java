/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author aida
 */
@Entity
@Table(name = "BID")
public class Bid implements Serializable {

    @Id
    @GeneratedValue(generator = "bid_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bid_seq", sequenceName = "bid_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String productName;
    private String buyerName;
    private Integer volume;
    private Float preferedPrice;
    private Boolean deliveryRequest;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date endDate;
    private Integer status;

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Float getPreferedPrice() {
        return preferedPrice;
    }

    public void setPreferedPrice(Float preferedPrice) {
        this.preferedPrice = preferedPrice;
    }

    public Boolean getDeliveryRequest() {
        return deliveryRequest;
    }

    public void setDeliveryRequest(Boolean deliveryRequest) {
        this.deliveryRequest = deliveryRequest;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
