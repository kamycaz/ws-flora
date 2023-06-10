package com.zopitek.flora.util;

import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.dto.ClientBasicDTO;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public ClientBasicDTO clientBasicResponseToClientBasicDTO(ClientBasicResponse clientBasicResponse) {
        ClientBasicDTO clientBasicDTO = new ClientBasicDTO();
        clientBasicDTO.setId(clientBasicResponse.getId());
        clientBasicDTO.setName(clientBasicResponse.getName());
        clientBasicDTO.setTown(clientBasicResponse.getTown());
        return clientBasicDTO;
    }
}
