/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd302;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class Operaciones {
    
    private static String SQL_Insert1="insert into datos(identificacion, nombres, apellido, correo) values (?,?,?,?)";
    private static String SQL_Insert2="insert into notas(cod,n1, n2, n3) values (?,?,?,?)";
    private static String SQL_Insert3="insert into datos(identificacion, nombres, apellidos, correo) values (?,?,?,?)";
    private static String SQL_Delete="";
    private static String SQL_Update="";
    private static String SQL_Select1="select * from datos where identificacion = ?";
    private static String SQL_Select2="";
    private static String SQL_Select3="";
    private PreparedStatement  PS;   
    Conector cn;
    
    public Operaciones() {
        PS = null;
        cn = new Conector();
    }
    
    public int insert(int cod, String nom, String ape, String correo ){
        int res=0;
        try{
            PS=cn.getConexion().prepareStatement(SQL_Insert1);
            PS.setInt(1, cod);
            PS.setString(2, nom);
            PS.setString(3, ape);
            PS.setString(4, correo);
            res = PS.executeUpdate();
        }catch(SQLException e){
            System.err.println("Error guardando"+e);
        }finally{
            PS= null;
            cn.close();
            System.out.println("Conexión cerrada");
        }
       
        return res;
    }
    public void consultaId(int id){
        
        ResultSet rs;
        try{
            PS=cn.getConexion().prepareStatement(SQL_Select1);
            PS.setInt(1, id);
            rs = PS.executeQuery();
            if(rs!= null){
                rs.next();
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String correo = rs.getString(4);
                System.out.println(nombre);
                System.out.println(apellido);
                System.out.println(correo);
            }
        }catch(SQLException e){
            System.err.println("Error consultando "+e);
        }finally{
            PS= null;
            cn.close();
            System.out.println("Conexión cerrada");
        }
        
        
    }
}
