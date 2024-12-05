package mx.edu.uaz.ie.is.poo2;  
import java.util.Scanner;
import java.util.logging.*;
import java.sql.*;

public class MenuAgroquimicos {
  



    public static final int CLASE_NO_CARGADA = 1;
    public static final int ARCHIVO_NO_EXISTE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getAnonymousLogger();

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "No se pudo cargar la clase");
            System.exit(CLASE_NO_CARGADA);
        }
        logger.log(Level.INFO, "Clase cargada correctamente");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Agroquímicos ---");
            System.out.println("1. Agregar agroquímico");
            System.out.println("2. Consultar agroquímicos");
            System.out.println("3. Borrar agroquímico");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarAgroquimico();
                    break;
                case 2:
                    consultarAgroquimicos();
                    break;
                case 3:
                    borrarAgroquimico();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void agregarAgroquimico() {
        Logger logger = Logger.getAnonymousLogger();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:tablas/Agroquimicos.db");
            Statement statement = connection.createStatement();

            statement.executeUpdate("""
                            insert into Agroquimicos (idAgroquimico, Nombre, Categoria, Precio, cantidad)
                            values ('1', 'Flex', 'herbicida', 850, 56);
                           """);

            statement.executeUpdate("""
                            insert into Agroquimicos (idAgroquimico, Nombre, Categoria, Precio, cantidad)
                            values ('2', 'verango', 'fungicida', 7500, 13);
                           """);

            statement.executeUpdate("""
                            insert into Agroquimicos (idAgroquimico, Nombre, Categoria, Precio, cantidad)
                            values ('3', 'minectoDuo', 'fungicida', 6700, 34);
                           """);

            statement.close();
            connection.close();
            System.out.println("Agroquímicos agregados con éxito.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al agregar el agroquímico", e);
            System.exit(ARCHIVO_NO_EXISTE);
        }
    }

    private static void consultarAgroquimicos() {
        Logger logger = Logger.getAnonymousLogger();
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:tablas/Agroquimicos.db");
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("""
                               select * from Agroquimicos
                               where precio >= 1000
                               """);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                int cantidad = rs.getInt("cantidad");
                int precio = rs.getInt("precio");

                System.out.println("Nombre = " + nombre +
                        ", Categoria = " + categoria +
                        ", cantidad = " + cantidad +
                        ", Precio = " + precio);
            }

            sentencia.close();
            conexion.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(ARCHIVO_NO_EXISTE);
        }
    }

    private static void borrarAgroquimico() {
        Logger logger = Logger.getAnonymousLogger();
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:tablas/Agroquimicos.db");
            Statement sentencia = conexion.createStatement();

            sentencia.executeUpdate("""
                               delete from Agroquimicos
                               where nombre = 'verango'
                               """);

            sentencia.close();
            conexion.close();
            System.out.println("Agroquímico borrado con éxito.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(ARCHIVO_NO_EXISTE);
        }
    }
    
}


