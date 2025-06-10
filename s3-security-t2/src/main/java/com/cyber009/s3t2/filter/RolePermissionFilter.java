package com.cyber009.s3t2.filter;

import com.cyber009.s3t2.constance.PublicApiPath;
import com.cyber009.s3t2.dto.EndPointDto;
import com.cyber009.s3t2.entity.UserLoginSessionEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class RolePermissionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        log.info("RolePermissionFilter: Processing request for URL: {}", request.getRequestURI());
        if(PublicApiPath.PUBLIC_API_PATHS.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }
        UserLoginSessionEntity sessionInfo = (UserLoginSessionEntity) request.getAttribute("session_info");
        log.info("RolePermissionFilter: Session info: {}", sessionInfo);
        if( sessionInfo == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        List<EndPointDto> endPointDtoList =
                mapper.readValue(sessionInfo.getRoleJson(), new TypeReference<>() {});
        boolean isEndpointAllowed = false;
        if(endPointDtoList != null && !endPointDtoList.isEmpty()) {
            for (EndPointDto endPoint : endPointDtoList) {
                if (request.getRequestURI().equals(endPoint.getEndPoint())) {
                    isEndpointAllowed = true;
                }
            }
        } else {
            log.warn("RolePermissionFilter: No permissions found for user.");
        }
        if(!isEndpointAllowed) {
            log.warn("RolePermissionFilter: Access denied for endpoint: {}", request.getRequestURI());
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
