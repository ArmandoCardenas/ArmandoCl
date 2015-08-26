package dev.acl.armandocl.sisinfo;

/**
 * Created by ArmandoCl on 25/08/2015.
 */
public class Profesores {
    public String Nombre;
    public String Correo;

    public Profesores(String name, String description) {
        this.Nombre = name;
        this.Correo = description;
    }


    public String getNambre()
    {
        return this.Nombre;
    }

    public String getCorreo()
    {

        return this.Correo;
    }
}
