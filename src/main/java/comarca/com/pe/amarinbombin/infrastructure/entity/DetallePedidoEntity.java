
package comarca.com.pe.amarinbombin.infrastructure.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDP;
    private Integer cantidad;
    private Double precioU;

    @ManyToOne
    @JoinColumn(name = "pedido_IdP")
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "producto_IdPr")
    private ProductEntity producto;

    public DetallePedidoEntity() {
    }

    public DetallePedidoEntity(Integer idDP, Integer cantidad, Double precioU, PedidoEntity pedido, ProductEntity producto) {
        this.idDP = idDP;
        this.cantidad = cantidad;
        this.precioU = precioU;
        this.pedido = pedido;
        this.producto = producto;
    }

    public Integer getIdDP() {
        return idDP;
    }

    public void setIdDP(Integer idDP) {
        this.idDP = idDP;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(Double precioU) {
        this.precioU = precioU;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public ProductEntity getProducto() {
        return producto;
    }

    public void setProducto(ProductEntity producto) {
        this.producto = producto;
    }
    
    
}