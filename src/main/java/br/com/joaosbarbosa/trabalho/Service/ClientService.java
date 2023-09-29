package br.com.joaosbarbosa.trabalho.Service;

import br.com.joaosbarbosa.trabalho.dto.ClientDTO;
import br.com.joaosbarbosa.trabalho.entity.Client;
import br.com.joaosbarbosa.trabalho.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired private ClientRepository clientRepository;

    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(entity, dto);

        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    private void copyDtoToEntity(Client entity, ClientDTO dto){
        entity.setName(dto.getName());
        entity.setChildren(dto.getChildren());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setInCome(dto.getInCome());

    }
}
