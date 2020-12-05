package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Venta {
    /**
     * Atributos
     */

    private Articulo articulo;
    private float precioFinal;
    private String comentario;
    private String fecha;
    private Usuario comprador;

    //constructor
    public Venta(Articulo articulo, float precioFinal, String comentario, String fecha, Usuario comprador) {
        this.articulo = articulo;
        this.precioFinal = precioFinal;
        this.comentario = comentario;
        this.fecha = fecha;
        this.comprador = comprador;
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
        this.precioFinal = precioFinal;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return articulo.getNombre() +
                "\n - Precio: " + precioFinal +
                "\n - Comentario del comprador: " + ((comprador.getCompra().getComentario()) == null ? "Ningún comentario por el momento." : comprador.getCompra().getComentario()) +
                "\n - Fecha de Venta: " + fecha +
                "\n - Comprado por: " + comprador.getNombre()  +
                "\n - Correo: " + comprador.getCorreo() +
                "\n - Puntuacion: " + ((comprador.getCompra().getPuntuacion()) == 0 ? "Ninguna puntuación por el momento." : comprador.getCompra().getPuntuacion());
    }
}
