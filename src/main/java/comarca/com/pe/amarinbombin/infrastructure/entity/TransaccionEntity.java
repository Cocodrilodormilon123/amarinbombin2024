package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaccion")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idT;
    private Double monto;
    private String metodoPago;
    private LocalDate fecha;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "pedido_IdP")
    private PedidoEntity pedido;

    public TransaccionEntity() {
    }

    public TransaccionEntity(Integer idT, Double monto, String metodoPago, LocalDate fecha, String estado, PedidoEntity pedido) {
        this.idT = idT;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fecha = fecha;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getIdT() {
        return idT;
    }

    public void setIdT(Integer idT) {
        this.idT = idT;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }
    
    
}