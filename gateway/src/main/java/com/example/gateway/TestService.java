package com.example.gateway;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestService {

    @Autowired
    private EurekaClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("A-SERVICE", false);
        return instance.getHomePageUrl();
    }

    public String callService(){

            ResponseEntity<String> exchange =
                    this.restTemplate.exchange(
                            "http://A-SERVICE/hello",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<String>() {
                            });

            return exchange.getBody();
        }

    }


