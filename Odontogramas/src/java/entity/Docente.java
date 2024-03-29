/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oscar Ballesteros
 */
@Entity
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByIddocente", query = "SELECT d FROM Docente d WHERE d.iddocente = :iddocente"),
    @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docente.findByClave", query = "SELECT d FROM Docente d WHERE d.clave = :clave"),
    @NamedQuery(name = "Docente.findByCodigo", query = "SELECT d FROM Docente d WHERE d.codigo = :codigo")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "iddocente")
    private Integer iddocente;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "clave")
    private String clave;
    @Column(name = "codigo")
    private String codigo;
    @JoinTable(name = "docente_has_medico", joinColumns = {
        @JoinColumn(name = "docente_iddocente", referencedColumnName = "iddocente")}, inverseJoinColumns = {
        @JoinColumn(name = "medico_idmedico", referencedColumnName = "idmedico")})
    @ManyToMany
    private List<Medico> medicoList;
    @ManyToMany(mappedBy = "docenteList")
    private List<Curso> cursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteIddocente")
    private List<Consulta> consultaList;

    public Docente() {
    }

    public Docente(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public Integer getIddocente() {
        return iddocente;
    }

    public void setIddocente(Integer iddocente) {
        this.iddocente = iddocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public List<Medico> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
        this.medicoList = medicoList;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
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
        hash += (iddocente != null ? iddocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.iddocente == null && other.iddocente != null) || (this.iddocente != null && !this.iddocente.equals(other.iddocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Docente[ iddocente=" + iddocente + " ]";
    }
    
}
