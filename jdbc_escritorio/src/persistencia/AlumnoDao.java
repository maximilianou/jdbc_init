package persistencia;

import java.sql.*;
import java.util.*;

public class AlumnoDao {

    public static ArrayList<Alumno> consultar() throws Exception {
        ArrayList<Alumno> listado = new ArrayList();
        Connection conectar = null;
        try {
            conectar = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbalumnos",
                    "educacion",
                    "educacion");
            String eliminarDatos = " SELECT * FROM alumnos ";
            PreparedStatement sentencia = conectar.prepareStatement(eliminarDatos);
            ResultSet cursorResultado = sentencia.executeQuery();
            while (cursorResultado.next()) {
                Alumno actual = new Alumno();
                actual.setId(cursorResultado.getString("alu_id"));
                actual.setEmail(cursorResultado.getString("alu_email"));
                actual.setNombre(cursorResultado.getString("alu_nombre"));
                actual.setApellido(cursorResultado.getString("alu_apellido"));
                listado.add(actual);
            }
        } finally {
            conectar.close();
        }
        return listado;
    }

    public static void insertar(Alumno alu) throws Exception {
        Connection conectar = null;
        try {
            conectar = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbalumnos",
                    "educacion",
                    "educacion");
            String insertarDatos = " INSERT INTO alumnos "
                    + " ( alu_email, alu_nombre, alu_apellido ) "
                    + " VALUES "
                    + " (?,?,?) ";
            PreparedStatement sentencia = conectar.prepareStatement(insertarDatos);
            sentencia.setString(1, alu.getEmail());
            sentencia.setString(2, alu.getNombre());
            sentencia.setString(3, alu.getApellido());
            sentencia.execute();
        } finally {
            conectar.close();
        }
    }

    public static void eliminar(Alumno alu) throws Exception {
        Connection conectar = null;
        try {
            conectar = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dbalumnos",
                    "educacion",
                    "educacion");
            String eliminarDatos = " DELETE FROM alumnos "
                    + " WHERE alu_id = ? ";
            PreparedStatement sentencia = conectar.prepareStatement(eliminarDatos);
            sentencia.setString(1, alu.getId());
            sentencia.execute();
        } finally {
            conectar.close();
        }
    }
}
