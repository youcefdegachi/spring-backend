package com.example.ecommerce.contoller;

import com.example.ecommerce.execeptions.NoClientExistInRepository;
import com.example.ecommerce.models.Client;
import com.example.ecommerce.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/client")
public class ClientController {
    @Autowired
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(clientService.getAll());
        }catch (NoClientExistInRepository e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("List Not Found");
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Client> add1(@RequestBody Client client) throws IOException {
        Client user = client.save(client);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/{ClientId}")
    public ResponseEntity<String> deleteClient(@PathVariable("ClientId") Long id){
        clientService.delete(clientService.findById(id));
        return ResponseEntity.ok().body("User with id "+id+" Deleted");
    }




//    public void deleteClient(@PathVariable(value = "id") long id) {
//        client.delete(client.findById(id));
//    }
}
