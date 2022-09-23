package com.Core_sobes;

import java.util.Arrays;

public enum Role {
    USER(18, 75),
    ADMIN(18, 75),
    PAPA(13, 43),
    SISTER(33, 90);

    int pre;
    int post;

    Role(int pre, int post) {
        this.pre = pre;
        this.post = post;
    }

}
class Client {
    static final int a = 128;
    static final int b = 128;

    public static void main(String[] args) {
        Role[] values = Role.values();
        System.out.println(values);
        System.out.println(Arrays.toString(values));
        System.out.println(Role.USER);
        System.out.println(Role.USER.pre + " " + Role.USER.post);
        System.out.println(Role.USER.ordinal()); // 0
        System.out.println();
        System.out.println(a == b);
    }
}
