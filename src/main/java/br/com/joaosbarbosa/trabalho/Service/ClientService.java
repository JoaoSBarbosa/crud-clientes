package br.com.joaosbarbosa.trabalho.Service;

import br.com.joaosbarbosa.trabalho.dto.ClientDTO;
import br.com.joaosbarbosa.trabalho.entity.Client;
import br.com.joaosbarbosa.trabalho.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired private ClientRepository clientRepository;

    public ClientDTO insert(ClientDTO dto){
        Client entity = new Client();
        copyDtoToEntity(entity, dto);

        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }



    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPages(PageRequest pageRequest) {
        Page<Client> clientPage = clientRepository.findAll(pageRequest);

        return clientPage.map(client -> new ClientDTO(client));
    }

    @Transactional(readOnly = true)
    public ClientDTO searchById(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        Client client = clientOptional.orElseThrow(()-> new RuntimeException("Erro ao localizar id"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO updateClient(ClientDTO dto, Long id) {
        try{
            Client client = clientRepository.getOne(id);
            copyDtoToEntity(client,dto);
            client = clientRepository.save(client);

            return new ClientDTO(client);

        }catch (Exception e){
            throw new EntityNotFoundException("Erro ao localizar o ID"+id);
        }
    }

    private void copyDtoToEntity(Client entity, ClientDTO dto){
        entity.setName(dto.getName());
        entity.setChildren(dto.getChildren());
        entity.setCpf(dto.getCpf());
        entity.setBirthDate(dto.getBirthDate());
        entity.setInCome(dto.getInCome());

    }
}
