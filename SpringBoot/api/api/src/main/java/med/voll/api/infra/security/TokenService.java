package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.voll.api.domain.usuario.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {
		
		try {
		    var algoritmo = Algorithm.HMAC256("12345678");
		   return JWT.create()
		        .withIssuer("API Voll.med")
		        .withSubject(usuario.getUsername())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritmo);
		} catch (JWTCreationException exception){
			throw new RuntimeException("Erro na geração do token jwt", exception);
		}
		
	}

	private Instant dataExpiracao() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	
	
}
