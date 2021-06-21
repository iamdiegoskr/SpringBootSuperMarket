package com.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="compras_productos")
public class BuyProductsEntity { //Clase intermetida, con clave primaria compuesta

    @EmbeddedId
    private BuyProductsPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private Double total;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_compra",insertable = false,updatable = false)
    private BuyEntity buy;

    @ManyToOne
    @JoinColumn(name="id_producto",insertable = false,updatable = false)
    private ProductEntity product;

    public BuyProductsPK getId() {
        return id;
    }

    public void setId(BuyProductsPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
