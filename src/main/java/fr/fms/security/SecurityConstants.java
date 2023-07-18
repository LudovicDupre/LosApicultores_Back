package fr.fms.security;

public class SecurityConstants {
    public static final String HEADER_STRING = "Authorization";
    public static final String SECRET = "test";
    public static final long EXPIRATION_TIME = 20*60*1000; // min-sec-millis
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String ERROR_MSG = "error-message";
}
