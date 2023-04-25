/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd302;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Conector {
    private static String driver="com.mysql.jdbc.Driver"; //Driver conexión al motor BD
    private static String user="Usuario"; //usuario del servidor de BD
    private static String pass="12345"; //contraseña del usuario BD
    private static String url="jdbc:mysql://localhost:3306/bd302"; //ubicación del servidor y nombre de BD
    private static Connection  conn;

    public Conector() {
        conn= null;
        try{//excepciones: control de errores en ejecución
            Class.forName(driver); //Vincular las clases del conector de BD
            conn=DriverManager.getConnection(url,user, pass); //creación del puente hacia la BD
            if(conn!= null){
                System.out.println("Conectado");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("error al conectar " + e);
        }
    }
    public Connection getConexion(){
        return conn;
    }
    
    public void close(){
        conn = null;
        if(conn == null){
            System.out.println("Conexión cerrada");
        }
    }
    
    
}
