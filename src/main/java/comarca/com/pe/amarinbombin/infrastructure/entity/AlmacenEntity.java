package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "almacen")
public class AlmacenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idA;
    private String nombre;
    private String direccion;
    private Integer capacidad;
    private Integer stockActual;
    private LocalDateTime fechaUltimaActualizacion;

    @PreUpdate
    protected void onUpdate() {
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }

    public AlmacenEntity() {
    }

    public AlmacenEntity(Integer idA, String nombre, String direccion, Integer capacidad, Integer stockActual, LocalDateTime fechaUltimaActualizacion) {
        this.idA = idA;
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.stockActual = stockActual;
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    public Integer getIdA() {
        return idA;
    }

    public void setIdA(Integer idA) {
        this.idA = idA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public LocalDateTime getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    public void setFechaUltimaActualizacion(LocalDateTime fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }
    
}