package me.lym.myspace.core.gateway.filter;

import me.lym.myspace.core.gateway.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    private static final String LOCALHOST = "";

    private static final String ADMIN_TOKEN = "{\"roles\":[\"admin\"]}";
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private TokenService tokenService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        //查看token header
        String token = request.getHeaders().getFirst("token");

        if (token != null) {
            String plainToken = null;
            Exception exception = null;

            try {
                plainToken = decryptToken(token);
                request.mutate().header("token",plainToken).build();
            } catch (NullPointerException e) {//token不合法

            } catch (IllegalArgumentException e) {//过期

            } catch (Exception e) {//未知错误

            }
            return chain.filter(exchange);
        }

        String hostName = request.getRemoteAddress().getHostName();
        if (LOCALHOST.equals(hostName)) {
            request.mutate().header("token",ADMIN_TOKEN).build();
            return chain.filter(exchange);
        }
        //从redis中获取
        token = redisTemplate.opsForValue().get("token_ip_" + hostName);
        if (token != null) {
            request.mutate().header("token",token).build();
            return chain.filter(exchange);
        }
        //带域名去uims获取
        token = tokenService.getTokenByIp(hostName);
        redisTemplate.opsForValue().set("token_ip_"+hostName,token);

        return chain.filter(exchange.mutate().request(request).build());
    }

    public String decryptToken(String encryptToken) {

        return encryptToken;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
