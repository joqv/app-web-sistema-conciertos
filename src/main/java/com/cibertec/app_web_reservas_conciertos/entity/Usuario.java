package com.cibertec.app_web_reservas_conciertos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private String estado; // valores posibles: ACTIVO o INACTIVO

    @Column(name = "rol")
    private String rol; // valores posibles: ADMINISTRADOR o USUARIO


    public Usuario() {
    }

    public Usuario(Long idUsuario, String ruc, String telefono, String nombreUsuario) {
        this.idUsuario = idUsuario;
        this.ruc = ruc;
        this.telefono = telefono;
        this.nombreUsuario = nombreUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ruc='" + ruc + '\'' +
                '}';
    }
}
