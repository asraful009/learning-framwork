package com.cyber009.s3t2.constance;

public class ApiPath {
    public static final String API_BASE = "/api";
    public static class AuthPath {
        public static final String API_AUTH = API_BASE+ "/auth";
        public static final String API_AUTH_REGISTER = "/register";
        public static final String API_AUTH_REGISTER_VALIDATION = API_AUTH_REGISTER + "/validation";
        public static final String API_AUTH_AUTHENTICATE = "/authenticate";
    }

    public static class HomePath {
        public static final String API_HOME = API_BASE + "/home";
        public static final String API_PAGE_1 = "/page1";
        public static final String API_PAGE_2 = "/page2";
        public static final String API_PAGE_3 = "/page3";
        public static final String API_PAGE_4 = "/page4";
    }
}
