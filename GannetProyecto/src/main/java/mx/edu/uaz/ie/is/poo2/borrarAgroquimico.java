package mx.edu.uaz.ie.is.poo2;
import java.util.logging.*;
import java.sql.*;

public class borrarAgroquimico {
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


            sentencia.executeUpdate("""
                               delete from Agroquimicos
                               where nombre = 'verango'
                               """);

            sentencia.close();
            conexion.close();
        }catch(Exception e){
            logger.log(Level.SEVERE,e.getMessage());
            System.exit(ARCHIVO_NO_EXISTE);
        }


    }


    
}
