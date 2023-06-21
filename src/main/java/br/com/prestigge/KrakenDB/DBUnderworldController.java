package br.com.prestigge.KrakenDB;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dbunderworld")
public class DBUnderworldController {

    @PostMapping("/execute-script")
    public ResponseEntity<String> executeScript(@RequestBody String script) {
        System.out.println("Script recebido: " + script);

        String responseMessage = "O script foi executado com sucesso!";
        return ResponseEntity.ok().body(responseMessage);
    }
    
}