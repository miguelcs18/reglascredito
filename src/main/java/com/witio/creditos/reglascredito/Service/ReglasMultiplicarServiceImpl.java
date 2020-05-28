package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import com.witio.creditos.reglascredito.Repository.ReglasMultiplicarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReglasMultiplicarServiceImpl implements ReglasMultiplicarService {

    @Autowired
    private ReglasMultiplicarRepository reglasMultiplicarRepository;

    @Override
    public Integer mostrarResultado(Integer num1, Integer num2) {
        return reglasMultiplicarRepository.mostrarResultado(num1,num2);
    }

    @Override
    public void guardarRegla(Integer num1, Integer num2, Integer resultado, ReglasMultiplicar reglasMultiplicar) {
        reglasMultiplicar.setNum1(num1);
        reglasMultiplicar.setNum2(num2);
        reglasMultiplicar.setResultado(resultado);
        reglasMultiplicarRepository.save(reglasMultiplicar);
    }
}
