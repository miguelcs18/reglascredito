package com.witio.creditos.reglascredito.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class ReglasMultiplicar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegla;
    private Integer tipoRegla;
    private String operador_inferior;
    private String limite_inferior;
    private String operador_logico;
    private String operador_superior;
    private String limite_superior;
    private Integer resultado;
}
