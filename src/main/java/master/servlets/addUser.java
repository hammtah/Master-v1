package master.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import master.beans.Etudiant;
import master.beans.FilieresLicense;
import master.dao.factory.OraFactory;
import master.dao.interfaces.EtudiantDao;
import master.dao.interfaces.FacultesDao;
import master.dao.interfaces.FilieresLicenseDao;

import java.io.IOException;
import java.util.Scanner;

@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
@MultipartConfig
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//graber tout les filieres de licenses et les forwarder vers la jsp de signup
		FilieresLicenseDao fld = OraFactory.getFilieresLicenseDao();
		FacultesDao fad = OraFactory.getFacultesDao();
		
		request.setAttribute("facultes", fad.getAllFacultes());
		request.setAttribute("filieres", fld.getFilieresLicense());
		/*for(FilieresLicense fl: fld.getFilieresLicense()) {
			System.out.println("id: "+ fl.getId_filiere());
			System.out.println("nom: "+ fl.getNom());
			System.out.println("Surnom: "+ fl.getSurnom());

		}*/
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
		//String fac = request.getParameter("fac");
		String date_graduation = request.getParameter("date_graduation");
		String date_premiere_inscription = request.getParameter("date_premiere_inscription");
		String date_bac = request.getParameter("date_bac");
		//String fil_license = request.getParameter("fil-license");
		String fil_bac = request.getParameter("fil-bac");
		String moy_bac = request.getParameter("moy-bac");
		String moy_lic = request.getParameter("moy-lic");
		String n_s1 = request.getParameter("n_s1");
		String n_s2 = request.getParameter("n_s2");
		String n_s3 = request.getParameter("n_s3");
		String n_s4 = request.getParameter("n_s4");
		String n_s5 = request.getParameter("n_s5");
		String n_s6 = request.getParameter("n_s6");
		Part docs = request.getPart("docs");
		Part photo = request.getPart("photo");
		// Printing out the values
		/*
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
		//System.out.println("Faculté: " + fac);
		System.out.println("Date de Graduation: " + date_graduation);
		System.out.println("Date Première Inscription: " + date_premiere_inscription);
		//System.out.println("Filière License: " + fil_license);
		System.out.println("Filière Bac: " + fil_bac);
		System.out.println("Moyenne Bac: " + moy_bac);
		System.out.println("Moyenne License: " + moy_lic);
		System.out.println("Note S1: " + n_s1);
		System.out.println("Note S2: " + n_s2);
		System.out.println("Note S3: " + n_s3);
		System.out.println("Note S4: " + n_s4);
		System.out.println("Note S5: " + n_s5);
		System.out.println("Note S6: " + n_s6);
		*/
		//create another input field for the image 
		//create Etudiant object containing all this attribute (you can use setters or create a constructor in the bean)
		/*Etudiant e = new Etudiant(
			    0, // Assuming id is auto-generated or set later
			    nom,
			    prenom,
			    date_n,
			    sexe,
			    telephone,
			    email,
			    password,
			    nationalite,
			    cin,
			    massar,
			    date_bac, 
			    date_graduation,
			    docs, // Assuming photo is not provided during object creation
			    photo, // Assuming docs is not provided during object creation
			    fil_bac,
			    1,
			    1,
			    Integer.parseInt(moy_bac),
			    Integer.parseInt(moy_lic),
			    Integer.parseInt(n_s1),
			    Integer.parseInt(n_s2),
			    Integer.parseInt(n_s3),
			    Integer.parseInt(n_s4),
			    Integer.parseInt(n_s5),
			    Integer.parseInt(n_s6)
			);
		*/
		Etudiant e = new Etudiant();
		e.setId(0); // Assuming id is auto-generated or set later
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setDateNaissance(date_n);
		e.setSexe(sexe);
		e.setTel(telephone);
		e.setEmail(email);
		e.setPassword(password);
		e.setNationalite(nationalite);
		e.setCin(cin);
		e.setMassar(massar);
		e.setDateBac(date_bac); // Assuming this should be date of birth
		e.setDateGraduation(date_graduation);
		e.setDatePremiereInscription(date_premiere_inscription);
		e.setDocs(docs);
		e.setPhoto(photo);
		// Assuming photo and docs are set separately, not during object creation
		e.setFilBac(fil_bac);
		e.setIdFaculte(0);
		e.setIdFilLicense(0);
		e.setMoyBac(Integer.parseInt(moy_bac));
		e.setMoyLicense(Integer.parseInt(moy_lic));
		e.setNoteS1(Integer.parseInt(n_s1));
		e.setNoteS2(Integer.parseInt(n_s2));
		e.setNoteS3(Integer.parseInt(n_s3));
		e.setNoteS4(Integer.parseInt(n_s4));
		e.setNoteS5(Integer.parseInt(n_s5));
		e.setNoteS6(Integer.parseInt(n_s6));
		//donnant des valeurs temporaires à l'id de faculté et l'id filLisence et l'id de filBac(cette phase est temporaire)
		e.setIdFilLicense(1); e.setIdFaculte(1);
		
		EtudiantDao etd = OraFactory.getUserDao();
		if(!etd.checkEtudiant(e)) {
			etd.addEtudiant(e);
		}
		else {
			request.setAttribute("errorMsg", "Ce compte existe déja, veuillez verifier votre Cin, Massar et Email");
		}
		//pour tester si l'etudiant s'est ajouté avec succes vous pevez supprimez les commentaire au dessous
		//boolean isAdded = etd.addEtudiant(e);
		//System.out.println("isAdded: " + isAdded);

	}

}
