package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPr")
    private Integer idPr;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen;

    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "almacen_IdA")
    private AlmacenEntity almacen;

    @ManyToOne
    @JoinColumn(name = "user_IdU")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "categoria_IdCg")
    private CategoryEntity categoria;

    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        dateUpdated = LocalDateTime.now();
    }

    public ProductEntity() {
    }

    public ProductEntity(Integer idPr, String nombre, String descripcion, Double precio, Integer stock, String imagen, LocalDateTime dateCreated, LocalDateTime dateUpdated, AlmacenEntity almacen, UserEntity userEntity, CategoryEntity categoria) {
        this.idPr = idPr;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.almacen = almacen;
        this.userEntity = userEntity;
        this.categoria = categoria;
    }

    
    
    public Integer getIdPr() {
        return idPr;
    }

    public void setIdPr(Integer idPr) {
        this.idPr = idPr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public AlmacenEntity getAlmacen() {
        return almacen;
    }

    public void setAlmacen(AlmacenEntity almacen) {
        this.almacen = almacen;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CategoryEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoryEntity categoria) {
        this.categoria = categoria;
    }
    
}
