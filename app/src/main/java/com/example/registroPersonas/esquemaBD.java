package com.example.registroPersonas;

public class esquemaBD {

    public static final String nameDb = "Registros";
    public static final String tabla_registro = "registro_personas";
    public static final String columna_cedula = "cedula";
    public static final String columna_nombre = "nombre";
    public static final String columna_estrato = "estrato";
    public static final String columna_salario = "salario";
    public static final String columna_nivel = "nivel";

    public static final String create_tabla_registro = "CREATE TABLE IF NOT EXISTS " + esquemaBD.tabla_registro + " (" +
            esquemaBD.columna_cedula + " text," +
            esquemaBD.columna_nombre + " text," +
            esquemaBD.columna_estrato + " text," +
            esquemaBD.columna_salario + " text," +
            esquemaBD.columna_nivel + " text"+
            ");";

}
