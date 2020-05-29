package com.witio.creditos.reglascredito.Repository;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReglasMultiplicarRepository extends JpaRepository<ReglasMultiplicar,Integer> {
    String operador_inferior = "=";
    String operadorLogico = "AND";
    String operador_superior = "=";
    String queryString="SELECT resultado FROM ReglasMultiplicar WHERE num1=1 AND num2=3;";
    @Query(value = "SELECT resultado FROM ReglasMultiplicar WHERE num1"+ operador_inferior +":num1 " + operadorLogico + " num2 "+ operador_superior +" :num2")
    Integer mostrarResultado(@Param("num1") Integer num1, @Param("num2") Integer num2);

    @Query( "SELECT resultado FROM ReglasMultiplicar WHERE num1=1 AND num2=3" )
    Integer probarQuery(String queryString);

    List<ReglasMultiplicar> findByTipoRegla(Integer tipoRegla);
}
