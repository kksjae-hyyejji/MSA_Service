package shop.msa.product.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import shop.msa.product.exception.CustomException;
import shop.msa.product.exception.ErrorCode;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final DiscoveryClient discoveryClient;

    /**
     * k8s에 올릴 시 서버 자동 증설 방식에 따라 WebClient를 Configuration으로 둘지,
     * ProductServiceImpl에서 매번 getInstance를 해야하는지 확실하지 않음. (지식 부족)
     * 1. host명으로 추적이 가능
     *     - Bean으로 등록해서 설정할 수 있다.
     *
     * 2. 추적 불가
     *     - 매번 Service에서 Instance 받아야 한다.
     *
     * 현재 코드는 Spring cloud에서 Cart를 찾아서 미리 WebClient에 설정해둠, 1번 버전임.
     * [나중에 반드시 고쳐야 함]
     */
    @Bean
    public WebClient cartWebClient() {

        ServiceInstance instance = discoveryClient.getInstances("Cart")
                .stream()
                .findFirst()
                .orElseThrow(() -> new CustomException(ErrorCode.INTERNAL_SERVER_ERROR));

        return WebClient.builder().baseUrl(instance.getUri().toString() + "/cart/add").build();
    }
}
