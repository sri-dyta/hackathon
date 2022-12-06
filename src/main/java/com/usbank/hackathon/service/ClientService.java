package com.usbank.hackathon.service;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.Collections;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.usbank.hackathon.constants.constants;
import com.usbank.hackathon.model.customer;


@Component
public class ClientService extends constants  {

@Value("${api.key}")
String apikey;
@Value("${api.password}")
String apiPwd;


/*@Autowired
private RestTemplateConfig restTemplate;*/
   
//private final RestTemplate restTemplate;

/*public ClientService(RestTemplateBuilder restTemplateBuilder){
	 this.restTemplate = restTemplateBuilder
	            .basicAuthentication("oZoIxY62Erg89cxou6cG3FoQHL4fEbKN", "4b0nuXp9eP6Em0Qh")
	            .build();
}*/

	public String getCustomerDetails() throws URISyntaxException, JSONException {
		customer cust = null;

		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		// RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8");
		headers.set("Accept", "*/*");
		//headers.setBasicAuth("6ARja9QhExADmFvmJu5RX9IUHcj1YclT", "B5X4glob6ueluu3a");
		headers.set("Content-Security-Policy", "default-src 'self';");
		String token = new String(
				Base64.getEncoder().encode((apikey + ":" + apiPwd).getBytes()));
		// headers.add("Authorization", "Basic " + token);
		HttpEntity<?> request = new HttpEntity<>(headers);
		// logger.info(request.toString());
		// UriComponentsBuilder builder =
		// UriComponentsBuilder.fromHttpUrl(base_url_customer+"6789879086").queryParam("grant_type",
		// "client_credentials");
		// logger.info("URI -" + builder.toUriString());
		// ResponseEntity<String> response =
		// restTemplate.exchange(builder.build().encode().toUri(),
		// HttpMethod.GET,request, String.class);
		// logger.info("Response" + response.getBody());

		// RestTemplate restTemplate = new RestTemplate();
		// JSONObject notificationDataJson = new JSONObject(data);
		// logger.info("notificationDataJson is : {}", notificationDataJson);
		// HttpHeaders headers = new HttpHeaders();
		// headers.set("Correlation-ID", (String)
		// notificationDataJson.get("correlationId"));
		// headers.set("apiKey", "8565SdE-18E4cB12a-246e32C-FfF8E6A1f"); //
		// hard-coded
		headers.set("Accept-Encoding", "gzip, deflate, br");
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		// HttpEntity<String> httpEntity = new
		// HttpEntity<>(notificationDataJson.get("message").toString(),
		// headers);
		// String url =
		// "https://it4-digital-auth-api.us.bank-dns.com/digital-auth/fraudprevention/aedfbariskanalyzer/v1/analyze-risk";
		// String respEntity = restTemplate.getf(base_url_customer+"6789879086",
		// request);
		// logger.info("SharedAuth Response : "+ respEntity);

		final String baseUrl = "https://it-api.usbank.com/innovation/bank-node/customer-accounts/v1/customer/6789879086";
		URI uri = new URI(baseUrl);

		HttpEntity<customer> requestEntity = new HttpEntity<>(null, headers);

		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

		/*
		 * final JSONObject obj = new JSONObject(String.valueOf(result)); final
		 * JSONArray customerData = obj.getJSONArray("customer");
		 */
		/*
		 * String customerFirstName = customerData.getgetString("firstName");
		 * String customerLastName = customerData.getString("lastName");
		 */

		System.out.println(result);
		return result.toString();

	}

}