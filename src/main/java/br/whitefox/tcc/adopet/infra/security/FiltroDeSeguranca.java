package br.whitefox.tcc.adopet.infra.security;

import br.com.whitefox.project.digital.med.domain.usuario.UsuarioRepository;
import br.whitefox.tcc.adopet.domain.login.UsuarioLoginRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Essa classe vai garantir que todos os métodos sejam bloqueados e acessados apenas
 * com o token gerado no login
 */
@Component
public class FiltroDeSeguranca extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioLoginRepository usuarioLoginRepository;

    /**
     * filterChain.doFilter(request,response): necessário para chamar os próximos
     * filtros na aplicação
     * var subject = tokenService.getSubject(tokeJWT): valida o token recebido
     *-----------------------------------------------------------------------------------------------------------------
     * Garante que o usuário ao dar Login carregue o Token:
     *  var usuario = usuarioRepository.findByLogin(subject);
     *             var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
     *             SecurityContextHolder.getContext().setAuthentication(authentication);
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);
        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = usuarioLoginRepository.findByLogin(subject);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer", "");
        }
        return null;
    }
}
