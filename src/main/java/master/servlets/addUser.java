package master.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import master.beans.Etudiant;
import master.dao.factory.OraFactory;
import master.dao.interfaces.EtudiantDao;

import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
@MultipartConfig
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");        
		String prenom = request.getParameter("prenom");
		String cin = request.getParameter("cin");
		String telephone = request.getParameter("telephone");
		String date_n = request.getParameter("date_n");
		String sexe = request.getParameter("sexe");
		String massar = request.getParameter("massar");
		String nationalite = request.getParameter("nationalite");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fac = request.getParameter("fac");
		String date_graduation = request.getParameter("date_graduation");
		String date_premiere_inscription = request.getParameter("date_premiere_inscription");
		String fil_license = request.getParameter("fil-license");
		String fil_bac = request.getParameter("fil-bac");
		String moy_bac = request.getParameter("moy-bac");
		String moy_lic = request.getParameter("moy-lic");
		String n_s1 = request.getParameter("n_s1");
		String n_s2 = request.getParameter("n_s2");
		String n_s3 = request.getParameter("n_s3");
		String n_s4 = request.getParameter("n_s4");
		String n_s5 = request.getParameter("n_s5");
		String n_s6 = request.getParameter("n_s6");
		//Part docs = request.getPart("docs");
		// Printing out the values
		System.out.println("Nom: " + nom);
		System.out.println("Prenom: " + prenom);
		System.out.println("CIN: " + cin);
		System.out.println("Telephone: " + telephone);
		System.out.println("Date de Naissance: " + date_n);
		System.out.println("Sexe: " + sexe);
		System.out.println("Massar: " + massar);
		System.out.println("Nationalite: " + nationalite);
		System.out.println("Email: " + email);
		System.out.println("Password: " + password);
		System.out.println("Faculté: " + fac);
		System.out.println("Date de Graduation: " + date_graduation);
		System.out.println("Date Première Inscription: " + date_premiere_inscription);
		System.out.println("Filière License: " + fil_license);
		System.out.println("Filière Bac: " + fil_bac);
		System.out.println("Moyenne Bac: " + moy_bac);
		System.out.println("Moyenne License: " + moy_lic);
		System.out.println("Note S1: " + n_s1);
		System.out.println("Note S2: " + n_s2);
		System.out.println("Note S3: " + n_s3);
		System.out.println("Note S4: " + n_s4);
		System.out.println("Note S5: " + n_s5);
		System.out.println("Note S6: " + n_s6);
		//create another input field for the image 
		//create Etudiant object containing all this attribute (you can use setters or create a constructor in the bean)
		Etudiant e = new Etudiant();
		EtudiantDao etd = OraFactory.getUserDao();
		etd.addEtudiant(e);
	}

}
