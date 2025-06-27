package File_Uploding_Project.service;

import File_Uploding_Project.dataHolders.PersonHolder;
import File_Uploding_Project.entity.Person;
import File_Uploding_Project.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService
{
    @Autowired
    PersonRepo personRepo;


    public void savePerson(PersonHolder personHolder , String url)
    {
        Person person= new Person();

        person.setName(personHolder.getName());
        person.setUserName(personHolder.getUserName());
        person.setFollowers(personHolder.getFollowers());
        person.setFollowing(personHolder.getFollowing());
        person.setAbout(personHolder.getAbout());
        person.setPostCount(personHolder.getPostCount());
        person.setUrl(url);

        personRepo.save(person);
    }




}
