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
    private String product;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date untilDte;
    private String buyer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getUntilDte() {
        return untilDte;
    }

    public void setUntilDte(Date untilDte) {
        this.untilDte = untilDte;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

}
