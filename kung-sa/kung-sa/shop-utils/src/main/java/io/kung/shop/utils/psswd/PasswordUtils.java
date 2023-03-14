package io.kung.shop.utils.psswd;

import io.kung.shop.utils.md5.MD5Hash;

/**
 * @Author kung
 * @Date 2023/2/22 15:19
 * @Version 1.0.0
 * @Description 密码工具类
 */
public class PasswordUtils {

    public static String getPassword(String password) {
        if (password == null || password.trim().isEmpty()) return password;
        for (int i = 0; i < 5; i++) {
            password = MD5Hash.md5Java(password);
        }
        return password;
    }
}
