/**
 * Representa a una persona con un nombre, un DNI (Documento Nacional de Identidad) y un correo electrónico.
 * Esta clase encapsula la información básica de una persona y proporciona métodos para acceder y modificar sus atributos.
 */
public class Persona {

    /**
     * El nombre de la persona.
     */
    private String nombre;

    /**
     * El número de documento nacional de identidad de la persona.
     */
    private String dni;

    /**
     * El correo electrónico de la persona.
     */
    private String correo;

    /**
     * Constructor que inicializa los atributos de la persona.
     * 
     * @param nombre El nombre de la persona.
     * @param dni El DNI de la persona.
     * @param correo El correo electrónico de la persona.
     */
    public Persona(String nombre, String dni, String correo) {
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el DNI de la persona.
     * 
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     * 
     * @param dni El nuevo DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * 
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     * 
     * @param correo El nuevo correo electrónico de la persona.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
