package File_Uploding_Project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ProfileImageService
{

    public String uploadToCloudinary(MultipartFile file);

}
