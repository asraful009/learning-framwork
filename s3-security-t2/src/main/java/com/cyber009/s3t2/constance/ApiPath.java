package com.cyber009.s3t2.constance;

public class ApiPath {
    public static final String API_BASE = "/api";
    public static class AuthPath {
        public static final String API_AUTH = API_BASE+ "/auth";
        public static final String API_AUTH_REGISTER = API_AUTH + "/register";
        public static final String API_AUTH_AUTHENTICATE = API_AUTH + "/authenticate";
    }
}
