package logicaJava;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

//Esta es nuestra clase entidad, la tabla en la cual se van a guardar todos los datos
//Posee un ID, los parámetros que se crearon en el front
//Y los setters y getters para poder obtener la información de manera más fácil
public class claseReservasJava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String fecha;
    private String espacio;
    private int horas;
    
    
    //Contructores pertinentes
    
    public claseReservasJava(){
        
    }
   
    public claseReservasJava(int id, String nombre, String fecha, String espacio, int horas){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.espacio = espacio;
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
