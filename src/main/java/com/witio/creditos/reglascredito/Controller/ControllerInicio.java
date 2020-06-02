package com.witio.creditos.reglascredito.Controller;

import com.witio.creditos.reglascredito.Model.Request;
import com.witio.creditos.reglascredito.Service.ReglasMultiplicarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerInicio {

    @Autowired
    private ReglasMultiplicarService reglasMultiplicarService;


    @PostMapping("/perfilarCliente")
    public ResponseEntity reglaAplicar(@RequestBody Request request) {
       // Integer engancheUsuario = Integer.parseInt(request.getEnganche());

        //System.out.println("enganche request = "+ request.getValor() );
        System.out.println("*** resultado3 *** = " + reglasMultiplicarService.reglaAplicar(request));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

