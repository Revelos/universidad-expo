package com.universidad.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona   {

    @ManyToOne(optional = true,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "carrera_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","profesores","alumnos"})
    private Carrera carrera;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

    //@JsonBackReference
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "carrera=" + carrera +
                "} " + super.toString();
    }
}
