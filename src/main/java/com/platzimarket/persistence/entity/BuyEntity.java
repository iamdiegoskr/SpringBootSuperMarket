package com.platzimarket.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class BuyEntity {//Compra

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idBuy;

    @Column(name = "id_cliente")
    private String idClient;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String paymentMethod;

    @Column(name = "comentario")
    private String commentary;

    @Column(name="estado")
    private String status;

    @ManyToOne //Muchas compras pueden ser realizadas por un cliente.
    @JoinColumn(name = "id_cliente", insertable = false,updatable = false)
    private ClientEntity client;

    //Lista de productos que pertenecen a una compra
    @OneToMany(mappedBy = "buy", cascade = {CascadeType.ALL})
    private List<BuyProductsEntity> products;

    public Integer getIdBuy() {
        return idBuy;
    }

    public void setIdBuy(Integer idBuy) {
        this.idBuy = idBuy;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<BuyProductsEntity> getProducts() {
        return products;
    }

    public void setProducts(List<BuyProductsEntity> products) {
        this.products = products;
    }
}
