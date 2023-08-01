package com.example.security;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@AuthenticationPrincipal   // Authentication객체에서 Principal에 담아놓은 것을 달라는 의미
@Retention(RUNTIME)
public @interface AuthenticatedUser {

}
