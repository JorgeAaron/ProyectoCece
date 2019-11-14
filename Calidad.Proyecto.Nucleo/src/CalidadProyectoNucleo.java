/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mx.itson.proyecto.entidades.Usuario;

/**
 *
 * @author QuickT
 */
public class CalidadProyectoNucleo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Usuario u = new Usuario();
       int q=u.ObtenerTodos().size();
        int i=0;
       
       for(i=0; i<q; i++){
        System.out.println(q);
        System.out.println(u.ObtenerTodos().get(i).getCorreo());
    
    }
       String p= "juanita@gmail.com";
       String a = u.login(p);
        System.out.println(a);
    }
    }
    

