package br.com.api.authority;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return null;
    }
}
