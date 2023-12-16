package com.cac.C23650G1.mappers;

import com.cac.C23650G1.entities.Transfer;
import com.cac.C23650G1.entities.User;
import com.cac.C23650G1.entities.dtos.TransferDto;
import com.cac.C23650G1.entities.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransferMapper {

    public static Transfer dtoToTransfer(TransferDto dto){
        Transfer transfer = new Transfer();

        transfer.setIdTransfer(dto.getIdTransfer());
        transfer.setDate(dto.getDate());
        transfer.setIdAccountSender(dto.getIdAccountSender());
        transfer.setIdAccountRecipient(dto.getIdAccountRecipient());
        transfer.setAmount(dto.getAmount());

        return transfer;
    }

    public static TransferDto transferToDto(Transfer transfer){
        TransferDto dto = new TransferDto();

        dto.setIdTransfer(transfer.getIdTransfer());
        dto.setDate(transfer.getDate());
        dto.setIdAccountSender(transfer.getIdAccountSender());
        dto.setIdAccountRecipient(transfer.getIdAccountRecipient());
        dto.setAmount(transfer.getAmount());

        return dto;
    }
}
