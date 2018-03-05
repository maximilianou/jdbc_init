</pre>
package simple;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {
        System.out.println("[..] simple.Principal.main() ");
        try {
            crearBase();
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbalumnos", "educacion", "educacion");
            consutlarDato(conectar);
            crearTabla(conectar);
            consutlarDato(conectar);
            insertarDato(conectar);
            consutlarDato(conectar);
            borrarDato(conectar);
            consutlarDato(conectar);
            destruirBase();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.main() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.main() ");
    }

    public static void crearBase() {
        System.out.println("[..] simple.Principal.crearBase()");
        try {
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "educacion", "educacion");
            String crearBaseDeDatos = " CREATE DATABASE IF NOT EXISTS dbalumnos DEFAULT CHARACTER SET utf8 COLLATE utf8_bin; ";
            PreparedStatement sentencia = conectar.prepareStatement(crearBaseDeDatos);
            sentencia.execute();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.crearBase() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.crearBase()");
    }

    public static void crearTabla(Connection conectar) {
        System.out.println("[..] simple.Principal.crearTabla()");
        PreparedStatement sentencia;
        try {
            String crearTablaAlumnos = " CREATE TABLE IF NOT EXISTS alumnos ( "
                    + " alu_id int  (11) NOT NULL AUTO_INCREMENT ,  "
                    + " alu_email varchar(255) COLLATE utf8_bin NOT NULL , "
                    + " alu_nombre varchar(255) COLLATE utf8_bin DEFAULT NULL , "
                    + " alu_apellido varchar(255) COLLATE utf8_bin DEFAULT NULL, "
                    + " PRIMARY KEY(alu_id), "
                    + " UNIQUE KEY alumnos_alu_email_UK(alu_email) "
                    + " ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin; ";
            sentencia = conectar.prepareStatement(crearTablaAlumnos);
            sentencia.execute();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.crearTabla() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.crearTabla()");
    }

    public static void insertarDato(Connection conectar) {
        System.out.println("[..] simple.Principal.insertarBase()");
        String insertarDatos = " INSERT INTO alumnos "
                + " (alu_email, alu_nombre, alu_apellido) "
                + " VALUES "
                + " ('sol@gmail.com', 'Sol', 'Hernandez'), "
                + " ('pit@gmail.com','Peter Capu','Soto'), "
                + " ('gert@gmail.com','Gertrudis','Maschiruza'), "
                + " ('caram@gmail.com','Caram','Bolas'), "
                + " ('arroyo@gmail.com','Arroyo','Las Piedras'); ";
        PreparedStatement sentencia;
        try {
            sentencia = conectar.prepareStatement(insertarDatos);
            sentencia.execute();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.insertarBase() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.insertarBase()");
    }

    public static void consutlarDato(Connection conectar) {
        System.out.println("[..] simple.Principal.consutlarBase()");
        String eliminarDatos = " SELECT * FROM alumnos ";
        PreparedStatement sentencia;
        try {
            sentencia = conectar.prepareStatement(eliminarDatos);
            ResultSet cursorResultado = sentencia.executeQuery();
            while (cursorResultado.next()) {
                System.out.println("     { "
                        + cursorResultado.getString(1)
                        + " , "
                        + cursorResultado.getString(2)
                        + " , "
                        + cursorResultado.getString(3)
                        + " , "
                        + cursorResultado.getString(4)
                        + " }");
            }
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.consutlarBase() " + ex.getMessage());
        }

        System.out.println("[OK] simple.Principal.consutlarBase()");
    }

    public static void borrarDato(Connection conectar) {
        System.out.println("[..] simple.Principal.borrarBase()");
        String eliminarDatos = " DELETE FROM alumnos ";
        PreparedStatement sentencia;
        try {
            sentencia = conectar.prepareStatement(eliminarDatos);
            sentencia.execute();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.borrarBase() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.borrarBase()");
    }

    public static void destruirBase() {
        System.out.println("[..] simple.Principal.destruirBase()");
        try {
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "educacion", "educacion");
            String crearBaseDeDatos = " DROP DATABASE IF EXISTS dbalumnos; ";
            PreparedStatement sentencia = conectar.prepareStatement(crearBaseDeDatos);
            sentencia.execute();
        } catch (SQLException ex) {
            System.out.println("[ERROR] simple.Principal.destruirBase() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.destruirBase()");
    }
}
</pre>