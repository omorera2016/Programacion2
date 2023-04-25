/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd302;

import java.sql.PreparedStatement;
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
    private static String SQL_Select1="";
    private static String SQL_Select2=" select * from datos where correo like '%?'";
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
    
}
