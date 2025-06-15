/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidadesJPA;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Jose_Bueno
 */
@Entity
public class Empleado implements Serializable {

    /**
     * Identificador único de empleado. Longitud máxima: 4 caracteres.
     */
    @Id
    @Column(name = "id_empleado", length = 4)
    private String idEmpleado;

    /**
     * Nombre del empleado. Longitud máxima: 40 caracteres. No puede ser nula.
     */
    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    /**
     * Sección a la que pertenece el empleado. Asociación muchos-a-uno con la
     * entidad {@link Seccion}.
     */
    @ManyToOne
    @JoinColumn(name = "id_seccion", nullable = false)
    private Seccion seccion;

    /**
     * Salario anual. No puede ser nulo. Precisión de hasta 6 dígitos con 2
     * decimales.
     */
    @Column(name = "salario_anual", precision = 6, scale = 2, nullable = false)
    private int salarioAnual;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Empleado() {
    }

    /**
     * Constructor completo para crear un nuevo empleado con todos los
     * atributos.
     *
     * @param idEmpleado Identificador del empleado
     * @param nombre Nombre del empleado
     * @param seccion Sección a la que pertenece
     * @param salarioAnual Salario anual del empleado
     */
    public Empleado(String idEmpleado, String nombre, Seccion seccion, Integer salarioAnual) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.seccion = seccion;
        this.salarioAnual = salarioAnual;
    }

    /**
     * Devuelve el identificador del empleado.
     *
     * @return ID del empleado
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el identificador del empleado.
     *
     * @param idEmpleado Nuevo ID del empleado
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la sección asociada al empleado.
     *
     * @return Sección del empleado
     */
    public Seccion getSeccion() {
        return seccion;
    }

    /**
     * Establece la sección del empleado.
     *
     * @param seccion Nueva sección asociada
     */
    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    /**
     * Devuelve salario anual del empleado.
     *
     * @return Salario anual empleado
     */
    public int getSalarioAnual() {
        return salarioAnual;
    }

    /**
     * Establece el salario anual del empleado.
     *
     * @param salarioAnual Nuevo salario anual
     */
    public void setSalarioAnual(int salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    /**
     * Devuelve una representación en texto del empleado.
     *
     * @return Cadena con los datos del empleado
     */
    @Override
    public String toString() {
        return this.getIdEmpleado() + " "
                + this.getNombre() + " "
                + this.getSeccion().toString()
                + this.getSalarioAnual() + " ";
    }

}
