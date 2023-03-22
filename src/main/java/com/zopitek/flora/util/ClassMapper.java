package com.zopitek.flora.util;

import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import org.springframework.stereotype.Component;

@Component
public class ClassMapper {

    public BasicDTO clientBasicResponseToClientBasicDTO(ClientBasicResponse clientBasicResponse) {
        BasicDTO clientBasicDTO = new BasicDTO();
        clientBasicDTO.setId(clientBasicResponse.getId());
        clientBasicDTO.setName(clientBasicResponse.getCom_Name());
        return clientBasicDTO;
    }
}
