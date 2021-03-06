package by.birukov.security.jwt;

import by.birukov.security.SecurityConstants;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstants.HEADER);
//        String pass = request.getAttribute();
        if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuth(request, response);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuth(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(SecurityConstants.HEADER);
        if (token != null) {
            String username = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .verify(token.replace(SecurityConstants.TOKEN_PREFIX, ""))
                    .getSubject();
            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
            }
            return null;
        }
        return null;

    }
}
