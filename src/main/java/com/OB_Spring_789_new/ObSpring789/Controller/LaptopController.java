package com.OB_Spring_789_new.ObSpring789.Controller;


import com.OB_Spring_789_new.ObSpring789.Entity.Laptop;
import com.OB_Spring_789_new.ObSpring789.Repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    // 1. Atributos

    private LaptopRepository laptopRepository;

    // 2. Constructores

    private LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    // 3. Buscar todos los laptops

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }

    // 4. Buscar un solo laptop

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un laptop por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {

        Optional<Laptop> bookOpt = laptopRepository.findById(id);

        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();

    }

    // 5. Crear un laptop

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por parámetro en la base de datos
        if(laptop.getId() != null){ // quiere decir que existe el id y por tanto no es una creación
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // 6. Actualizar un laptop existente

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null ){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // 7. Borrar un laptop de base de datos

    @DeleteMapping("/api/laptops/{id}")
    @ApiIgnore
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    // 8. Borrar todos los libros

    @DeleteMapping("/api/laptops")
    @ApiIgnore
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST Request for delete all books");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }






}

