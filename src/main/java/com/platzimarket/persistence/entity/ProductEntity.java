package com.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="productos")
public class ProductEntity {//Producto

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Integer idProduct;

    @Column(name="nombre")
    private String name;

    @Column(name="id_categoria")
    private Integer idCategory;

    @Column(name="codigo_barras")
    private String barcode;

    @Column(name = "precio_venta")
    private Double salePrice;

    @Column(name = "cantidad_stock")
    private Integer quantityStock;

    @Column(name = "estado")
    private Boolean status;

    @ManyToOne //Muchos a uno, muchos productos pueden pertenecer a una categoria
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private CategoryEntity category;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
