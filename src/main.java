import model.Articulo;
import model.Compra;
import model.Usuario;
import model.Venta;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String[] args) throws InterruptedException {
        var s = new Scanner(System.in);
        boolean logeado = false;
        boolean salir = false;
        boolean cerrarSesion = false;
        int opcion, opcionSesion, escogerArticulo, opcion4;
        Usuario usuario1 = null, usuario2 = null;
        boolean usuario1Logeado = false, usuario2Logeado = false;
        String correo, contrasenia, nombre;
        boolean articuloComprado = false;

        //BIENVENIDA
        System.out.println("Bienvenido a FernanPop");
        System.out.println("Compra y vende tus articulos en nuestro centro");
        System.out.println("==============================================");
        System.out.println();

        do {
            //MENU SESION
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            opcionSesion = Integer.parseInt(s.nextLine());

            switch (opcionSesion) {
                case 1:
                    //REGISTRO
                    do { // validación de correo
                        System.out.println("Registrarse");
                        System.out.println("Nombre Completo");
                        nombre = s.nextLine();
                        System.out.println("Correo electronico");
                        correo = s.nextLine();
                        System.out.println("Ingresa una contraseña");
                        contrasenia = s.nextLine();
                        System.out.println();
                        if (!Usuario.validarCorreo(correo))
                            System.out.println("Correo invalido, vuelvelo a intentar otra vez");
                    } while (!Usuario.validarCorreo(correo));

                    //COMPROBAR USUARIO ESTA REGISTRADO
                    if (usuario1 == null) {
                        Articulo articulo1 = new Articulo(1, "Xiami Redmi Note 10", "Movil en buen estado, 128ssd  y 6gb.", 400f, 1);
                        Articulo articulo2 = new Articulo(2, "MacBook Pro 13 principios del 2019", "Portatil casi nuevo,16gb de ram y 256ssd", 5000f, 1);

                        usuario1 = new Usuario(correo, contrasenia, nombre, articulo1, articulo2);
                    } else if (usuario2 == null) {
                        Articulo articulo1 = new Articulo(1, "SMART TV LG 42' pulgadas ", "Televisor smart tv, incluye 3 puertos hdmi, full hd", 600f, 1);
                        Articulo articulo2 = new Articulo(2, "Google Chromecast", "Chromecast", 50f, 1);

                        usuario2 = new Usuario(correo, contrasenia, nombre, articulo1, articulo2);

                    } else {
                        System.out.println("De momento no se pueden registrar mas usuarios");
                    }
                    break;
                case 2:
                    //INICIO SESION
                    do {
                        System.out.print("Introduce tú correo: ");
                        correo = s.nextLine();
                        System.out.print("Introduce tú contraseña: ");
                        contrasenia = s.nextLine();

                        //Comprueba si el correo y contraseña son validos.
                        if (usuario1 != null && !logeado) {
                            if (usuario1.getCorreo().equals(correo) && usuario1.getContrasenia().equals(contrasenia)) {
                                usuario1Logeado = true;
                                logeado = true;
                                System.out.println("Bienvenido " + usuario1.getNombre());
                            }
                        }

                        if (usuario2 != null && !logeado) {
                            if (usuario2.getCorreo().equals(correo) && usuario2.getContrasenia().equals(contrasenia)) {
                                usuario2Logeado = true;
                                logeado = true;
                                System.out.println("Bienvenido " + usuario2.getNombre());
                            }
                        }

                        if ((usuario1 != null && !logeado) || (usuario2 != null && !logeado)) {
                            System.out.println("Debes registrarte primero");
                        }
                    } while (correo.isEmpty() || contrasenia.isEmpty());

                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("No ha realizado ninguna operación");
            }
            //MENÚ
            if (logeado) {
                do {
                    System.out.println("*********************************");
                    System.out.println("          Menú Usuario           ");
                    System.out.println("1.  Mostrar mi perfil de usuario");
                    System.out.println("2.  Cambiar mis datos personales");
                    System.out.println("3.  Ver mis productos en venta");
                    System.out.println("4.  Cerrar la venta de un producto o quitarlo de la venta");
                    System.out.println("5.  Poner en venta un producto");
                    System.out.println("6.  Ver todos los productos en venta de la aplicación");
                    System.out.println("7.  Ver mi historico de ventas");
                    System.out.println("8.  Ver mi historico de compras");
                    System.out.println("9.  Cerrar sesión");

                    opcion = Integer.parseInt(s.nextLine());

                    switch (opcion) {
                        case 1: //perfil usuario
                            if (usuario1Logeado) {
                                System.out.println(usuario1);
                            } else if (usuario2Logeado) {
                                System.out.println(usuario2);
                            }
                            break;
                        case 2:// editar datos
                            if (usuario1Logeado) {
                                System.out.println("Editar datos personales");
                                System.out.println("Nombre completo:");
                                usuario1.setNombre(s.nextLine());

                                do {// validación de correo
                                    System.out.println("Correo electronico:");
                                    usuario1.setCorreo(s.nextLine());
                                    if (!Usuario.validarCorreo(usuario1.getCorreo()))
                                        System.out.println("Correo no valido, vuelve a introducir");
                                } while (!Usuario.validarCorreo(usuario1.getCorreo()));

                                System.out.println("Edad:");
                                usuario1.setEdad(23);
                                System.out.println("Móvil:");
                                usuario1.setMovil(1313123);
                                System.out.println("Dirección: ");
                                usuario1.setDirrecion("romero 7 martos");
                            } else if (usuario2Logeado) {
                                System.out.println("Editar datos personales");
                                System.out.println("Nombre completo:");
                                usuario2.setNombre(s.nextLine());

                                do { //validación de correo
                                    System.out.println("Correo electronico:");
                                    usuario2.setCorreo(s.nextLine());
                                    if (!Usuario.validarCorreo(usuario2.getCorreo()))
                                        System.out.println("Correo no valido, vuelve a introducir");
                                } while (!Usuario.validarCorreo(usuario2.getCorreo()));

                                System.out.println("Edad:");
                                usuario2.setEdad(23);
                                System.out.println("Móvil:");
                                usuario2.setMovil(1313123);
                                System.out.println("Dirección: ");
                                usuario2.setDirrecion("romero 7 martos");
                            }

                            break;
                        case 3:
                            //Mostrar articulos que estan en venta.
                            if (usuario1Logeado) {
                                //Comprueba que el usuario se haya puesto en venta una articulo.
                                if (usuario1.getVenta() != null) {
                                    //Si el articulo se ha comprado te printea.
                                    if(articuloComprado) {
                                        System.out.println("Tus artículos ya no estan en venta");
                                    } else {
                                        if (usuario1.isArticulo1EnVenta()) {
                                            System.out.println("Tus Articulos en venta son: ");
                                            System.out.println("============================");
                                            System.out.println(usuario1.getArticulo1());
                                        }

                                        if (usuario1.isArticulo2EnVenta()) {
                                            System.out.println("Tus Articulos en venta son: ");
                                            System.out.println("============================");
                                            System.out.println(usuario1.getArticulo2());
                                        }
                                    }
                                } else {
                                    System.out.println("No hay artículos en venta");
                                }

                            } else if (usuario2Logeado) {
                                //Comprueba que el usuario se haya puesto en venta.
                                if (usuario2.getVenta() != null) {
                                    //Si el articulo se ha comprado te printea.
                                    if (articuloComprado) {
                                        System.out.println("Tus artículos ya no estan en venta");
                                    } else {
                                        if (usuario1.isArticulo1EnVenta()) {
                                            System.out.println("Tus Articulos en venta son: ");
                                            System.out.println("============================");
                                            System.out.println(usuario1.getArticulo1());
                                        }

                                        if (usuario1.isArticulo2EnVenta()) {
                                            System.out.println("Tus Articulos en venta son: ");
                                            System.out.println("============================");
                                            System.out.println(usuario1.getArticulo2());
                                        }
                                    }
                                } else {
                                    System.out.println("No hay artículos en venta");
                                }
                            }

                            break;
                        case 4:
                            //Cerrar venta o quitar
                            if (usuario1Logeado) {
                                //Comprueba si cualquiera de los dos articulos se han vendido.
                                if (usuario1.isArticulo1EnVenta() || usuario1.isArticulo2EnVenta()) {
                                    //menu que operacion desea hacer
                                    System.out.println("Cerrar la venta de un producto o quitarlo de la venta");
                                    System.out.println("1. Cerrar Venta");
                                    System.out.println("2. Quitar Venta");
                                    opcion4 = Integer.parseInt(s.nextLine());

                                    switch (opcion4) {
                                        case 1:
                                            //Comprueba que que haya mas de un usuario registrado
                                            if (usuario2 != null) {
                                                // Si la compra del usuario esta vacia se realiza el cierre de venta.
                                                if (usuario2.getCompra() == null) {
                                                    //Mostrara el articulo que haya sido puesto en venta.
                                                    if (usuario1.isArticulo1EnVenta()) {
                                                        System.out.println("El artículo en venta es:");
                                                        System.out.println(usuario1.getArticulo1());

                                                        System.out.println("Deseas venderlo");
                                                        String comprarArticulo = s.nextLine();

                                                        if (comprarArticulo.equalsIgnoreCase("si")) {
                                                            Articulo articuloAVender = usuario1.getArticulo1();
                                                            System.out.println("Ingresa un comentario que se mostrara en tú articulo");
                                                            String comentario = s.nextLine();
                                                            //VENTA AL USUARIO usuario2 (usuario comprador) -> El usuario2 compra tu artículo
                                                            Venta vendiendoArticulo = new Venta(articuloAVender, articuloAVender.getPrecio(), comentario, usuario1.mostrarFecha(), usuario2);
                                                            usuario1.setVenta(vendiendoArticulo);

                                                            //COMPRA AL USUARIO usuario1 (usuario vendedor) -> tu estas vendiendo tu artículo
                                                            Compra comprandoArticulo = new Compra(articuloAVender, articuloAVender.getPrecio(), usuario1.mostrarFecha(), usuario1);
                                                            usuario2.setCompra(comprandoArticulo);
                                                            //Colocamos el artículo como comprado.
                                                            articuloComprado = true;

                                                        } else {
                                                            System.out.println("Nos has vendido ningún artículo");
                                                        }
                                                    }

                                                    if (usuario1.isArticulo2EnVenta()) {
                                                        System.out.println("El artículo en venta es:");
                                                        System.out.println(usuario1.getArticulo2());

                                                        System.out.println("Deseas venderlo");
                                                        String comprarArticulo = s.nextLine();

                                                        if (comprarArticulo.equalsIgnoreCase("si")) {
                                                            Articulo articuloAVender = usuario1.getArticulo2();
                                                            System.out.println("Ingresa un comentario que se mostrara en tú articulo");
                                                            String comentario = s.nextLine();

                                                            //VENTA AL USUARIO : usuario2 (usuario comprador) -> El usuario2 compra tu artículo
                                                            Venta vendiendoArticulo = new Venta(articuloAVender, articuloAVender.getPrecio(), comentario, usuario1.mostrarFecha(), usuario2);
                                                            usuario1.setVenta(vendiendoArticulo);

                                                            //COMPRA AL USUARIO:  usuario1 (usuario vendedor) -> tu estas vendiendo tu artículo
                                                            Compra comprandoArticulo = new Compra(articuloAVender, articuloAVender.getPrecio(), usuario1.mostrarFecha(), usuario1);
                                                            usuario2.setCompra(comprandoArticulo);
                                                            //Colocamos el artículo como comprado.
                                                            articuloComprado = true;

                                                        } else {
                                                            System.out.println("Nos has vendido ningún artículo");
                                                        }
                                                    }

                                                } else {
                                                    System.out.println("Ya cerraste una venta,por favor vuelve a vender otro articulo");
                                                }
                                            } else {
                                                System.out.println("No se puede cerrar una venta ya que no hay ningún usuario disponible por el momento.");
                                            }

                                            break;
                                        case 2:
                                            //Quitara el articulo que este puesto en venta.
                                            System.out.println("Quitar articulo");
                                            if (usuario1.isArticulo1EnVenta()) {
                                                System.out.println(usuario1.getArticulo1());
                                                usuario1.setArticulo1EnVenta(false);
                                                System.out.print("Quitando articulo ");
                                                for (int i = 0; i < 3; i++) {
                                                    System.out.print(".");
                                                    TimeUnit.SECONDS.sleep(1);
                                                }

                                            }

                                            if (usuario1.isArticulo2EnVenta()) {
                                                System.out.println(usuario1.getArticulo2());
                                                usuario1.setArticulo2EnVenta(false);
                                                System.out.print("Quitando articulo ");
                                                for (int i = 0; i < 3; i++) {
                                                    System.out.print(".");
                                                    TimeUnit.SECONDS.sleep(1);
                                                }

                                            }

                                            break;
                                        default:
                                            System.out.println("Nos has selecionado ninguna opción");
                                    }
                                } else {
                                    System.out.println("No hay ningún articulo en venta disponible");
                                }

                            } else if (usuario2Logeado) {

                                //Comprueba si cualquiera de los dos articulos se han vendido.
                                if (usuario2.isArticulo1EnVenta() || usuario2.isArticulo2EnVenta()) {
                                    System.out.println("Cerrar la venta de un producto o quitarlo de la venta");
                                    System.out.println("1. Cerrar Venta");
                                    System.out.println("2. Quitar Venta");
                                    opcion4 = Integer.parseInt(s.nextLine());

                                    switch (opcion4) {
                                        case 1:
                                            //Comprueba si mas de un usuario esta registrado.
                                            if (usuario1 != null) {
                                                //Si la compra del usuario esta vacia se realiza el cierre de venta.
                                                if (usuario1.getCompra() == null) {
                                                    //Mostrara los articulos que se hayan puesto en venta.
                                                    if (usuario2.isArticulo1EnVenta()) {
                                                        System.out.println("El artículo en venta es:");
                                                        System.out.println(usuario2.getArticulo1());

                                                        System.out.println("Deseas venderlo");
                                                        String comprarArticulo = s.nextLine();

                                                        if (comprarArticulo.equalsIgnoreCase("si")) {
                                                            Articulo articuloAVender = usuario2.getArticulo1();
                                                            System.out.println("Ingresa un comentario que se mostrara en tú compra");
                                                            String comentario = s.nextLine();
                                                            //VENTA AL USUARIO:  usuario2 (usuario comprador) -> El usuario2 compra tu artículo
                                                            Venta vendiendoArticulo = new Venta(articuloAVender, articuloAVender.getPrecio(), comentario, usuario2.mostrarFecha(), usuario1);
                                                            usuario2.setVenta(vendiendoArticulo);

                                                            //COMPRA AL USUARIO:  usuario1 (usuario vendedor) -> tu estas vendiendo tu artículo
                                                            Compra comprandoArticulo = new Compra(articuloAVender, articuloAVender.getPrecio(), usuario2.mostrarFecha(), usuario2);
                                                            usuario1.setCompra(comprandoArticulo);
                                                            //Colocamos el artículo como comprado.
                                                            articuloComprado = true;

                                                        } else {
                                                            System.out.println("Nos vemos pronto");
                                                        }
                                                    }

                                                    if (usuario2.isArticulo2EnVenta()) {
                                                        System.out.println("El artículo en venta es:");
                                                        System.out.println(usuario2.getArticulo2());

                                                        System.out.println("Deseas venderlo");
                                                        String comprarArticulo = s.nextLine();

                                                        if (comprarArticulo.equalsIgnoreCase("si")) {
                                                            Articulo articuloAVender = usuario2.getArticulo2();
                                                            System.out.println("Ingresa un comentario que se mostrara en tú compra");
                                                            String comentario = s.nextLine();
                                                            //VENTA AL USUARIO:  usuario2 (usuario comprador) -> El usuario2 compra tu artículo
                                                            Venta vendiendoArticulo = new Venta(articuloAVender, articuloAVender.getPrecio(), comentario, usuario2.mostrarFecha(), usuario1);
                                                            usuario2.setVenta(vendiendoArticulo);

                                                            //COMPRA AL USUARIO:  usuario1 (usuario vendedor) -> tu estas vendiendo tu artículo
                                                            Compra comprandoArticulo = new Compra(articuloAVender, articuloAVender.getPrecio(), usuario2.mostrarFecha(), usuario2);
                                                            usuario1.setCompra(comprandoArticulo);
                                                            //Colocamos el artículo como comprado.
                                                            articuloComprado = true;

                                                        } else {
                                                            System.out.println("Nos vemos pronto");
                                                        }
                                                    }

                                                } else {
                                                    System.out.println("Ya cerraste una venta,por favor vuelve a vender otro articulo");
                                                }
                                            } else {
                                                System.out.println("No se puede cerrar una venta ya que no hay ningún usuario disponible por el momento.");
                                            }
                                            break;
                                        case 2:
                                            //Quitara el articulo que se haya puesto en venta.
                                            System.out.println("Quitar articulo");
                                            if (usuario2.isArticulo1EnVenta()) {
                                                System.out.println(usuario2.getArticulo1());
                                                usuario2.setArticulo1EnVenta(false);
                                                System.out.print("Quitando articulo ");
                                                for (int i = 0; i < 3; i++) {
                                                    System.out.print(".");
                                                    TimeUnit.SECONDS.sleep(1);
                                                }

                                            }

                                            if (usuario2.isArticulo2EnVenta()) {
                                                System.out.println(usuario2.getArticulo2());
                                                usuario2.setArticulo2EnVenta(false);
                                                System.out.print("Quitando articulo ");
                                                for (int i = 0; i < 3; i++) {
                                                    System.out.print(".");
                                                    TimeUnit.SECONDS.sleep(1);
                                                }

                                            }
                                            break;
                                        default:
                                            System.out.println("No has seleccionado ninguna opción");
                                    }
                                } else {
                                    System.out.println("No hay nigún articulo en venta disponible");
                                }

                            }
                            break;
                        case 5:
                            //Comprobar usuario logeado
                            if (usuario1Logeado) {

                                //Mostrar los articulos al usuario
                                System.out.println("Tus Articulos: ");
                                System.out.println("Pon en venta un articulo");
                                System.out.println("Selecciona que articulo, 1 o 2: ");
                                System.out.println("============================");
                                System.out.println(usuario1.getArticulo1());
                                System.out.println();
                                System.out.println("============================");
                                System.out.println(usuario1.getArticulo2());
                                System.out.println();
                                System.out.println("¿Que articulo vas a vender?");
                                escogerArticulo = Integer.parseInt(s.nextLine());

                                if (!usuario1.isArticulo1EnVenta() && !usuario1.isArticulo2EnVenta()) {//comprueba si el articulo esta en venta.
                                    //Seleccionar los articulos que quiera vender.
                                    if (escogerArticulo == 1) {
                                        Venta ventaUsuario1 = new Venta(usuario1.getArticulo1(), usuario1.getArticulo1().getPrecio(), "Venta de prueba", usuario1.mostrarFecha(), usuario2);
                                        usuario1.setVenta(ventaUsuario1);
                                        usuario1.setArticulo1EnVenta(true);

                                    } else if (escogerArticulo == 2) {
                                        Venta ventaUsuario1 = new Venta(usuario1.getArticulo2(), usuario1.getArticulo2().getPrecio(), "Venta en buen estado", usuario1.mostrarFecha(), usuario2);
                                        usuario1.setVenta(ventaUsuario1);
                                        usuario1.setArticulo2EnVenta(true);

                                    } else System.out.println("Nos has escogido ninguna opcion");

                                } else System.out.println("No se pueden vender mas articulos");

                            } else if (usuario2Logeado) {

                                //Mostrar los articulos al usuario
                                System.out.println("Tus Articulos: ");
                                System.out.println("Pon en venta un articulo");
                                System.out.println("Selecciona que articulo, 1 o 2: ");
                                System.out.println("============================");
                                System.out.println(usuario2.getArticulo1());
                                System.out.println();
                                System.out.println("============================");
                                System.out.println(usuario2.getArticulo2());
                                System.out.println();
                                System.out.println("¿Que articulo vas a vender?");
                                escogerArticulo = Integer.parseInt(s.nextLine());

                                if (!usuario2.isArticulo1EnVenta() && !usuario2.isArticulo2EnVenta()) {//comprueba si el articulo esta en venta.
                                    //Seleccionar los articulos que quiera vender.
                                    if (escogerArticulo == 1) {
                                        Venta ventaUsuario2 = new Venta(usuario2.getArticulo1(), usuario2.getArticulo1().getPrecio(), "Producto al alacanze de tu bolsillo", usuario2.mostrarFecha(), usuario1);
                                        usuario2.setVenta(ventaUsuario2);
                                        usuario2.setArticulo1EnVenta(true);

                                    } else if (escogerArticulo == 2) {
                                        Venta ventaUsuario2 = new Venta(usuario2.getArticulo2(), usuario2.getArticulo2().getPrecio(), "Disponible en todos lo modelos", usuario2.mostrarFecha(), usuario1);
                                        usuario2.setVenta(ventaUsuario2);
                                        usuario2.setArticulo2EnVenta(true);

                                    } else System.out.println("Nos has escogido ninguna opcion");

                                } else System.out.println("No se pueden vender mas articulos");
                            }

                            break;
                        case 6:
                                //Si el usuario ha puesto en venta un articulo se muestra.
                                if(usuario1.getVenta() != null) {
                                    System.out.println("Articulos en venta: ");
                                    if (usuario1.isArticulo1EnVenta()) {
                                        System.out.println(usuario1.getArticulo1());
                                    } else if (usuario1.isArticulo2EnVenta()) {
                                        System.out.println(usuario1.getArticulo2());
                                    }
                                } else {
                                    System.out.println("De momento no se encuentran ningún artículo en venta");
                                }

                                //Compruebo si el usuario 2 esta registrado.
                                if (usuario2 != null) {
                                    //Si el usuario ha puesto en venta un articulo lo muestra.
                                    if (usuario2.getVenta() != null) {
                                        if (usuario2.isArticulo1EnVenta()) {
                                            System.out.println(usuario2.getArticulo1());
                                        } else if (usuario2.isArticulo2EnVenta()) {
                                            System.out.println(usuario2.getArticulo2());
                                        }
                                    }
                                }


                            break;
                        case 7:
                            if (usuario1Logeado) {
                                if (usuario2 != null) {
                                    boolean enVenta = false;
                                    //Comprueba que hayas realizado un cierre de venta y hayas generado la compra al otro usuario.
                                    if (usuario1.getVenta() != null && usuario2.getCompra() != null) {
                                        System.out.println("Historico de Ventas: ");
                                        System.out.println("El artículo vendido es: ");
                                        System.out.println(usuario1.getVenta());
                                        System.out.println("Pulsa una tecla para continuar");
                                        s.nextLine();

                                        enVenta = true;
                                    }

                                    //Si no esta en venta, no se muestra.
                                    if (!enVenta) {
                                        System.out.println("No tienes ningún artículo en venta");
                                    }
                                } else {
                                    System.out.println("No se puede mostrar ninguna venta, mientras no hayas cerrado una.");
                                }
                            } else if (usuario2Logeado) {
                                boolean enVenta = false;
                                //Comprueba que hayas realizado un cierre de venta y hayas generado la compra al otro usuario.
                                if (usuario2.getVenta() != null && usuario1.getCompra() != null) {
                                    System.out.println("Historico de Ventas: ");
                                    System.out.println("El artículo vendido es: ");
                                    System.out.println(usuario2.getVenta());
                                    System.out.println("Pulsa una tecla para continuar");
                                    s.nextLine();

                                    enVenta = true;
                                }

                                //Si no esta en venta, no se muestra.
                                if (!enVenta) {
                                    System.out.println("No tienes ningún artículo en venta");
                                }
                            }

                            break;
                        case 8:
                            if (usuario1Logeado) {
                                boolean comprado = false;

                                //Comprobar si he comprado algo.
                                if (usuario1.getCompra() != null) {
                                    if (usuario1.getCompra().getComentario() == null && usuario1.getCompra().getPuntuacion() == 0) {
                                        System.out.println("Historico de compras");
                                        System.out.println("El articulo comprado es: ");
                                        System.out.println(usuario1.getCompra());
                                        System.out.println("Gracias por tu compra, por favor añade un comentario y puntuación");
                                        System.out.println("Añade un comentario");
                                        usuario1.getCompra().setComentario(s.nextLine());
                                        System.out.println("Añade una puntuacion");
                                        usuario1.getCompra().setPuntuacion(Float.parseFloat(s.nextLine()));
                                    } else {
                                        System.out.println("Historico de compras");
                                        System.out.println("El articulo comprado es: ");
                                        System.out.println(usuario1.getCompra());
                                        System.out.println("Gracias por tú compra");
                                    }

                                    comprado = true;
                                }

                                if (!comprado) {
                                    System.out.println("No has comprado ningún articulo");
                                }


                            } else if (usuario2Logeado) {
                                boolean comprado = false;

                                //Comprobar si he comprado algo
                                if (usuario2.getCompra() != null) {
                                    if (usuario2.getCompra().getComentario() == null && usuario2.getCompra().getPuntuacion() == 0) {
                                        System.out.println("Historico de compras");
                                        System.out.println("El articulo comprado es: ");
                                        System.out.println(usuario2.getCompra());
                                        System.out.println("Gracias por tu compra, por favor añade un comentario y puntuación");
                                        System.out.println("Añade un comentario");
                                        usuario2.getCompra().setComentario(s.nextLine());
                                        System.out.println("Añade una puntuacion");
                                        usuario2.getCompra().setPuntuacion(Float.parseFloat(s.nextLine()));
                                    } else {
                                        System.out.println("Historico de compras");
                                        System.out.println("El articulo comprado es: ");
                                        System.out.println(usuario2.getCompra());
                                        System.out.println("Gracias por tú compra");
                                    }


                                    comprado = true;
                                }

                                if (!comprado) {
                                    System.out.println("No has comprado ningún articulo");
                                }
                            }
                            break;
                        case 9:
                            if (usuario1Logeado) {
                                usuario1Logeado = false;
                            } else if (usuario2Logeado) {
                                usuario2Logeado = false;
                            }
                            logeado = false;
                            cerrarSesion = true;

                            break;
                        default:
                            System.out.println("Parametro incorrecto, seleccione una opción");
                    }
                } while (!cerrarSesion);

                cerrarSesion = false;
            }
        } while (!salir);
    }
}
