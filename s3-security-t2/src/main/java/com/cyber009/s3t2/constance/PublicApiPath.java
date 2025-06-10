package com.cyber009.s3t2.constance;

import java.util.Set;

public class PublicApiPath {
    public static final Set<String> PUBLIC_API_PATHS = Set.of(
            ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_REGISTER,
            ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_REGISTER_VALIDATION,
            ApiPath.AuthPath.API_AUTH + ApiPath.AuthPath.API_AUTH_AUTHENTICATE
    );
}
