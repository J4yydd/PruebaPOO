package mx.edu.uaz.ie.is.poo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteEliminar {

    public static final int CLASE_NO_CARGADA = 1;
    public static final int ARCHIVO_NO_EXISTE = 2;

    public static void main( String[] args )
    {
        Logger logger = Logger.getAnonymousLogger();
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            logger.log(Level.SEVERE,"No se pudo cargar la clase");
            System.exit(CLASE_NO_CARGADA);
        }
        logger.log(Level.INFO,"Si se cargo la clase");
		/*
		1- Conectar a la BD
		2- Insertar registros en la tabla
			Ejecutar una consulta SQL

		*/
        try{
            Connection conexion;
            conexion = DriverManager
                    .getConnection("jdbc:sqlite:tablas/Clientes2024.db");

            Statement  sentencia;
            sentencia = conexion.createStatement();


            sentencia.executeUpdate("""
                               delete from Clientes
                               where nombre = 'Ana'
                               """);

            sentencia.close();
            conexion.close();
        }catch(Exception e){
            logger.log(Level.SEVERE,e.getMessage());
            System.exit(ARCHIVO_NO_EXISTE);
        }


    }
}

