package com.bbva.accountmicroservice.repository;

import com.bbva.accountmicroservice.entity.Account;
import com.bbva.accountmicroservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    /**
     *Lista todos las cuentas de la base de datos
     * @return una Lista de CuentaEntity o null si no encuentra
     */
    //public List<CuentaEntity> getAllCuentas();//Ojo que debe estar tambien en la clase entity
    List<Account> findAccountsByCustomer_IdCliente(Long idCliente);
}
