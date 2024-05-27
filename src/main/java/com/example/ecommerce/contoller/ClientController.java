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
import java.util.Optional;
import java.util.regex.Pattern;

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
//    @PostMapping("/add")
//    public ResponseEntity<Client> add1(@RequestBody Client client) throws IOException {
//        Client user = client.save(client);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
    @PostMapping("/add")
    public ResponseEntity<?> add1(@RequestBody Client client) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (pattern.matcher(client.getEmail()).matches()) {
            Client savedClient = clientService.save(client);
            return new ResponseEntity<>(savedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email address", HttpStatus.BAD_REQUEST);
        }
    }



    @DeleteMapping("/{ClientId}")
    public ResponseEntity<String> deleteClient(@PathVariable("ClientId") Long id){
        clientService.delete(clientService.findById(id));
        return ResponseEntity.ok().body("User with id "+id+" Deleted");
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Client loginRequest) {
        Optional<Client> client = clientService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }
//    public void deleteClient(@PathVariable(value = "id") long id) {
//        client.delete(client.findById(id));
//    }
}
