package com.universidad.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
/**Entidad carrera relacionada con:
 * profesor (muchos a muchos)
 * alumnos (uno a muchos )
 *
 * La fecha se persiste al ingresar y actualizar la entidad
 * */
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true,length = 80)
    private String nombre;

    @Column(name = "cantidad_materias")
    private Integer cantidadMaterias;

    @Column(name = "cantidad_anios")
    private Integer cantidadAnios;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificada;

    @JsonIgnoreProperties({"carreras","direccion"})
    @ManyToMany(mappedBy = "carreras",fetch = FetchType.LAZY)
    private Set<Profesor> profesores;

    @JsonIgnoreProperties({"carrera","direccion"})
    @OneToMany(mappedBy = "carrera",fetch = FetchType.LAZY)
    private Set<Alumno> alumnos;

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer cantidadMaterias, Integer cantidadAnios) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadMaterias = cantidadMaterias;
        this.cantidadAnios = cantidadAnios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadMaterias() {
        return cantidadMaterias;
    }

    public void setCantidadMaterias(Integer cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }

    public Integer getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(Integer cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
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

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    //@JsonManagedReference
    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidadMaterias=" + cantidadMaterias +
                ", cantidadAnios=" + cantidadAnios +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificada=" + fechaModificada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) && nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @PrePersist
    private void antesDePersistir(){this.fechaAlta=LocalDateTime.now();}
    @PreUpdate
    private void antesDeUpdate(){this.fechaModificada=LocalDateTime.now();}
}
