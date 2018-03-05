package simple;

import java.sql.*;

public class Principal {

    public static void main(String[] args) {
        System.out.println("[..] simple.Principal.main() ");
        try {
            //Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbalumnos", "educacion", "educacion");

            crearBase();
            
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
            String crearTablaAlumnos = " CREATE TABLE IF NOT EXISTS alumnos ( "
                    + " alu_id int  (11) NOT NULL AUTO_INCREMENT ,  "
                    + " alu_email varchar(255) COLLATE utf8_bin NOT NULL , "
                    + " alu_nombre varchar(255) COLLATE utf8_bin DEFAULT NULL , "
                    + " alu_apellido varchar(255) COLLATE utf8_bin DEFAULT NULL, "
                    + " PRIMARY KEY(alu_id), "
                    + " UNIQUE KEY alumnos_alu_email_UK(alu_email) "
                    + " ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin; ";
            sentencia = conectar.prepareStatement(crearBaseDeDatos);
            sentencia.execute();
        } catch (Exception ex) {
            System.out.println("[ERROR] simple.Principal.crearBase() " + ex.getMessage());
        }
        System.out.println("[OK] simple.Principal.crearBase()");
    }

    public static void insertarBase() {
        System.out.println("[..] simple.Principal.insertarBase()");
        System.out.println("[OK] simple.Principal.insertarBase()");
    }

    public static void consutlarBase() {
        System.out.println("[..] simple.Principal.consutlarBase()");
        System.out.println("[OK] simple.Principal.consutlarBase()");
    }

    public static void borrarBase() {
        System.out.println("[..] simple.Principal.borrarBase()");
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
