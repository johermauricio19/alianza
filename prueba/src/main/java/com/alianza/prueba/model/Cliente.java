package com.alianza.prueba.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String telefono;

    @NotNull
    private String correo;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    private String sharedKey;

    // Constructor vacío para JPA
    public Cliente() {}

    public Cliente(String nombre, String telefono, String correo, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.sharedKey = generateSharedKey(nombre);
    }

    // Método para generar la shared key
    public String generateSharedKey(String nombre) {
        return nombre.substring(0, 1) + nombre.split(" ")[1].substring(0, 1); // Ejemplo de sharedKey con iniciales
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.sharedKey = generateSharedKey(nombre); // Regeneramos la sharedKey si cambia el nombre
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSharedKey() {
        return sharedKey;
    }

    public void setSharedKey(String sharedKey) {
        this.sharedKey = sharedKey;
    }
}
