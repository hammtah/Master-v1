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
import master.beans.exception.EtudiantBeansException;
import master.dao.exception.EtudiantDaoException;
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
		try {
			request.setAttribute("facultes", fad.getAllFacultes());
			request.setAttribute("filieres", fld.getFilieresLicense());			
		}catch(EtudiantDaoException ede) {
			request.setAttribute("errorMsg", ede.getMessage());
		}
		
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
		String date_bac = request.getParameter("date_bac");
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
		Part docs = request.getPart("docs");
		Part photo = request.getPart("photo");
		
		Etudiant e = new Etudiant();
		//To add: pour le moment les exceptions sont juste pour la photo et le docs
		//donc penser à les ajouter pour tout ses setters
		try {
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
		e.setIdFilLicense(Integer.parseInt(fil_license)); 
		e.setIdFaculte(Integer.parseInt(fac));

		}catch(EtudiantBeansException ede) {
			request.setAttribute("errorMsg", ede.getMessage());
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}
		
		EtudiantDao etd = OraFactory.getUserDao();
		//l'ajout de l'étudiant
		try {
			if(!etd.checkEtudiant(e)) {
				etd.addEtudiant(e);
				//go to home page
			}
			else {
				request.setAttribute("errorMsg", "Ce compte existe déja, veuillez verifier votre Cin, Massar et Email");
				this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
			}
		}catch(EtudiantDaoException ede) {
			request.setAttribute("errorMsg", ede.getMessage());
			this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
		}

	}

}
