package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;

import java.util.List;

public interface ReglasMultiplicarService {
    Integer mostrarResultado(Integer num1, Integer num2);

    void guardarRegla(Integer num1, Integer num2, Integer resultado, ReglasMultiplicar reglas);

    Integer reglaAplicar(ReglasMultiplicar reglas, Integer engancheUsuario);

    Integer probarQuery(String queryString);

    List<ReglasMultiplicar> buscarReglas(Integer tipoRegla);

}
