package com.bbva.accountmicroservice.mapper;

import com.bbva.accountmicroservice.dto.AccountCreateDTO;
import com.bbva.accountmicroservice.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountCreateMapper {
    Account toEntity(AccountCreateDTO accountDTO);
    AccountCreateDTO toDto(Account account);
    List<AccountCreateDTO> toDtoList(List<Account> accounts);
}
