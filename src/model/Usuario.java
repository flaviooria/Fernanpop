package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author flaviooria
 * Clase usuario
 */
public class Usuario {

    /**
     * Atributos
     */
    private String nombre;
    private String correo;
    private int usuarioId;
    private String contrasenia;
    private int edad;
    private int movil;
    private String dirrecion;
    private Articulo articulo1;
    private Articulo articulo2;
    private Compra compra;
    private Venta venta;
    private boolean articulo1EnVenta;
    private boolean articulo2EnVenta;
    private String fechaActual;


    /**
     * Constructor
     * @param email
     * @param contrasenia
     * @param nombre
     * @param articulo1
     * @param articulo2
     */
    public Usuario(String email, String contrasenia, String nombre, Articulo articulo1, Articulo articulo2) {
        this.correo = email;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.articulo1EnVenta = false;
        this.articulo2EnVenta = false;
        this.articulo1 = articulo1;
        this.articulo2 = articulo2;
    }

    public Usuario(String correo, String contrasenia, String nombre) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    /**
     *Metodos
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        if (movil > 0 && movil < 10) this.movil = movil;
        else this.movil = 0;
    }

    public String getDirrecion() {
        return dirrecion;
    }

    public void setDirrecion(String dirrecion) {
        this.dirrecion = dirrecion;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Articulo getArticulo1() {
        return articulo1;
    }

    public void setArticulo1(Articulo articulo1) {
        this.articulo1 = articulo1;
    }

    public Articulo getArticulo2() {
        return articulo2;
    }

    public void setArticulo2(Articulo articulo2) {
        this.articulo2 = articulo2;
    }

    public boolean isArticulo1EnVenta() {
        return articulo1EnVenta;
    }

    public void setArticulo1EnVenta(boolean articulo1EnVenta) {
        this.articulo1EnVenta = articulo1EnVenta;
    }

    public boolean isArticulo2EnVenta() {
        return articulo2EnVenta;
    }

    public void setArticulo2EnVenta(boolean articulo2EnVenta) {
        this.articulo2EnVenta = articulo2EnVenta;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    //otros metodos

    //metodo para validar  correo
    public static boolean validarCorreo(String correoIntroducido) {
        int longitud = correoIntroducido.length();
        char arroba = '@';
        char valor;

        for (char i = 0; i < longitud; i++) {
            valor = correoIntroducido.charAt(i);
            if (valor == arroba) {
                return true;
            } else if (i == longitud - 1) {
                return false;
            }
        }

        return true;
    }

    //metodo para mostra fecha
    public String mostrarFecha () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fechaActual =  new GregorianCalendar();
        sdf.setTimeZone(fechaActual.getTimeZone());
        return this.fechaActual = sdf.format(fechaActual.getTime());
    }

    //metodo para validar contraseña
    public static boolean validarContrasenia(String contrasenia) {
        return contrasenia.length() > 4 &&  contrasenia.length() <= 16;
    }


    @Override
    public String toString(){
        return "Datos personales: " +
                "\n  nombre: " + nombre +
                "\n  correo: " + correo +
                "\n  edad: " + ((edad == 0) ? "Campo no editado " : edad) +
                "\n  movil: " + ((movil == 0) ? "Campo no editado  " : movil) +
                "    dirrecion: " + ((dirrecion == null) ? "Campo no editado " : dirrecion);

    }
}
