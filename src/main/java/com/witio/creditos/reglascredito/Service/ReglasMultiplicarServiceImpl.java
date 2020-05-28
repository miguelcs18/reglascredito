package com.witio.creditos.reglascredito.Service;

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
}
