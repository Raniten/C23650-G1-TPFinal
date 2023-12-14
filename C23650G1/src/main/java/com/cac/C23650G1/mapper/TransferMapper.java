package com.cac.C23650G1.mapper;

import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.entities.dtos.TransferDto;

public class TransferMapper {

    public static Transfer dtoToTransfer (TransferDto dto){
        Transfer trf = new Transfer();
        trf.setAmount(dto.getAmount());
        trf.setDateTransfer(dto.getDateTransfer());
        trf.setDestinyAccount(dto.getDestinyAccount());
        trf.setOriginAccount(dto.getOriginAccount());

        return trf;
    }
    public static TransferDto dtoToTransfer (Transfer trf){
        TransferDto dto = new TransferDto();
        dto.setAmount(trf.getAmount());
        dto.setDateTransfer(trf.getDateTransfer());
        dto.setDestinyAccount(trf.getDestinyAccount());
        dto.setOriginAccount(trf.getOriginAccount());

        return dto;
    }
}
