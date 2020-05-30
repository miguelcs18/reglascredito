package com.witio.creditos.reglascredito.Controller;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Model.Request;
import com.witio.creditos.reglascredito.Service.ReglasMultiplicarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerInicio {

    @Autowired
    private ReglasMultiplicarService reglasMultiplicarService;

    @GetMapping("/")
    public String inicio(){
        return "Hola";
    }
    /*
    @PostMapping("/probar/{engancheUsuario}")
    public ResponseEntity reglaAplicar(@RequestBody ReglasMultiplicar reglas, @PathVariable Integer engancheUsuario) {
        System.out.println("engancheUsuario = "+ engancheUsuario );
        System.out.println("resultado3 = " + reglasMultiplicarService.reglaAplicar(reglas, engancheUsuario));
        return ResponseEntity.ok(HttpStatus.OK);
    }
    */

    @PostMapping("/perfilarCliente")
    public ResponseEntity reglaAplicar(@RequestBody Request request, ReglasMultiplicar reglas) {
        Integer engancheUsuario = Integer.parseInt(request.getEnganche());
        System.out.println("enganche request = "+ request.getEnganche() );
        System.out.println("resultado3 = " + reglasMultiplicarService.reglaAplicar(reglas, request));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

