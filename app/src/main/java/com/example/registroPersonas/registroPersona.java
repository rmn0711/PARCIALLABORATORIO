package com.example.registroPersonas;

public class registroPersona {

    public String cedula;
    public String nombre;
    public String estrato;
    public String salario;
    public String nivel;

    public registroPersona(String cedula, String nombre, String estrato, String salario, String nivel) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.nivel = nivel;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "registroPersona{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", estrato='" + estrato + '\'' +
                ", salario='" + salario + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }


}
