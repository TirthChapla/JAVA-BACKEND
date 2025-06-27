package File_Uploding_Project.controllers;

import File_Uploding_Project.Cloudinary.CloudService;
import File_Uploding_Project.dataHolders.PersonHolder;
import File_Uploding_Project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class PersonController
{

    @Autowired
    PersonService personService;

    @Autowired
    CloudService cloudService;


    @RequestMapping("/get-profile")
    public String getProfile()
    {
        return "index";
    }


    @RequestMapping("/add-profile")
    public String addProfile(Model model)
    {
        PersonHolder personHolder = new PersonHolder();

        model.addAttribute("personHolder" , personHolder);

        return "addProfile";
    }


    //❤️ This will finally save to CLOUD and URL to DB
    @RequestMapping ("/add-profile/submit")
    public String profileSubmited(@ModelAttribute PersonHolder personHolder , Model model)
    {

        System.out.println(personHolder.getName());
        System.out.println(personHolder.getProfile().getOriginalFilename());

        //We are Saving Image Locally
        try {

            if (!Files.exists(Paths.get("uploads/"))) {
                Files.createDirectories(Paths.get("uploads/"));
            }


        String profileName = personHolder.getProfile().getOriginalFilename();

        MultipartFile file = personHolder.getProfile();

        file.transferTo(Paths.get("uploads/"+profileName));


        //Save Image to Cloud
        String URL = cloudService.uploadToCloudinary(personHolder.getProfile());

        // Save Person info to DataBase
            personService.savePerson(personHolder , URL);

            model.addAttribute("url" , URL);

        }
        catch (Exception e)
        {
            System.out.println("Exception in Creating Uploads Folder \n OR \n Upload image to uploads");
            System.out.println(e.getMessage());
        }

        return "submit";
    }


}
