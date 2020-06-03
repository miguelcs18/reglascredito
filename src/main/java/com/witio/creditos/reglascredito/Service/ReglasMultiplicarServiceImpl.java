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
    public Integer reglaAplicar(Request request) {

        //System.out.println("request = " + request);


        List<ReglasList> reglasLista = request.getReglasLists();

        //System.out.println("request List = " + reglasLista.get(0));

        String boleano = "";
        Integer resultadoEngancheUsuario = 0;
        Integer resultadoPerfilamiento = 0;

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

        //System.out.println("reglasAritmeticas = " + reglasAritmeticas);
        System.out.println("JSON regla = " + request.getReglasAritmeticasList().get(0).getIdReglaArit());
        Double operacionPerfil = 0.0;
        //operacionPerfil = (BigDecimal)Eval.me( resultadoPerfilamiento + " " + reglasAritmeticas.get(0).getOperador() + ""  + reglasAritmeticas.get(0).getFactor());
        System.out.println("Perfil = " + Eval.me(resultadoPerfilamiento + " " + reglasAritmeticas.get(2).getOperador() + "" + reglasAritmeticas.get(2).getFactor()));
        //System.out.println("operacionPerfil = " + operacionPerfil );
        //Double.parseDouble(Eval.me( resultadoPerfilamiento + " " + reglasAritmeticas.get(0).getOperador() + ""  + reglasAritmeticas.get(0).getFactor()));
        Object operacion = Eval.me(resultadoPerfilamiento + " " + reglasAritmeticas.get(2).getOperador() + "" + reglasAritmeticas.get(2).getFactor());
        System.out.println("operacion = " + operacion.toString());
        Double operacionD = Double.parseDouble(operacion.toString());

        System.out.println("regla 5 = " + reglasAritmeticas.get(1).getOperador());

        System.out.println("operacionD = " + Eval.me(operacionD + " "  + reglasAritmeticas.get(4).getOperador() + " " + reglasAritmeticas.get(4).getFactor() ));
//Eval.me(
        /*

        List<ReglasAritmeticas> reglasAritmetica = request.getReglasAritmeticasList();

        for (ReglasAritmeticas reglasA:  reglasAritmetica)
        {
            System.out.println("idReglaArit = " + reglasA.getIdReglaArit() + " operador = " + reglasA.getOperador() + " factor = " + reglasA.getFactor() );
        }


         */
        /*
        Object resultadoFinal;
        for (ReglasAritmeticas reglasArit: reglasAritmeticas) {
            //System.out.println("Aritmetica = " + reglasArit);

            resultadoFinal =  Eval.me(resultadoPerfilamiento + " "  + reglasArit.getOperador() + " " + reglasArit.getFactor());
            //System.out.println("resultadoFinal = " + resultadoFinal );
        }
*/

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
