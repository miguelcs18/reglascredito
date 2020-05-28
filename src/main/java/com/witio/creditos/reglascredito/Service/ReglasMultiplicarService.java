package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;

public interface ReglasMultiplicarService {
    Integer mostrarResultado(Integer num1, Integer num2);

    void guardarRegla(Integer num1, Integer num2, Integer resultado, ReglasMultiplicar reglas);
}
