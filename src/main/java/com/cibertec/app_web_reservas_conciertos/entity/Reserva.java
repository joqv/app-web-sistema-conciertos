package com.cibertec.app_web_reservas_conciertos.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_palco", referencedColumnName = "id_palco")
    private Palco palco;

    @Column(name = "fecha")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_final")
    private LocalTime horaFinal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "activo")
    private String activo;

    public Reserva() {
    }

    public Reserva(Long idReserva, Palco palco, Usuario usuario, LocalDate fecha, LocalTime horaInicio, String activo, String estado, LocalTime horaFinal) {
        this.idReserva = idReserva;
        this.palco = palco;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.activo = activo;
        this.estado = estado;
        this.horaFinal = horaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Palco getPalco() {
        return palco;
    }

    public void setPalco(Palco palco) {
        this.palco = palco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", usuario=" + usuario +
                ", palco=" + palco +
                ", fecha=" + fecha +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                ", estado='" + estado + '\'' +
                ", activo='" + activo + '\'' +
                '}';
    }
}
