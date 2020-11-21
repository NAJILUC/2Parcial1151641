/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Servicio;
import Modelo.Tienda;
import java.util.List;

/**
 *
 * @author HP
 */
public interface servicioCRUD {
    
     public List listar();
    public Servicio list(int id);
    public boolean add(Servicio cl);
    public boolean edit (Servicio ed);
    public boolean eliminar(int id);
}
