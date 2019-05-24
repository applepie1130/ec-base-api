package cj.configuration;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
//	private static final String CLIENT_ID = "order";
//	private static final String CLIENT_SECRET = "order";
//	private static final String AUTH_SERVER = "localhost:8081";
	
	@Bean
	public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("cj.api.controller");
		
		ArrayList<ResponseMessage> responseMessageStatus = newArrayList( 
				new ResponseMessageBuilder().code(400).message("Invalid request").build(),
				new ResponseMessageBuilder().code(401).message("No permission").build(),
				new ResponseMessageBuilder().code(500).message("Error request").build()
        );
		
		return docket.select()
				.apis(basePackage)
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.globalResponseMessage(RequestMethod.GET, responseMessageStatus)
				.globalResponseMessage(RequestMethod.POST, responseMessageStatus)
				.globalResponseMessage(RequestMethod.PUT, responseMessageStatus)
				.globalResponseMessage(RequestMethod.DELETE, responseMessageStatus)
				.useDefaultResponseMessages(false);
	}
	
	/**
	 * API Documents Information
	 * @return
	 */
	private ApiInfo apiInfo() {
		
		String titme = "EC-BASE-API Documents";
		String version = "0.0.1";
		String license = "CJ ENM All rights reserved";
		
		return new ApiInfoBuilder()
				.title(titme)
				.version(version)
				.license(license)
				.build();
	}
	
//	@Bean
//	public SecurityConfiguration security() {
//	    return SecurityConfigurationBuilder.builder()
//	        .clientId(CLIENT_ID)
//	        .clientSecret(CLIENT_SECRET)
//	        .scopeSeparator(" ")
//	        .useBasicAuthenticationWithAccessCodeGrant(true)
//	        .build();
//	}
//	
//	/**
//	 * Security Scheme
//	 * @return
//	 */
//	private SecurityScheme securityScheme() {
//	    GrantType grantType = new AuthorizationCodeGrantBuilder()
//	        .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
//	        .tokenRequestEndpoint(
//	          new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
//	        .build();
//	 
//	    SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
//	        .grantTypes(Arrays.asList(grantType))
//	        .scopes(Arrays.asList(scopes()))
//	        .build();
//	    return oauth;
//	}
//	
//	/**
//	 * Authorization Scope
//	 * @return
//	 */
//	private AuthorizationScope[] scopes() {
//	    AuthorizationScope[] scopes = { 
//	      new AuthorizationScope("read", "for read operations"), 
//	      new AuthorizationScope("write", "for write operations"), 
//	      new AuthorizationScope("foo", "Access foo API") };
//	    return scopes;
//	}
//	
//	/**
//	 * Authorization SecurityContext
//	 * @return
//	 */
//	private SecurityContext securityContext() {
//	    return SecurityContext.builder()
//	      .securityReferences(
//	        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
//	      .forPaths(PathSelectors.regex("/v1.*"))
//	      .build();
//	}
}
