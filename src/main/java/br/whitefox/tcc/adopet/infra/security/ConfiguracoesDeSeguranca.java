package br.whitefox.tcc.adopet.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfiguracoesDeSeguranca {

    @Autowired
    private FiltroDeSeguranca filtroDeSeguranca;

    /**
     * CSRF Cross-Site Request Forgery:
     * .csrf desabilita o forge pois o proprio token a ser usado proteje do ataque acima;
     * ------------------------------------------------------------------------------------
     * sessionManagement:
     * mostra como vai ser o gerenciamento da Seção
     * ------------------------------------------------------------------------------------
     * sessionCreationPolicy:
     * Cria a politica da seção
     * ------------------------------------------------------------------------------------
     * O Spring usa STATEFULL (que devolve a chave Token para inicio da seção,
     * baseado em formulario e cockies.
     * mudamos para STATELESS para implementar nosso método de autenticação
     * ------------------------------------------------------------------------------------
     *.and().addFilterBefore(filtroDeSeguranca, UsernamePasswordAuthenticationFilter.class):
     * Essa linha adiciona a ordem dos filtros a serem utilizados
     *
     * @param http
     * @return
     * @Bean devolve um objeto para o Spring
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and().addFilterBefore(filtroDeSeguranca, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    /**
     * Método que configuara a injeção do AuthenticationManager usaso na classe AutenticacaoController
     * O @Bean serve para exportar uma classe para o Spring, fazendo com que ele consiga
     * carrega-la e realize a sua injeção de dependencia em outras classes
     * @param configuration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

