package com.witio.creditos.reglascredito.Model;

import lombok.Data;

import java.util.List;

@Data
public class Request {
        private String tipoRegla;
        private String valor;
        private List<ReglasList> reglasLists;
}
