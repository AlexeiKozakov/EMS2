package com.ems.security;

public interface SecurityConstants {
    String SECRET = "SecretKeyToGenJWTs";
    String TOKEN_PREFIX = "Bearer";
    String HEADER_STRING = "Authorization";
    String SIGN_UP_URL = "/user/sign-up";
    long EXPIRATION_TIME = 864_000_000;
}
