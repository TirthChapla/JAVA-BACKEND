package File_Uploding_Project.Cloudinary;

import File_Uploding_Project.service.ProfileImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;


@Service
public class CloudService implements ProfileImageService
{
    private Cloudinary cloudinary;

    public CloudService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadToCloudinary(MultipartFile file)
    {

        try
        {
            String filename = String.valueOf(UUID.randomUUID());

            //✅ We created the byte array size of the image
            byte[] data = new byte[file.getInputStream().available()];

            //✅ this will add the file -> data
            file.getInputStream().read(data);

            //✅ this Upload to Cloudinary
            cloudinary.uploader().upload(data , ObjectUtils.asMap(
                    "public_id",filename
            ));

            return getURL(filename);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);

        }
    }

    public String getURL(String publicID)
    {
        //This will Give us URL
        return cloudinary
                .url()
                .secure(true)
                .transformation(
                        new Transformation<>()
                                .width(500)
                                .height(500)
                                .crop("fill"))
                .generate(publicID);
    }
}
