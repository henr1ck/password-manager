package vieira.pedro.cryptography.service;

import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String encrypt(String secretAsTextPlain){
        StringBuilder builder = new StringBuilder();
        int length = secretAsTextPlain.length();
        for (int i = length - 1; i >= 0; i--){
            Character c = secretAsTextPlain.charAt(i);
            builder.append(c);
        }
        return builder.toString();
    }

    public String decrypt(String secretEncrypted){
        return encrypt(secretEncrypted);
    }
}
