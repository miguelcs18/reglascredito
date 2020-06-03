package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasAritmeticas;
import com.witio.creditos.reglascredito.Model.ReglasList;
import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Model.Request;
import com.witio.creditos.reglascredito.Repository.ReglasAritmeticasRepository;
import com.witio.creditos.reglascredito.Repository.ReglasMultiplicarRepository;
import groovy.util.Eval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglasMultiplicarServiceImpl implements ReglasMultiplicarService {

    @Autowired
    private ReglasMultiplicarRepository reglasMultiplicarRepository;

    @Autowired
    private ReglasAritmeticasRepository reglasAritmeticasRepository;


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
    public Double reglaAplicar(Request request) {

        //System.out.println("request = " + request);


        List<ReglasList> reglasLista = request.getReglasLists();

        //System.out.println("request List = " + reglasLista.get(0));

        String boleano = "";
        Integer resultadoEngancheUsuario = 0;
        Double resultadoPerfilamiento = 0.0;

        for (ReglasList reglaslista : reglasLista) {
            System.out.println("ruleType = " + reglaslista.getRuleType() + " value = " + reglaslista.getValue());

            List<ReglasMultiplicar> enganche = reglasMultiplicarRepository.findByTipoRegla(Integer.parseInt(reglaslista.getRuleType()));
            Integer engancheUsuariolocal = Integer.parseInt(reglaslista.getValue());
            for (ReglasMultiplicar reglitas : enganche) {

                if (reglitas.getOperador_logico().equals("")) {
                    boleano = engancheUsuariolocal + " " + reglitas.getOperador_inferior() + " " + reglitas.getLimite_inferior();
                } //if
                else {
                    boleano = engancheUsuariolocal + " " + reglitas.getOperador_inferior() + " " + reglitas.getLimite_inferior() + " " + reglitas.getOperador_logico() + " " + engancheUsuariolocal + " " + reglitas.getOperador_superior() + " " + reglitas.getLimite_superior();
                } //else
                System.out.println("Booleano = " + boleano);

                if ((Boolean) Eval.me(boleano)) {
                    resultadoEngancheUsuario = reglitas.getResultado();
                    resultadoPerfilamiento += resultadoEngancheUsuario;
                } //if
            } // for

            //System.out.println("resultadoPerfilamiento = " + resultadoPerfilamiento);

        } //for

        //List<ReglasAritmeticas> reglasAritmeticas = reglasAritmeticasRepository.findByIdReglaArit(request.getReglasAritmeticasList().get(0).getIdReglaArit());
        List<ReglasAritmeticas> reglasAritmeticas = reglasAritmeticasRepository.findAll();
        List<ReglasAritmeticas> reglasArRequest = request.getReglasAritmeticasList();
        //Double resultadoPerfilamiento2  = 0.0;
        String operador;
        String factor;
        String expresion;
        for (ReglasAritmeticas reglasArR: reglasArRequest) {
            //System.out.println("reglasArRequest = " + reglasArR);
            for (ReglasAritmeticas reglasAr:  reglasAritmeticas)
            {
                if(reglasArR.getIdReglaArit() == reglasAr.getIdReglaArit()) {
                    operador = reglasAr.getOperador();
                    factor = reglasAr.getFactor();
                    expresion = Eval.me(resultadoPerfilamiento + " " + operador + " " + factor).toString();
                    resultadoPerfilamiento = Double.parseDouble(expresion);
                    //System.out.println("Expresion = " + expresion);
                    //System.out.println("resultadoPerfilamiento = " + resultadoPerfilamiento);
                }
            }

        }


        return resultadoPerfilamiento;
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
