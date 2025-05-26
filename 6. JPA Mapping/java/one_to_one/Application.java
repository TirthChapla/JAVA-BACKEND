package one_to_one;

import one_to_one.entity.Certificate;
import one_to_one.entity.Student;
import one_to_one.reposititory.CertificateRepo;
import one_to_one.reposititory.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Autowired
	StudentRepo studentRepo;

	@Autowired
	CertificateRepo certificateRepo;


	@Override
	public void run(String... args) throws Exception
	{
		//saveToDB();

		//❤️ We are taking Data from Data-Base...


		Certificate c1 = certificateRepo.findById(1).orElseThrow(() -> new RuntimeException("Certificate not found"));
		System.out.println(c1.getTitle());

		Student s1 = c1.getStudent();

		System.out.println(s1.getName());



	}

	public void saveToDB()
	{
		//❤️ This is for Data Adding...

		// ✅ 1. Create object of Student n Certificate
		Student student = new Student();
		Certificate certificate = new Certificate();

		// ✅ 2. Adding the values of students
		student.setName("Harsh");
		student.setEmail("harsh@gmail.com");

		// ✅ 3. We save Student First.
		Student savedStudent =  studentRepo.save(student);
		System.out.println("Student Saved First");

		// ✅ 4.Adding the values of Certificate
		certificate.setTitle("Java BackendX");
		certificate.setDescription("great Project work");
		certificate.setStudent(savedStudent);

		// ✅ 5.Add the certificate to the Student
		savedStudent.setCertificate(certificate);

		// ✅ 6.Saving the Certifiecte
		certificateRepo.save(certificate);

	}
}
