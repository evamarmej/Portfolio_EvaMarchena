package controles;

import javax.swing.JOptionPane;

public class controles { //Clase para el control de errores
    
    public boolean esNumero(String num) { //Controla si una variable es un número
        try {
            Float.parseFloat(num); //Intenta parsearlo a float
        } catch (NumberFormatException nfe) {
            return false; //Si no parsea a float no es un número y devuelve false
        }        
        return true; //Si parsea a float es un número y devuelve true
    }
      
    public boolean validacionOperarios(String dni, String nombre, String apellidos, String direccion, String telefono){ //Controla si una variable es un número en operarios
        if(esNumero(dni)){ //Si dni es un número
            JOptionPane.showMessageDialog(null, "Introduce un DNI correcto", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error          
            return false; //Devuelve falso porque es un número y no debe serlo
        }
        if(esNumero(nombre)){ //Si nombre es un número
            JOptionPane.showMessageDialog(null, "Introduce un nombre correcto", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error          
            return false; //Devuelve falso porque es un número y no debe serlo
        }
        if(esNumero(apellidos)){ //Si apellidos es un número
            JOptionPane.showMessageDialog(null, "Introduce un apellido correcto", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error          
            return false; //Devuelve falso porque es un número y no debe serlo
        }
        if(esNumero(direccion)){ //Si dirección es un número
            JOptionPane.showMessageDialog(null, "Introduce una dirección correcta", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error          
            return false; //Devuelve falso porque es un número y no debe serlo
        }
        if(!esNumero(telefono)){ //Si teléfono es un número
            JOptionPane.showMessageDialog(null, "Introduce un teléfono correcto", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error          
            return false; //Devuelve falso porque es un número y no debe serlo
        }
        return true; //Devuelve true si no es un número
    }
    
    public boolean validacionRegistros(String idopt, String preciomaterial,String numhoras){ //Controla si una variable es un número en trabajos
        if(!esNumero(idopt)){ //Si id operario no es un número
            JOptionPane.showMessageDialog(null, "Introduce un id de operario", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error                   
            return false; //Devuelve falso porque no es un número y debe serlo              
        } 
        if(!esNumero(preciomaterial)){ //Si precio material no es un número
            JOptionPane.showMessageDialog(null, "Introduce un precio de material", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error                   
            return false; //Devuelve falso porque no es un número y debe serlo                
        }
        if(!esNumero(numhoras)){ //Si número de horas no es un número
            JOptionPane.showMessageDialog(null, "Introduce un número de horas", "Error", JOptionPane.ERROR_MESSAGE); //Muestra mensaje de error                   
            return false; //Devuelve falso porque no es un número y debe serlo             
        }
        return true; //Devuelve true si es un número
    }
    

    
}
