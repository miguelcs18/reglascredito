package com.witio.creditos.reglascredito.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class ReglasAritmeticas {
    @Id
    private Integer idReglaArit;
    private String nombre;
    private String operador;
    private String factor;
}
