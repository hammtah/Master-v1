package master.dao.interfaces;
import master.beans.Etudiant;

public interface EtudiantDao {
	public boolean addEtudiant(Etudiant e);
	public boolean checkEtudiant(Etudiant e);//true if it's exist (if is there)
}
