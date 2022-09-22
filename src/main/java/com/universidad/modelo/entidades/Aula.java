package com.universidad.modelo.entidades;

import com.universidad.modelo.entidades.enumeradores.Pizarron;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_aula", nullable = false)
    private Integer nroAula;

    @Column(name = "medidas_mtsxmts")
    private String medidas;

    @Column(name = "cantidad_pupitres")
    private Integer cantidad;

    @Column(name = "tipo_pizarrron")
    @Enumerated(EnumType.STRING)
    private Pizarron pizarron;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificada")
    private LocalDateTime fechaModificada;

    @ManyToOne(optional = true,cascade = {
                    CascadeType.PERSIST,CascadeType.MERGE}
    )
    @JoinColumn(name = "pabellon_id",foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Aula() {
    }

    public Aula(Integer id, Integer nroAula, String medidas, Integer cantidad, Pizarron pizarron) {
        this.id = id;
        this.nroAula = nroAula;
        this.medidas = medidas;
        this.cantidad = cantidad;
        this.pizarron = pizarron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNroAula() {
        return nroAula;
    }

    public void setNroAula(Integer nroAula) {
        this.nroAula = nroAula;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pizarron getPizarron() {
        return pizarron;
    }

    public void setPizarron(Pizarron pizarron) {
        this.pizarron = pizarron;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificada() {
        return fechaModificada;
    }

    public void setFechaModificada(LocalDateTime fechaModificada) {
        this.fechaModificada = fechaModificada;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @PrePersist
    private void antesDePersistir(){this.fechaAlta=LocalDateTime.now();}
    @PreUpdate
    private void antesDeUpdate(){this.fechaAlta=LocalDateTime.now();}

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", nroAula=" + nroAula +
                ", medidas='" + medidas + '\'' +
                ", cantidad=" + cantidad +
                ", pizarron=" + pizarron +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificada=" + fechaModificada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) && nroAula.equals(aula.nroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nroAula);
    }
}
