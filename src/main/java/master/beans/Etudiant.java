package master.beans;
import java.sql.Blob;

import jakarta.servlet.http.Part;

public class Etudiant {
		int id;
		String nom;
		String prenom;
		String dateNaissance;
		String sexe;
		String tel;
		String email;
		String password;
		String nationalite;
		String cin;
		String massar;
		String dateBac;
		String dateGraduation;
		String datePremiereInscription;

		Part photo;
		Part docs;
		String FilBac;
		int idFaculte;
		int idFilLicense;
		int moyBac;
		int moyLicense;
		int noteS1;
		int noteS2;
		int noteS3;
		int noteS4;
		int noteS5;
		int noteS6;
		
		//constructor 
	    public Etudiant() {
	        // Initialize any default values if needed
	    }
	    
	    public Etudiant(int id, String nom, String prenom, String dateNaissance, String sexe, String tel, String email, String password, String nationalite, String cin, String massar, String dateBac, String dateGraduation, String datePremiereInscription, Part photo, Part docs, String FilBac, int idFaculte, int idFilLicense, int moyBac, int moyLicense, int noteS1, int noteS2, int noteS3, int noteS4, int noteS5, int noteS6) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.dateNaissance = dateNaissance;
	        this.sexe = sexe;
	        this.tel = tel;
	        this.email = email;
	        this.password = password;
	        this.nationalite = nationalite;
	        this.cin = cin;
	        this.massar = massar;
	        this.dateBac = dateBac;
	        this.dateGraduation = dateGraduation;
	        this.datePremiereInscription = datePremiereInscription;
	        this.photo = photo;
	        this.docs = docs;
	        this.FilBac = FilBac;
	        this.idFaculte = idFaculte;
	        this.idFilLicense = idFilLicense;
	        this.moyBac = moyBac;
	        this.moyLicense = moyLicense;
	        this.noteS1 = noteS1;
	        this.noteS2 = noteS2;
	        this.noteS3 = noteS3;
	        this.noteS4 = noteS4;
	        this.noteS5 = noteS5;
	        this.noteS6 = noteS6;
	    }
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getDateNaissance() {
			return dateNaissance;
		}
		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getNationalite() {
			return nationalite;
		}
		public void setNationalite(String nationalite) {
			this.nationalite = nationalite;
		}
		public String getCin() {
			return cin;
		}
		public void setCin(String cin) {
			this.cin = cin;
		}
		public String getMassar() {
			return massar;
		}
		public void setMassar(String massar) {
			this.massar = massar;
		}
		public String getDateGraduation() {
			return dateGraduation;
		}
		public void setDateGraduation(String dateGraduation) {
			this.dateGraduation = dateGraduation;
		}
		public Part getPhoto() {
			return photo;
		}
		public void setPhoto(Part photo) {
			this.photo = photo;
		}
		public Part getDocs() {
			return docs;
		}
		public void setDocs(Part file) {
			this.docs = file;
		}
		public String getDateBac() {
			return dateBac;
		}
		public void setDateBac(String dateBac) {
			this.dateBac = dateBac;
		}
		
		public String getDatePremiereInscription() {
			return datePremiereInscription;
		}

		public void setDatePremiereInscription(String datePremiereInscription) {
			this.datePremiereInscription = datePremiereInscription;
		}
		public int getIdFaculte() {
			return idFaculte;
		}
		public void setIdFaculte(int idFaculte) {
			this.idFaculte = idFaculte;
		}
		public String getFilBac() {
			return FilBac;
		}
		public void setFilBac(String FilBac) {
			this.FilBac = FilBac;
		}
		public int getIdFilLicense() {
			return idFilLicense;
		}
		public void setIdFilLicense(int idFilLicense) {
			this.idFilLicense = idFilLicense;
		}
		public int getMoyBac() {
			return moyBac;
		}
		public void setMoyBac(int moyBac) {
			this.moyBac = moyBac;
		}
		public int getMoyLicense() {
			return moyLicense;
		}
		public void setMoyLicense(int moyLicense) {
			this.moyLicense = moyLicense;
		}
		public int getNoteS1() {
			return noteS1;
		}
		public void setNoteS1(int noteS1) {
			this.noteS1 = noteS1;
		}
		public int getNoteS2() {
			return noteS2;
		}
		public void setNoteS2(int noteS2) {
			this.noteS2 = noteS2;
		}
		public int getNoteS3() {
			return noteS3;
		}
		public void setNoteS3(int noteS3) {
			this.noteS3 = noteS3;
		}
		public int getNoteS4() {
			return noteS4;
		}
		public void setNoteS4(int noteS4) {
			this.noteS4 = noteS4;
		}
		public int getNoteS5() {
			return noteS5;
		}
		public void setNoteS5(int noteS5) {
			this.noteS5 = noteS5;
		}
		public int getNoteS6() {
			return noteS6;
		}
		public void setNoteS6(int noteS6) {
			this.noteS6 = noteS6;
		}

	}


