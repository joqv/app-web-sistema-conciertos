package com.cibertec.app_web_reservas_conciertos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "palcos")
public class Palco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_palco")
    private Long idPalco;

    @Column(name = "nombre_palco")
    private String nombrePalco;

    @Column(name = "aforo")
    private Integer aforo;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "estado")
    private String estado= "ACTIVO";

    public Palco() {
    }

    public Palco(Long idPalco, String ubicacion, Integer aforo, String nombrePalco) {
        this.ubicacion = ubicacion;
        this.aforo = aforo;
        this.nombrePalco = nombrePalco;
    }

    public Long getIdPalco() {
        return idPalco;
    }

    public void setIdPalco(Long idPalco) {
        this.idPalco = idPalco;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public String getNombrePalco() {
        return nombrePalco;
    }

    public void setNombrePalco(String nombrePalco) {
        this.nombrePalco = nombrePalco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
