package com.platzimarket.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class ClientEntity { //Cliente

    @Id
    @Column(name = "id")
    private String idClient;

    @Column(name = "nombre")
    private String name;

    @Column(name="apellidos")
    private String lastname;

    @Column(name="celular")
    private Double cellphone;

    @Column(name="direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "client")
    private List<BuyEntity> buys;

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getCellphone() {
        return cellphone;
    }

    public void setCellphone(Double cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
