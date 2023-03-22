package com.zopitek.flora.service;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.model.dto.BasicDTO;

import java.util.List;

public interface ClientService {

    public Client save(Client client) throws Exception;

    public List<Client> findAll() throws Exception;
    public Client update(Client client) throws Exception;

    public List<BasicDTO> findBasicList() throws Exception;
    public Client findById(Long id) throws Exception;
}
