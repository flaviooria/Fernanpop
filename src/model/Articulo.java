package model;

public class Articulo {
    /**
     * Atributos
     */

    private int articuloId;
    private String nombre;
    private String descrip;
    private float precio;
    private int cantidad;

    /**
     * Constructor
     * @param nombre
     * @param descrip
     * @param precio
     * @param cantidad
     */
    public Articulo( String nombre, String descrip, float precio, int cantidad) {
        this.articuloId = articuloId;
        this.nombre = nombre;
        this.descrip = descrip;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Metodos
     */

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return  nombre +
                "\n - Descripición: " + descrip +
                "\n - Precio: " + precio + " €" +
                "\n - Cantidad: " + cantidad;
    }
}
