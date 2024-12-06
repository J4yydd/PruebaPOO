package mx.edu.uaz.ie.is.poo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("proyecto gannet");

        

        while (true) {
            System.out.println("""
                    -------------------------------------
                    Menu
                    1.- Agregar agroquimico
                    2.- Consultar agroquimico
                    3.- Actualizar agroquimico
                    4.- Eliminar agroquimico
                    5.- Salir del programa
                    -------------------------------------
                    """);
            int seleccion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
        

            switch (seleccion) {
                case 1 -> agregarAgroquimico();
                case 2 -> consultarAgroquimico();
                case 3 -> actualizarAgroquimico();
                case 4 -> eliminarAgroquimico();
                case 5 -> {
                    System.out.println("Se ha salido exitosamente del programa.");
                    System.exit(0);
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private static void agregarAgroquimico() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Tablas/Agroquimicos.db")) {
            System.out.print("Ingrese el nombre del Agroquimico: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la categoría del  Agroquimico: ");
            String categoria = scanner.nextLine();
            System.out.print("Ingrese el precio del Agroquimico: ");
            int precio = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            String query = "INSERT INTO Agroquimicos (nombre, categoria, precio, copias, status) VALUES (?, ?, ?, 1, 1)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, categoria);
                preparedStatement.setInt(3, precio);
                preparedStatement.executeUpdate();
                System.out.println("Ageoquimico agregado exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al agregar el Agroquimico: " + e.getMessage());
        }
    }

    private static void consultarAgroquimico() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Tablas/Agroquimicos.db")) {
            System.out.print("Ingrese el nombre del agroquimico que desea consultar: ");
            String nombre = scanner.nextLine();

            String query = "SELECT nombre, categoria, precio FROM Agroquimicos WHERE nombre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Nombre: " + resultSet.getString("nombre"));
                        System.out.println("Categoría: " + resultSet.getString("categoria"));
                        System.out.println("Precio: " + resultSet.getInt("precio") );
                    } else {
                        System.out.println("Agroquimco  no encontrado.");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el agroquimico: " + e.getMessage());
        }
    }

    private static void actualizarAgroquimico() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Tablas/Agroquimicos.db")) {
            System.out.print("Ingrese el nombre del agroquimico que desea actualizar: ");
            String nombre = scanner.nextLine();

            String query = "SELECT nombre FROM Agroquimicos WHERE nombre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.print("Ingrese la nueva categoría: ");
                        String nuevaCategoria = scanner.nextLine();
                        System.out.print("Ingrese el nuevo precio: ");
                        int nuevoPrecio = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        query = "UPDATE Agroquimicos SET categoria = ?, precio = ? WHERE nombre = ?";
                        try (PreparedStatement updateStatement = connection.prepareStatement(query)) {
                            updateStatement.setString(1, nuevaCategoria);
                            updateStatement.setInt(2, nuevoPrecio);
                            updateStatement.setString(3, nombre);
                            updateStatement.executeUpdate();
                            System.out.println("Agroquimico actualizado exitosamente.");
                        }

                    } else {
                        System.out.println("Agroquimico no encontrado.");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el Agroquimico: " + e.getMessage());
        }
    }

    private static void eliminarAgroquimico() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Tablas/Agroquimicos.db")) {
            System.out.print("Ingrese el nombre del Agroquimico que desea eliminar: ");
            String nombre = scanner.nextLine();

            String query = "DELETE FROM Agroquimicos WHERE nombre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nombre);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Agroquimico eliminado exitosamente.");
                } else {
                    System.out.println("Agroquimico no encontrado.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el Agroquimico: " + e.getMessage());
        }
    }
}
