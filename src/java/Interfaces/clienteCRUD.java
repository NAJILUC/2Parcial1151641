/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author HP
 */
public interface clienteCRUD {
    
    public List listar();
    public Cliente list(int id);
    public boolean add(Cliente cl);
    public boolean edit (Cliente ed);
    public boolean eliminar(int id);
    
    
}
