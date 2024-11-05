import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        /**
         * Crea una lista de personas para realizar las validaciones.
         * Puedes agregar más personas a esta lista según tus necesidades.
         */
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Pedro", "45632546C", "pedrojcaste@gmail.com"));
        personas.add(new Persona("juan1", "95732546X", "juan78@gmail.es"));
        personas.add(new Persona("Pepe0", "15732526J", "pepito@hotmail.com"));
        personas.add(new Persona("Diego", "85712576X", "Diego034@gmail.com"));
        personas.add(new  Persona("Raul", "357453043P", "Raulito@hotmail.es"));

        /**
         * Define patrones de expresiones regulares para validar los datos.
         * Estos patrones pueden ajustarse según tus necesidades específicas.
         */
        Pattern namePattern = Pattern.compile("^[a-zA-Z]+");
        Pattern dniPattern = Pattern.compile("\\d{8}[A-Z]");
        Pattern correoPattern = Pattern.compile("[a-zA-Z0-9]*@gmail.(com|es)");

        /**
         * Crea predicados para validar el nombre, DNI y correo electrónico de cada persona.
         */
        Predicate<Persona> nameValid = persona -> namePattern.matcher(persona.getNombre()).matches();
        Predicate<Persona> dniValid = persona -> dniPattern.matcher(persona.getDni()).matches();
        Predicate<Persona> correoValid = persona -> correoPattern.matcher(persona.getCorreo()).matches();

        /**
         * Define una acción para imprimir los errores de validación de una persona.
         */
        Consumer<Persona> imprimirErrores = persona -> {
            System.out.print("La persona " + persona + " tiene los siguientes errores: ");
            if (!nameValid.test(persona)) {
                System.out.print("Nombre inválido, ");
            }
            if (!dniValid.test(persona)) {
                System.out.print("DNI inválido, ");
            }
            if (!correoValid.test(persona)) {
                System.out.print("Correo electrónico inválido, ");
            }
            System.out.println();
        };

        /**
         * Filtra la lista de personas y aplica el consumidor `imprimirErrores`
         * a aquellas que no pasen todas las validaciones.
         */
        personas.stream().filter(persona -> !esValido(persona, nameValid, dniValid, correoValid)).forEach(imprimirErrores);
    }

    /**
     * Determina si una persona es válida según los criterios establecidos.
     *
     * @param persona La persona a validar.
     * @param nameValid Predicado para validar el nombre.
     * @param dniValid Predicado para validar el DNI.
     * @param correoValid Predicado para validar el correo electrónico.
     * @return `true` si la persona es válida, `false` en caso contrario.
     */
    public static boolean esValido(Persona persona, Predicate<Persona> nameValid,
                               Predicate<Persona> dniValid, Predicate<Persona> correoValid) {
        return nameValid.test(persona) && dniValid.test(persona) && correoValid.test(persona);
    }
}
