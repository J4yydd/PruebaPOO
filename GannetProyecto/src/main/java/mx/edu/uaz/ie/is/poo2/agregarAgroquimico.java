package mx.edu.uaz.ie.is.poo2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class agregarAgroquimico {
    public final static int BASE_DE_DATOS_NO_ENCONTRADA = 1;
    public final static int ARCHIVO_INEXISTENTE = 2;

    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "No se ha encontrado la BD", e);
            System.exit(BASE_DE_DATOS_NO_ENCONTRADA);
        }
        logger.log(Level.INFO,"Clase cargada");

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tablas/Agroquimicos.db");

            // Inicialización del Statement
            Statement sentencia = connection.createStatement();

            sentencia.executeUpdate("""
                            insert into Agroquimicos ( idAgroquimico , Nombre , Categoria ,Precio ,cantidad )
                            values ( '1','Flex','herbicida',850,56);
                           """);
            sentencia.executeUpdate("""
                            insert into Agroquimicos ( idAgroquimico , Nombre , Categoria ,Precio ,cantidad )
                            values ( '2','verango','fungicida',7500,13);
                           """);
            sentencia.executeUpdate("""
                            insert into Agroquimicos ( idAgroquimico , Nombre , Categoria ,Precio ,cantidad )
                            values ( '3','minectoDuo','fungicida',6700,34);
                           """);
            



            sentencia.close();
            connection.close();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear la BD", e);
            System.exit(ARCHIVO_INEXISTENTE);
        }
    }

    
}
