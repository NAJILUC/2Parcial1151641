/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.tiendaCRUD;
import Modelo.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class TiendaDAO implements tiendaCRUD{

    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public List listar() {
        ArrayList<Tienda>list=new ArrayList<>();
        String sql="select * from tienda";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Tienda t=new Tienda();
                t.setId(rs.getInt("id"));
                t.setNombre(rs.getString("nombre"));
                t.setLema(rs.getString("lema"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setEmail(rs.getString("email"));
                t.setClave(rs.getString("clave"));
                t.setPropietario(rs.getString("propietario"));
                t.setFacebook(rs.getString("facebook"));
                t.setWeb(rs.getString("web"));
                t.setImagen(rs.getString("imagen"));
                list.add(t);
            }
            
        }
        catch(Exception e){}
        
        return list;
    }

    @Override
    public Tienda list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Tienda cl) {
        
        String sql="insert into tienda (nombre, lema, descripcion, email, clave, propietario, facebook, web, imagen) values ('"+cl.getNombre()+"','"+cl.getLema()+"','"+cl.getDescripcion()+"','"+cl.getEmail()+"','"+cl.getClave()+"','"+cl.getPropietario()+"','"+cl.getFacebook()+"','"+cl.getWeb()+"','"+cl.getImagen()+"') ";
        
        try{
        
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        }catch(Exception e){}
        return false;
    }

    @Override
    public boolean edit(Tienda ed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    int r=0;
    public int validar(Tienda t){
    
        String sql="select * from tienda where email=? and clave=?";
        try{
        
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, t.getEmail());
            ps.setString(1, t.getClave());
            rs=ps.executeQuery();
            
            while(rs.next()){
            
                r=r+1;
                t.setId(rs.getInt("id"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setNombre(rs.getString("nombre"));
                t.setLema(rs.getString("lema"));
                t.setEmail(rs.getString("email"));
                t.setPropietario(rs.getString("propitario"));
                t.setFacebook(rs.getString("facebook"));
                t.setWeb(rs.getString("web"));
                t.setImagen(rs.getString("imagen"));
            }
            
            if(r==1){
            
                return 1;
            }else{
            
                return 0;
            }
        }catch(Exception e){
        
             return 0;
        }
       
    }
    
   
    
}
