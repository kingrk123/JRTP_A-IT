package in.ashokit;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	
	public static String generateToken(String subject, String secretKey) {
		
	return Jwts.builder()
			.setId("tk9931")
			.setSubject(subject)
			.setIssuer("Ashok IT")
			.setAudience("ABC_IT")
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(1)))
			.signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encode(secretKey.getBytes()))
			.compact();
	}
	
	public static void main(String[] args) {
		String secretKey = "mysecret@1";
		String subject = "mytoken";

		//Generating Token
		String token = JWTUtil.generateToken(subject, secretKey);
		//printing token
		System.out.println(token);
		
		//code to parse the token
		JwtParser parser = Jwts.parser();
		Claims claims = parser.setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
							  .parseClaimsJws(token)
							  .getBody();

		//Printing token information
		System.out.println("Token ID : " + claims.getId());
		System.out.println("Token Issued By : " + claims.getIssuer());
		System.out.println("Token Generated :: "+ claims.getIssuedAt());
		System.out.println("Token Expiry :: " +claims.getExpiration());
	}
}
