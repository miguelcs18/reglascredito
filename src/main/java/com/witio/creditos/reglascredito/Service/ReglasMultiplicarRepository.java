package com.witio.creditos.reglascredito.Service;

import com.witio.creditos.reglascredito.Model.ReglasMultiplicar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReglasMultiplicarRepository extends JpaRepository<ReglasMultiplicar,Integer> {
    @Query(value = "SELECT resultado FROM ReglasMultiplicar WHERE num1=:num1 AND num2=:num2")
    Integer mostrarResultado(@Param("num1") Integer num1, @Param("num2") Integer num2);
}
