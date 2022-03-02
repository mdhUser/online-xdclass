package net.maxwellclass.online.xdclass.utils;

import io.jsonwebtoken.*;
import net.maxwellclass.online.xdclass.model.entity.User;

import java.util.Date;

/**
 * @description: JWT工具
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 21:29
 */
public class JWTUtils {

    //todo 过期时间一周
    private static final long EXPIRE = 60000 * 60 * 24 * 7;
    //todo 加密秘钥
    private static final String SECRET = "MaxwellClass.net168";
    //todo 令牌前缀
    private static final String TOKEN_PREFIX = "MaxwellClass";
    //todo subject
    private final static String SUBJECT = "MaxwellClass";

    /**
     * 根据用户信息，生成令牌 token
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();

        token = TOKEN_PREFIX + token;

        return token;
    }

    /**
     * 校验token的方法
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}