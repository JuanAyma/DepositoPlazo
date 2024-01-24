package com.bbva.contractmicroservice.mapper;

import com.bbva.contractmicroservice.dto.ContractDTO;
import com.bbva.contractmicroservice.entity.Contract;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    ContractDTO toDto(Contract contract);
    Contract toEntity(ContractDTO contractDTO);
    List<ContractDTO> toDtoList(List<Contract> contracts);
}
