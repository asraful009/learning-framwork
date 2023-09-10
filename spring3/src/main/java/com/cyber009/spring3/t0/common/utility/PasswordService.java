package com.cyber009.spring3.t0.common.utility;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordService {
    private final String[] peppers;



    public byte[] generateSalt16Byte() {
        SecureRandom rand = new SecureRandom();
        byte[] salt = new byte[16];
        rand.nextBytes(salt);
        return salt;
    }

    public byte[] generatorPassword(byte[] salt, byte[] userName, byte[] password) {
        byte[] result = new byte[1024];
        byte [] saltedPassword = new byte[salt.length + password.length + userName.length];
        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(password, 0, saltedPassword, salt.length, password.length);
//        System.arraycopy(userName, 0, saltedPassword, salt.length + password.length, salt.length + password.length + userName.length);

        passwordEncoder().generateBytes(saltedPassword, result, 0, result.length);
        return result;
    }

    public String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexStringBuilder.append(String.format("%02X", b));
        }
        return hexStringBuilder.toString();
    }


    private Argon2BytesGenerator passwordEncoder() {
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id);

        // Configure Argon2 parameters
        builder.withVersion(Argon2Parameters.ARGON2_VERSION_13);
        builder.withSalt(generatePaper16Byte()); // Set a salt like Paper
        builder.withMemoryAsKB(65536); // Set memory cost in kilobytes
        builder.withParallelism(4); // Set parallelism factor
        builder.withIterations(2); // Set number of iterations

        Argon2BytesGenerator generate = new Argon2BytesGenerator();
        generate.init(builder.build());
        return generate;
    }

    private byte[] generatePaper16Byte() {
        SecureRandom rand = new SecureRandom();
        String pepper = (peppers != null && peppers.length > 0) ?
                peppers[ rand.nextInt(peppers.length * 13) % peppers.length ]:
                "dba968ab1f39c28c95cc2db553cbe582f2537d21d65a88aa860a27b8d312ce3da43ed79fbc202c954c888f99206e1822";
        if (pepper.length() % 2 != 0) {
            pepper = "dba968ab1f39c28c95cc2db553cbe582f2537d21d65a88aa860a27b8d312ce3da43ed79fbc202c954c888f99206e1822";
        }

        int len = 16;
        byte[] byteArray = new byte[len];

        for (int i = 0; i < len; i++) {
            int index = i * 2;
            int high = Integer.parseInt(pepper.substring(index, index + 2), 16);
            byteArray[i] = (byte) high;
        }

        return byteArray;
    }

}
