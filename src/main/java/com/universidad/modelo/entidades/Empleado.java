package com.universidad.modelo.entidades;

import com.universidad.modelo.entidades.enumeradores.TipoEmplado;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{

    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)
    private TipoEmplado tipoEmplado;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id",foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmplado tipoEmplado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmplado = tipoEmplado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public TipoEmplado getTipoEmplado() {
        return tipoEmplado;
    }

    public void setTipoEmplado(TipoEmplado tipoEmplado) {
        this.tipoEmplado = tipoEmplado;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", tipoEmplado=" + tipoEmplado +
                ", pabellon=" + pabellon +
                "} " + super.toString();
    }
}
