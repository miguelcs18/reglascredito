package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Repository.ReglasMultiplicarRepository;
import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglasMultiplicarServiceImpl implements ReglasMultiplicarService {

    @Autowired
    private ReglasMultiplicarRepository reglasMultiplicarRepository;


    @Override
    public Integer mostrarResultado(Integer num1, Integer num2) {
        return reglasMultiplicarRepository.mostrarResultado(num1, num2);
    }

    @Override
    public void guardarRegla(Integer num1, Integer num2, Integer resultado, ReglasMultiplicar reglasMultiplicar) {

        reglasMultiplicar.setResultado(resultado);
        reglasMultiplicarRepository.save(reglasMultiplicar);
    }

    @Override
    public Integer reglaAplicar(ReglasMultiplicar reglas, Integer engancheUsuario) {
        List<ReglasMultiplicar> enganche = reglasMultiplicarRepository.findByTipoRegla(1);
        System.out.println(enganche);

        Integer engancheUsuariolocal = 15;
        Integer resultadoEngancheUsuario = 0;


        System.out.println("engancheUsuariolocal = " + engancheUsuariolocal);


/*
        if( (Boolean) Eval.me(engancheUsuariolocal + " " + enganche.get(0).getOperador_inferior() + " " + enganche.get(0).getLimite_inferior() + " " +  enganche.get(0).getOperador_logico() +" "+  enganche.get(0).getOperador_superior() + " " + enganche.get(0).getLimite_superior()) ){
            resultadoEngancheUsuario = 1 ;
        }
*/



        String boleano = "";

        for (ReglasMultiplicar reglitas : enganche) {

           if  (reglitas.getOperador_logico().equals("")) {
               boleano = engancheUsuariolocal + " " + reglitas.getOperador_inferior() + " " + reglitas.getLimite_inferior();
           }
           else{
               boleano = engancheUsuariolocal + " " + reglitas.getOperador_inferior() + " " + reglitas.getLimite_inferior() + " " + reglitas.getOperador_logico() + " " + engancheUsuariolocal + " " +   reglitas.getOperador_superior() + " " + reglitas.getLimite_superior();
           }
            System.out.println("Booleano = " + boleano);

            if( (Boolean) Eval.me(boleano) ){
                resultadoEngancheUsuario = reglitas.getResultado() ;
                break;
            }




        }

       System.out.println("resultado FINAL = " + resultadoEngancheUsuario);

        return 1;
    }

    @Override
    public Integer probarQuery(String queryString) {
        queryString = "SELECT resultado FROM ReglasMultiplicar WHERE num1=1 AND num2=3 ";
        Integer resultado = reglasMultiplicarRepository.probarQuery(queryString);
        return resultado;
    }

    @Override
    public List<ReglasMultiplicar> buscarReglas(Integer tipoRegla) {
        return null;
    }
}
