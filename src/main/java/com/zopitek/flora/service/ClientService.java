package com.zopitek.flora.service;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.dto.ClientBasicDTO;
import com.zopitek.flora.model.dto.ClientDTO;

import java.util.List;

public interface ClientService {

    public Integer save(Client client) throws Exception;
    public List<Client> findAll() throws Exception;
    public Client update(Client client) throws Exception;
    public List<ClientBasicDTO> findBasicList() throws Exception;
    public List<ClientBasicDTO> findBasicListByName(String name) throws Exception;
    public Client findById(Integer id) throws Exception;
}
