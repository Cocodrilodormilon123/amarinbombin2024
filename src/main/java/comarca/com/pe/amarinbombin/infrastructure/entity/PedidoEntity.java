package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idP;
    private LocalDate fecha;
    private String nroPedido;
    private String dircEntrega;
    private String estado;
    private Double totalPedido;
    private LocalDate fechEntrega;

    @ManyToOne
    @JoinColumn(name = "cliente_IdU")
    private UserEntity cliente;

    public PedidoEntity() {
    }

    public PedidoEntity(Integer idP, LocalDate fecha, String nroPedido, String dircEntrega, String estado, Double totalPedido, LocalDate fechEntrega, UserEntity cliente) {
        this.idP = idP;
        this.fecha = fecha;
        this.nroPedido = nroPedido;
        this.dircEntrega = dircEntrega;
        this.estado = estado;
        this.totalPedido = totalPedido;
        this.fechEntrega = fechEntrega;
        this.cliente = cliente;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    public String getDircEntrega() {
        return dircEntrega;
    }

    public void setDircEntrega(String dircEntrega) {
        this.dircEntrega = dircEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public LocalDate getFechEntrega() {
        return fechEntrega;
    }

    public void setFechEntrega(LocalDate fechEntrega) {
        this.fechEntrega = fechEntrega;
    }

    public UserEntity getCliente() {
        return cliente;
    }

    public void setCliente(UserEntity cliente) {
        this.cliente = cliente;
    }
    
    
    
}
