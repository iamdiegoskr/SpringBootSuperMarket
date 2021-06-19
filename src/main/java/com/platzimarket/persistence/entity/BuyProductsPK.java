package com.platzimarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuyProductsPK implements Serializable {

    @Column(name="id_compra")
    private Integer idBuy;

    @Column(name = "id_producto")
    private Integer idProduct;

    public Integer getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Integer idBuy) {
        this.idBuy = idBuy;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }
}
