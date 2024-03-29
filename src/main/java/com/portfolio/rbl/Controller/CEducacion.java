
package com.portfolio.rbl.Controller;

import com.portfolio.rbl.Dto.dtoEducacion;
import com.portfolio.rbl.Entity.Educacion;
import com.portfolio.rbl.Security.Controller.Mensaje;
import com.portfolio.rbl.Service.Seducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = {"https://portfolio-d5aa1.web.app", "http://localhost:4200"})
public class CEducacion {
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
    List<Educacion> list = sEducacion.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable ("id") int id){
    if(!sEducacion.existsById(id))
        return new ResponseEntity (new Mensaje("no existe"), HttpStatus.NOT_FOUND);
    Educacion educacion = sEducacion.getOne(id).get();
    return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") int id){
    if(!sEducacion.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
            }
    sEducacion.delete(id);
    return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu){      
        if(StringUtils.isBlank(dtoedu.getNombreE()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        /*if(sEducacion.existsByNombreEdu(dtoedu.getNombreE()))
            return new ResponseEntity (new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        */
        Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getDescripcionE());
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
        }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu){
    //validamos si existe el id
    if(!sEducacion.existsById(id)){
        return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
    }
    /*
//compara nombre de educacion
    if(sEducacion.existsByNombreEdu(dtoedu.getNombreE()) && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
    }    
*/
//No puede estar vacio
    if(StringUtils.isBlank(dtoedu.getNombreE())){
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    }
        Educacion educacion = sEducacion.getOne(id).get();
    educacion.setNombreE(dtoedu.getNombreE());
    educacion.setDescripcionE(dtoedu.getDescripcionE());
    
    sEducacion.save(educacion);
    return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
            
    }
   }
