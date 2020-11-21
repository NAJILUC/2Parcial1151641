/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import Modelo.Tienda;
import java.util.List;

/**
 *
 * @author HP
 */
public interface tiendaCRUD {
    public List listar();
    public Tienda list(int id);
    public boolean add(Tienda cl);
    public boolean edit (Tienda ed);
    public boolean eliminar(int id);
    
}
