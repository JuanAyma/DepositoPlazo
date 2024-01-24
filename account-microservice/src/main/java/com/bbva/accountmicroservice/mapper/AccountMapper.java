package com.bbva.accountmicroservice.mapper;

import com.bbva.accountmicroservice.dto.AccountDTO;
import com.bbva.accountmicroservice.entity.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDTO accountDTO);
    AccountDTO toDto(Account account);
    List<AccountDTO> toDtoList(List<Account> accounts);
}
