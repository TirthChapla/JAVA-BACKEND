package quiz_App_Service.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableFeignClients
public class ProjectConfig
{
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//---------------------------------------------------------------------------

/// WEB CLIENT ne 1st time configure kar va we use this

//    @Bean
//    public WebClient webClient()
//    {
//        return WebClient
//                .builder()
//                .baseUrl("http://localhost:9091")
//                .build();
//    }
//----------------------------------------------------------------------------


///✅✅ Now we have to apply the LOAD BALANCER to the WEB CLIET

// we can't apply to Web Clint directly

///❤️❤️ we have to apply on WebCLient.Builer


    @Bean
    @LoadBalanced
    public WebClient.Builder webClient()
    {
        return WebClient.builder();
    }

}
