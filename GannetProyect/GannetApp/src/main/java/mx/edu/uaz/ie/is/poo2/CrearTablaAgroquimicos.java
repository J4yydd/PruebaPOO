package mx.edu.uaz.ie.is.poo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CrearTablaAgroquimicos {

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
            Statement statement = connection.createStatement();
            statement.executeUpdate("""
                            create table Agroquimicos(
                            ID text,
                            Nombre text,
                            Categoria text,
                            Copias int,
                            Precio int,
                            Status int
                            )
                            """);
            statement.close();
            connection.close();

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al crear la BD", e);
            System.exit(ARCHIVO_INEXISTENTE);
        }
    }
}
