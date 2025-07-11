package com.amrut.prabhu.product;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.security.RolesAllowed;
import java.lang.reflect.Method;

@Aspect
@Component
public class RolesLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RolesLoggingAspect.class);

    @Pointcut("@annotation(rolesAllowed)")
    public void rolesAllowedPointcut(RolesAllowed rolesAllowed) {}

    @AfterReturning(value = "rolesAllowedPointcut(rolesAllowed)", argNames = "rolesAllowed")
    public void logRoles(RolesAllowed rolesAllowed) {
        String[] roles = rolesAllowed.value();
        logger.info("Roles allowed: {}", (Object) roles);
    }
}
