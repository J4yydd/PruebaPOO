# **CRUD de Agroquímicos**

Este proyecto es una aplicación  para gestionar agroquímicos. Está desarrollado en Java con JPA, y utiliza MySQL como base de datos.
la Base de datos se encuentra en un server phpMyAdmin, nosostros utilizamos wampsServer para accceder a phpMyAdmin.

---

## **Requisitos Previos**
Antes de empezar, asegúrate de tener lo siguiente instalado en tu máquina:
1. **Java** (versión 11 o superior).
2. **Maven** (versión 3.6 o superior).
3. **WampServer** (o cualquier servidor con MySQL y phpMyAdmin).
4. Un editor de texto o IDE (usamos  NetBeans23).

---

## **Estructura del Proyecto**
El repositorio tiene la siguiente estructura:


gannetApp
├── DataBase/
├── infoImportar/             #tenemos un exel que muestra una tabla de agroquimicos para importar en el programa.
│   └── gannetbase.sql        # Script SQL para crear la base de datos
├── src/                      # Código fuente del proyecto
├── pom.xml                   # Archivo de configuración de Maven
├── README                 # Instrucciones para configurar el proyecto
└── src/main/resources/
    └── application.properties # Configuración de conexión a la base de datos

***Configuración de la Base de Datos
Abre phpMyAdmin o cualquier herramienta MySQL.
Crea una base de datos llamada gannetbase.
Importa el archivo db/gannetbase.sql:
En phpMyAdmin:
Selecciona la base de datos gannetbase.
Ve a la pestaña Importar.
Selecciona el archivo gannetbase.sql ubicado en la carpeta DataBase 

*** configuracion de la conexion de la BD en netbeans ***
se debe tener registrado un driver de MySQL 
en locate Driver seleccione la opcion de Driver MySQL(Connector/J driver)
pulse next, en seguida se desplegara una ventana de "customize Connection" ahi se deberan llenar solo los campos indicados 
deje todo exactamente igual solo cambie los campos Database, quite "MySQL" y escriba el nombre de la base de datos en este caso es "gannetbase".
por ultimo en el campo de JDBC URL, tiene algo parecido asi "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL"
cambielo por este "jdbc:mysql://localhost:3306/gannetbase?serverTimezone=UTC"
y por ultimo oprimir finish y estra la conexion lista para ejecutar el proyecto.
