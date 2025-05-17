package com.JDBC_project;

import com.JDBC_project.DAO.BookDao;
import com.JDBC_project.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class JdbcLibraryProjectApplication implements CommandLineRunner
{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		SpringApplication.run(JdbcLibraryProjectApplication.class, args);
	}

	@Autowired
	private BookDao bookDao;



	@Override
	public void run(String... args) throws Exception
	{



		try
		{
			while(true)
			{
				System.out.println();
				System.out.println();
				System.out.println("=*=*=*=*=*=*==** LIBRARY MANAGEMENT SYSTEM   ==*=*=*=*==**==*=*=*=*=*=*=*=*");
				System.out.println();

				System.out.println("Enter 1 for Add book");
				System.out.println("Enter 2 for View All books");
				System.out.println("Enter 3 for Search book By Title");
				System.out.println("Enter 4 for Search book By Id");
				System.out.println("Enter 5 for Update book");
				System.out.println("Enter 6 for Delete book");
				System.out.println("Enter 7 for Exit Application ");

				System.out.println();
				System.out.println("Enter the Choice : ");
				int choice = Integer.parseInt(br.readLine());

				if (choice == 1)
				{
					// Add book

					Book book = input();

					bookDao.save(book);
					System.out.println("Book Added Succesfully...");

				}
				else if (choice == 2)
				{
					// Get All Books

					List<Book> listbook;

					listbook = bookDao.getAll();

					displayListBook(listbook);

				}
				else if (choice == 3)
				{
					// Search book By Title

					System.out.println("Enter the Title to Search Book : ");
					String title = br.readLine();

					List<Book> listbook = bookDao.search(title);

					displayListBook(listbook);

				}
				else if (choice == 4)
				{
					// Search book By ID
					System.out.println("Enter the Id to Search Book : ");
					int id = Integer.parseInt(br.readLine());

					Book book = bookDao.get(id);

					System.out.printf("%-5s %-20s %-25s %-20s %-15s %-10s%n",
							"ID", "Title", "About", "Author", "Language", "Available");
					System.out.println("-----------------------------------------------------------------------------------------------");

					System.out.printf("%-5d %-20s %-25s %-20s %-15s %-10s%n",
							book.getId(),
							book.getTitle(),
							book.getAbout(),
							book.getAuthor(),
							book.getLanguage(),
							book.getAvailable() ? "Yes" : "No");

				}
				else if (choice == 5)
				{
					// Updte book

					System.out.println("Enter the ID of Book to update : ");
					int id = Integer.parseInt(br.readLine());

					System.out.println("Enter the Book Details to update : ");
					Book book = input();

					bookDao.update(id,book);


				} else if (choice == 6)
				{
					// delete Book
					System.out.println("Enter the ID of Book to Delete : ");
					int id = Integer.parseInt(br.readLine());

					bookDao.delete(id);


				} else if (choice == 7) {
					// Exit Application
					break;
				}
				else {
					System.out.println("Invalid choice. Please try again.");
				}


			}




		}
		catch (Exception e)
		{
			System.out.println("Error Occured" + e.getMessage());
		}

		System.out.println("Thank You!!❤️ ");

	}


	public Book input()
	{
		Book book = new Book();

		try
		{

			System.out.print("Enter Book Title: ");
			book.setTitle(br.readLine());

			System.out.print("Enter About Book: ");
			book.setAbout(br.readLine());

			System.out.print("Enter Author Name: ");
			book.setAuthor(br.readLine());

			System.out.print("Enter Language: ");
			book.setLanguage(br.readLine());

//			System.out.print("Is Book Available? (yes/no): ");
//			book.setAvailable(br.readLine());

			System.out.print("Is Book Available? (yes/no): ");
			String availability = br.readLine();  // "yes" or "no"
			boolean available = availability.equalsIgnoreCase("yes") ? true : false;

			book.setAvailable(available);
		}
		catch (Exception e )
		{
			System.out.println("Error in Input Book = " + e.getMessage());
		}

        return book;
    }


	public void displayListBook(List<Book> listbook)
	{
		System.out.printf("%-5s %-20s %-25s %-20s %-15s %-10s%n",
				"ID", "Title", "About", "Author", "Language", "Available");
		System.out.println("-----------------------------------------------------------------------------------------------");

		for (Book book : listbook) {
			System.out.printf("%-5d %-20s %-25s %-20s %-15s %-10s%n",
					book.getId(),
					book.getTitle(),
					book.getAbout(),
					book.getAuthor(),
					book.getLanguage(),
					book.getAvailable() ? "Yes" : "No");
		}
	}

}
