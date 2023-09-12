package com.jieun.velog.auth.jwt;


import com.jieun.velog.model.User;

public class JwtContext {
    private static final ThreadLocal<User> CONTEXT = new ThreadLocal<>();

    public static User getUserInfo() {
        User user = CONTEXT.get();
        return user == null ? User.builder().build() : user;
    }

    public static void setUserInfo(User user) {
        CONTEXT.set(user);
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
