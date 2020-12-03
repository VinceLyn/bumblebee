package com.robots.bumblebee.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JWTService {
    private JWTVerifier verifier = JWT.require(Algorithm.HMAC256("sec9527")).withIssuer("server1").build();

    public String createToken(String account){
        String secret = "sec9527";
        Algorithm alg = Algorithm.HMAC256(secret);
        //头部信息
        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");

        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime()+ TimeUnit.SECONDS.toMinutes(5)*1000);

        String sign = JWT.create()
                .withHeader(map)
                .withIssuer("server1")
                .withSubject("sub1")
                .withAudience("humblebee")
                .withIssuedAt(nowDate)
                .withExpiresAt(expireDate)
                .withClaim("account",account)
                .sign(alg);
        return sign;
    }
    public DecodedJWT verifyToken(String token){
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT;
    }
}
