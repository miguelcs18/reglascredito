package com.witio.creditos.reglascredito.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Perfil {
    @Id
    private Integer idPerfil;
    private String nombreDeVariable;
    private Integer tipoRegla;
    private String operadorInferior;
    private Integer limiteInferior;
    private String operadorLogico;
    private String operadorSuperior;
    private Integer limiteSuperior;
    private String valor;
}
