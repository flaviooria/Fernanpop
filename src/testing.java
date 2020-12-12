import model.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testing {
    public static void main(String[] args) throws ParseException {
        var s = new Scanner(System.in);
        Usuario user1 = null;
        String correo = null;
        String contrasenia = null;

        //probando correo trayendo el metodo validarCorreo()
        do {
            System.out.println("Indica nombre");
            String nombre = s.nextLine();
            System.out.println("indica correo");
            correo = s.nextLine();
            System.out.println("indica contraseña");
            contrasenia = s.nextLine();
            user1 = new Usuario(correo, contrasenia, nombre);
            Usuario.validarCorreo(correo);
            System.out.println(Usuario.validarCorreo(correo) ? "correo valido" : "correo no valido");
        } while (!Usuario.validarCorreo(correo));

        System.out.println(user1);

        //Probando fecha trayendo el metoodo mostrarFecha()
//        System.out.println("la fecha actual es: " + user1.mostrarFecha());

        /* Esto lo utilizo en el metodo mostra fecha de esta forma tambien puede imprimir tu fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Calendar fechaActual =  new GregorianCalendar();
        sdf.setTimeZone(fechaActual.getTimeZone());
        System.out.println(sdf.format(fechaActual.getTime()));*/


        /* Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        String email = "flavio@dev.com";
        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
        }
    }

        Otro metodo sin clases pattern y mather
        String correo = "flavio";
        int longitud = correo.length();
        char arroba = '@';
        char valor;

        for (char i = 0; i < longitud; i++) {
            valor = correo.charAt(i);
            if (valor == '@' && i == 0) {
                System.out.println("El correo esta mal");
                break;
            }
            if (valor == '@') {
                System.out.println("Escribistes perfectamente el correo");
                break;
            } else if (i == longitud - 1) {
                System.out.println("El correo esta mal");
                break;

            }
        }*/


    }
}
