package mx.edu.uaz.ie.is.poo2;

import java.util.logging.*;
import java.sql.*;

public class TablaCliente {
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
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tablas/Clientes2024.db");

            // Inicialización del Statement
            Statement statement = connection.createStatement();
            statement.executeUpdate("""
                            create table Clientes(
                            ID integer,
                            Nombre text,
                            Apellido text,
                            Edad integer,
                            Rentas integer
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
