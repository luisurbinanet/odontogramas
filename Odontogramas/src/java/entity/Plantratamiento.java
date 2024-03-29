/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oscar Ballesteros
 */
@Entity
@Table(name = "plantratamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantratamiento.findAll", query = "SELECT p FROM Plantratamiento p"),
    @NamedQuery(name = "Plantratamiento.findByIdplanTratamiento", query = "SELECT p FROM Plantratamiento p WHERE p.idplanTratamiento = :idplanTratamiento"),
    @NamedQuery(name = "Plantratamiento.findByNombre", query = "SELECT p FROM Plantratamiento p WHERE p.nombre = :nombre")})
public class Plantratamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplanTratamiento")
    private Integer idplanTratamiento;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "plantratamientoList")
    private List<Consulta> consultaList;

    public Plantratamiento() {
    }

    public Plantratamiento(Integer idplanTratamiento) {
        this.idplanTratamiento = idplanTratamiento;
    }

    public Integer getIdplanTratamiento() {
        return idplanTratamiento;
    }

    public void setIdplanTratamiento(Integer idplanTratamiento) {
        this.idplanTratamiento = idplanTratamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplanTratamiento != null ? idplanTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantratamiento)) {
            return false;
        }
        Plantratamiento other = (Plantratamiento) object;
        if ((this.idplanTratamiento == null && other.idplanTratamiento != null) || (this.idplanTratamiento != null && !this.idplanTratamiento.equals(other.idplanTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Plantratamiento[ idplanTratamiento=" + idplanTratamiento + " ]";
    }
    
}
