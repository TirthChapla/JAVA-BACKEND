package File_Uploding.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@RestController
@RequestMapping("/images")
public class FileHandling
{
    @PostMapping
    public String uploadImages(@RequestParam("file") MultipartFile file ) throws Exception
    {

        String filename = file.getOriginalFilename();

        String directory = "uploads/";

        if(!Files.exists(Paths.get(directory)))
        {
            Files.createDirectories(Paths.get(directory));
            System.out.println("Directory Created");
        }

        String imagePath = directory + filename;

        Path path = Paths.get(directory + filename);

        // Save the file to the specified path
        file.transferTo(path);


        return filename + " Uploaded SuccessFully ";
    }
}
