package File_Uploding_Project.Cloudinary;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CloudConfig
{
    @Value("${cloudinary.cloud.name}")
    String cloud_name;

    @Value("${cloudinary.cloud.api.key}")
    String api_key;

    @Value("${cloudinary.cloud.api.secret}")
    String api_secret;

    @Bean
    public Cloudinary cloudinary()
    {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name",cloud_name,
                        "api_key",api_key,
                        "api_secret",api_secret
                )
        );
    }
}
