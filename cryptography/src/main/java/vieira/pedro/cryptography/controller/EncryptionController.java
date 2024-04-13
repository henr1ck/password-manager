package vieira.pedro.cryptography.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vieira.pedro.cryptography.service.EncryptionService;

@RestController
@RequestMapping(path = "/cryptography")
public class EncryptionController {

    private final EncryptionService encryptionService;

    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @PostMapping(path = "/encrypt/{secret}")
    public ResponseEntity<String> encrypt(@PathVariable(name = "secret") String secretAsTextPlain){
        String secretEncrypted = encryptionService.encrypt(secretAsTextPlain);
        return ResponseEntity.ok(secretEncrypted);
    }

    @PostMapping(path = "/decrypt/{secret}")
    public ResponseEntity<String> decrypt(@PathVariable(name = "secret") String secretEncrypted){
        String secretAsTextPlain = encryptionService.encrypt(secretEncrypted);
        return ResponseEntity.ok(secretAsTextPlain);
    }

}
