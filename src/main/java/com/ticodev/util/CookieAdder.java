package com.ticodev.util;

import javax.servlet.http.Cookie;

public class CookieAdder {

    protected static final int ONE_DAY = 24 * 60 * 60;
    protected static final String PLATFORM = "platform_visit";
    protected static final String BLOG = "blog_visit_";
    protected static final String BOARD = "board_visit_";

    public static Cookie getPlatformCookie() {
        Cookie cookie = new Cookie(PLATFORM, "true");
        cookie.setMaxAge(ONE_DAY);
        return cookie;
    }

    public static Cookie getBlogCookie(int blogNum) {
        Cookie cookie = new Cookie(BLOG + blogNum, "true");
        cookie.setMaxAge(ONE_DAY);
        return cookie;
    }

    public static Cookie getBoardCookie(int boardNum) {
        Cookie cookie = new Cookie(BOARD + boardNum, "true");
        cookie.setMaxAge(ONE_DAY);
        return cookie;
    }

}
