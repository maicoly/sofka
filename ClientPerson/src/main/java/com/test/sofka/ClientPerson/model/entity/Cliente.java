package com.test.sofka.ClientPerson.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * Fecha de creación: 2025/02/16
 * Autor: maicoly
 * Descripción: Entity for Client data
 */
@Entity
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Persona{
    @Column(unique = true, nullable = false, name = "cliente_id")
    private String clienteId;
    private String contrasena;
    private Boolean estado=true;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
