package com.ticodev.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieChecker extends CookieAdder {

    public static boolean hasPlatformCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(PLATFORM)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasBlogCookie(HttpServletRequest request, int blogNum) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(BLOG + blogNum)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasBoardCookie(HttpServletRequest request, int boardNum) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(BOARD + boardNum)) {
                return true;
            }
        }
        return false;
    }

}
