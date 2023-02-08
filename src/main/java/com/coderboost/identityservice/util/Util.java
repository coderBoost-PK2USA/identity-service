package com.coderboost.identityservice.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class Util {
    public static String getEncodedPassword(String plainPassword) {
        int strength = 10; // work factor of bcrypt
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        return bCryptPasswordEncoder.encode(plainPassword);
    }
//
//    public static long getPrincipalId(Authentication authentication) {
//        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
//        return userDetails.getUserId();
//    }
//
//    public static String getPrincipalUserName() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            return ((MyUserDetails) principal).getUsername();
//        }
//        return principal.toString();
//    }
}
