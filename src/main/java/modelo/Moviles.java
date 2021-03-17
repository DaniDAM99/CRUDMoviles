/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "moviles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moviles.findAll", query = "SELECT m FROM Moviles m"),
    @NamedQuery(name = "Moviles.findById", query = "SELECT m FROM Moviles m WHERE m.id = :id"),
    @NamedQuery(name = "Moviles.findByMarca", query = "SELECT m FROM Moviles m WHERE m.marca = :marca"),
    @NamedQuery(name = "Moviles.findByModelo", query = "SELECT m FROM Moviles m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "Moviles.findByColor", query = "SELECT m FROM Moviles m WHERE m.color = :color"),
    @NamedQuery(name = "Moviles.findByPrecio", query = "SELECT m FROM Moviles m WHERE m.precio = :precio")})
public class Moviles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "color")
    private String color;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private BigDecimal precio;

    public Moviles() {
    }

    public Moviles(Integer id) {
        this.id = id;
    }

    public Moviles(Integer id, String marca, String modelo, String color, BigDecimal precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviles)) {
            return false;
        }
        Moviles other = (Moviles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Moviles[ id=" + id + " ]";
    }
    
}
