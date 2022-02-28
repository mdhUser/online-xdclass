package net.maxwellclass.online.xdclass;

import io.jsonwebtoken.Claims;
import net.maxwellclass.online.xdclass.model.entity.User;
import net.maxwellclass.online.xdclass.utils.CommonUtils;
import net.maxwellclass.online.xdclass.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineXdclassApplicationTests {

    @Test
    void contextLoads() {

        User user = new User();
        user.setName("mdh");
        user.setPhone("19534252989");
        user.setHeadImg(CommonUtils.getRandomImg());

        String token = JWTUtils.geneJsonWebToken(user);

        System.out.println("token = " + token);

        Claims claims = JWTUtils.checkJWT(token);
        System.out.println(claims.get("name"));


    }

}
