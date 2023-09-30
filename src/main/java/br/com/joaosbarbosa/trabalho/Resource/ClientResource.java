package br.com.joaosbarbosa.trabalho.Resource;
import br.com.joaosbarbosa.trabalho.Service.ClientService;
import br.com.joaosbarbosa.trabalho.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping("/clients")
public class ClientResource {
    @Autowired ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO dto){
        dto = clientService.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAllPages(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPages", defaultValue = "5") Integer linesPerPages,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction)
    {
        PageRequest pageRequest = PageRequest.of(page,linesPerPages, Sort.Direction.valueOf(direction), orderBy);
        Page<ClientDTO> list = clientService.findAllPages(pageRequest);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        ClientDTO clientDTO = clientService.searchById(id);

        return ResponseEntity.ok().body(clientDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO dto, @PathVariable Long id){
        dto = clientService.updateClient(dto, id);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws DataFormatException {
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
