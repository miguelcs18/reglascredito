package com.witio.creditos.reglascredito.Controller;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Service.ReglasMultiplicarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerInicio {

    @Autowired
    private ReglasMultiplicarService reglasMultiplicarService;

    @GetMapping("/")
    public String inicio(){
        return "Hola";
    }

    /*
    @PostMapping("/multiplicar")
    public ResponseEntity mutiplicar(@RequestBody ReglasMultiplicar reglas) {
        System.out.println("resultado2 = " + reglasMultiplicarService.mostrarResultado(reglas.getNum1(),reglas.getNum2()));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/guardarRegla")
    public ResponseEntity guardarRegla(@RequestBody ReglasMultiplicar reglas) {
        reglasMultiplicarService.guardarRegla(reglas.getNum1(),reglas.getNum2(),reglas.getResultado(),reglas);
        return ResponseEntity.ok(HttpStatus.OK);
    }
*/

    @PostMapping("/probar")
    public ResponseEntity reglaAplicar(@RequestBody ReglasMultiplicar reglas, Integer engancheUsuario) {
        System.out.println("resultado3 = " + reglasMultiplicarService.reglaAplicar(reglas, engancheUsuario));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

