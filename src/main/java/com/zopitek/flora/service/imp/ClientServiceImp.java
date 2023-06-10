package com.zopitek.flora.service.imp;

import com.zopitek.flora.entity.Client;
import com.zopitek.flora.model.dto.BasicDTO;
import com.zopitek.flora.model.dto.ClientBasicDTO;
import com.zopitek.flora.model.projection.ClientBasicResponse;
import com.zopitek.flora.params.ErrorMessages;
import com.zopitek.flora.repository.ClientRepository;
import com.zopitek.flora.service.ClientService;
import com.zopitek.flora.util.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public Integer save(Client client) throws Exception {
      try{
          clientRepository.save(client);
          return 1;
      }catch (Exception e) {
          throw new Exception(e.getMessage());
          }
    }

    @Override
    public List<Client> findAll() throws Exception {
       try {
           return (List<Client>) clientRepository.findAll();
       } catch (Exception e) {
           throw new Exception(e.getMessage());
       }
    }

    @Override
    public Client update(Client client) throws Exception {
        try {
            return clientRepository.save(client);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClientBasicDTO> findBasicList() throws Exception {
        try {
            List<ClientBasicDTO> dtoList = new ArrayList<>();
            List<ClientBasicResponse> list = clientRepository.findBasicList();
            for( ClientBasicResponse client : list){
                dtoList.add(classMapper.clientBasicResponseToClientBasicDTO(client));
            }
            return dtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClientBasicDTO> findBasicListByName(String name) throws Exception {
        try {
            List<ClientBasicDTO> dtoList = new ArrayList<>();
            List<ClientBasicResponse> list = clientRepository.findBasicListByName(name);
            for( ClientBasicResponse client : list){
                dtoList.add(classMapper.clientBasicResponseToClientBasicDTO(client));
            }
            return dtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Client findById(Integer id) throws Exception {
        try {
            Optional client = clientRepository.findById(id);
            if(client.isEmpty()){
                throw new Exception(ErrorMessages.NOT_FOUND);
            } else {
                return (Client) client.get();
            }
        }  catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
