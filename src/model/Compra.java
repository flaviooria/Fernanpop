package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Compra {
    /**
     * Atributos
     */

    private Articulo articulo;
    private float precioFinal;
    private float puntuacion;
    private String comentario;
    private String fecha;
    private Usuario vendedor;

    //constructor


    public Compra(Articulo articulo, float precioFinal, String fecha, Usuario vendedor) {
        this.articulo = articulo;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
        this.vendedor = vendedor;
    }

    /**
     * Metodos
     */

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = articulo.getPrecio() * 1.21f;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return  articulo.getNombre() +
                "\n - Precio: " + precioFinal +
                "\n - Comentario: " + ((vendedor.getVenta().getComentario()) == null ? "Ningún comentario por el momento" : vendedor.getVenta().getComentario()) +
                "\n - Valoración: " + (vendedor.getVenta().getComprador().getCompra().getPuntuacion() == 0 ? "Ninguna puntuacion por el momento" : vendedor.getVenta().getComprador().getCompra().getPuntuacion())  +
                "\n - Fecha: " + fecha  +
                "\n - Vendido por: " + vendedor.getNombre() +
                "\n - Correo: " + vendedor.getCorreo();
    }
}