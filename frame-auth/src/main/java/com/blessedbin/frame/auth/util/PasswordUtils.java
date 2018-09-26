package com.blessedbin.frame.auth.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubin on 2018/8/2.
 *
 * @author 37075
 * @date 2018/8/2
 * @time 16:53
 * @tool intellij idea
 */
public class PasswordUtils {

    public static PasswordEncoder createDelegatingPasswordEncoder() {
        return createDelegatingPasswordEncoder("bcrypt");
    }

    @SuppressWarnings("unchecked")
    public static PasswordEncoder createDelegatingPasswordEncoder(String encodingId) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("ldap", new LdapShaPasswordEncoder());
        encoders.put("MD4", new Md4PasswordEncoder());
        encoders.put("MD5", new MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("SHA-1", new MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256", new MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("sha256", new StandardPasswordEncoder());

        return new DelegatingPasswordEncoder(encodingId, encoders);
    }

    public static PasswordEncoder noopPasswordEncoder(){
        return createDelegatingPasswordEncoder("noop");
    }

}
