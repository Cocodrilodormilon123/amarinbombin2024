package comarca.com.pe.amarinbombin.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idU;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String celular;
    private LocalDateTime dateCreated;
    
    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
    
    @PrePersist
    protected void onCreate() {
        dateCreated = LocalDateTime.now();
    }

    public UserEntity() {
    }

    public UserEntity(Integer idU, String nombre, String apellido, String correo, String contrasena, String celular, LocalDateTime dateCreated, TypeUser typeUser) {
        this.idU = idU;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.celular = celular;
        this.dateCreated = dateCreated;
        this.typeUser = typeUser;
    }

    

    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    
}