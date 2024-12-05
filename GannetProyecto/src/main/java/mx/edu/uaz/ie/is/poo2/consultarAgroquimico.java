package mx.edu.uaz.ie.is.poo2;

import java.util.logging.*;
import java.sql.*;

public class consultarAgroquimico {
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

        try{
            Connection conexion;
            conexion = DriverManager.getConnection("jdbc:sqlite:tablas/Agroquimicos.db");

            Statement  sentencia;
            sentencia = conexion.createStatement();
            ResultSet rs;

            rs = sentencia.executeQuery("""
                               select * from Agroquimicos
                               where precio >= 1000
                               """);
            while(rs.next()){
                String nombre;
                String categoria;
                int cantidad;
                int precio;
             
                nombre = rs.getString("nombre");
                categoria = rs.getString("categoria");
                cantidad = rs.getInt("cantidad");
                precio = rs.getInt("precio");
                
                System.out.println("Nombre = "+ nombre +
                        ", Categoria = " + categoria +
                        ", cantidad = "+cantidad+
                        ", Precio = "+precio);
            }
            sentencia.close();
            conexion.close();
        }catch(Exception e){
            logger.log(Level.SEVERE,e.getMessage());
            System.exit(ARCHIVO_NO_EXISTE);
        }


    }

    
}
