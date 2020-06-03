package com.witio.creditos.reglascredito.Repository;

import com.witio.creditos.reglascredito.Model.ReglasAritmeticas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReglasAritmeticasRepository extends JpaRepository<ReglasAritmeticas,Integer> {


    List<ReglasAritmeticas> findByIdReglaArit(Integer idReglaArit);

}
