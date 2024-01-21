package com.bbva.accountmicroservice.repository;

import com.bbva.accountmicroservice.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    /**
     *Lista todos las cuentas de la base de datos
     * @return una Lista de CuentaEntity o null si no encuentra
     */
    //public List<CuentaEntity> getAllCuentas();//Ojo que debe estar tambien en la clase entity
}
