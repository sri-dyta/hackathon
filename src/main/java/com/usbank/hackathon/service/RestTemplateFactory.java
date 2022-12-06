package com.usbank.hackathon.service;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory
  implements FactoryBean<RestTemplate>, InitializingBean {
 
    private RestTemplate restTemplate;

    public RestTemplate getObject() {
        return restTemplate;
    }
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }
    public boolean isSingleton() {
        return true;
    }

	public void afterPropertiesSet() {

		HttpClient httpClient = HttpClients.custom().build();

		HttpHost host = new HttpHost("localhost", 8080, "http");
		/*
		 * restTemplate = new RestTemplate( new
		 * HttpComponentsClientHttpRequestFactory(host));
		 */

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(host),
				new UsernamePasswordCredentials("oZoIxY62Erg89cxou6cG3FoQHL4fEbKN", "4b0nuXp9eP6Em0Qh"));
		httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(credsProvider).build();

		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
	}
}