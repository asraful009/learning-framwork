package com.cyber009.s3t2.constance;

public class ApiPath {
    public static final String API_BASE = "/api";
    public static class AuthPath {
        public static final String API_AUTH = API_BASE+ "/auth";
        public static final String API_AUTH_REGISTER = API_AUTH + "/register";
        public static final String API_AUTH_REGISTER_VALIDATION = API_AUTH_REGISTER + "/validation";
        public static final String API_AUTH_AUTHENTICATE = API_AUTH + "/authenticate";
    }

    public static class HomePath {
        public static final String API_HOME = API_BASE + "/home";
        public static final String API_PAGE_1 = API_HOME + "/page1";
        public static final String API_PAGE_2 = API_HOME + "/page2";
        public static final String API_PAGE_3 = API_HOME + "/page3";
        public static final String API_PAGE_4 = API_HOME + "/page4";
    }
}
