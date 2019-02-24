package io.pivotal.cloudnativespringui;

import io.pivotal.cloudnativespring.domain.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CloudNativeSpringUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNativeSpringUiApplication.class, args);
    }

    @FeignClient(value = "cloud-native-spring", fallback = CityClientFallback.class)
    interface CityClient {
        @RequestMapping(method = RequestMethod.GET, value = "/cities", produces = "application/hal+json")
        PagedResources<City> getCities();
    }

    @Component
    public class CityClientFallback implements CityClient {
        @Override
        public PagedResources<City> getCities() {
            //We'll just return an empty response
            PagedResources<City> emptyCollection = new PagedResources<City>(new ArrayList<City>(), null);
            return emptyCollection;
        }
    }

    //    @Bean
    //    public CommandLineRunner loadData(CityClient cityClient) {
    //        return (args) -> {
    //            cityClient.getCities()
    //                      .forEach(System.out::println);
    //        };
    //    }
}
