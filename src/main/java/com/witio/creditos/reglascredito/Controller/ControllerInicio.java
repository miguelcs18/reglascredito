package com.witio.creditos.reglascredito.Controller;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Service.ReglasMultiplicarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerInicio {

    @Autowired
    private ReglasMultiplicarServiceImpl reglasMultiplicarServiceImpl;

    @GetMapping("/")
    public String inicio(){
        return "Hola";
    }

    @PostMapping("/multiplicar")
    public ResponseEntity postController(@RequestBody ReglasMultiplicar reglas) {
        System.out.println("resultado2 = " + reglasMultiplicarServiceImpl.mostrarResultado(reglas.getNum1(),reglas.getNum2()));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
