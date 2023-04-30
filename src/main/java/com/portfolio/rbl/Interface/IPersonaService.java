package com.portfolio.rbl.Interface;

import com.portfolio.rbl.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer una persona
    public List<Persona> getPersona();
   
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //eliminar un usuario buscar por id
     public void deletePersona(Long id);
     
     //buscar persona por id
     public Persona findPersona(Long id);
}
