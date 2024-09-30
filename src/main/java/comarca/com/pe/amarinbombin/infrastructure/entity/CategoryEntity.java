
package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCg;
    private String nombre;
    private String descripcion;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer idCg, String nombre, String descripcion) {
        this.idCg = idCg;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdCg() {
        return idCg;
    }

    public void setIdCg(Integer idCg) {
        this.idCg = idCg;
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
    
}
