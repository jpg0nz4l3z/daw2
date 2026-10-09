package org.daw2.practicas_entorno_servidor.practica3introduccionspring.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductoDTO {
    private String nombre;
    private double precio;
    private boolean disponible;
    // Constructor vacío
    //public ProductoDTO() {}
    // Constructor completo
    /*public ProductoDTO(String nombre, double precio, boolean disponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }/
    // Getters y Setters
    /*public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }*/
}