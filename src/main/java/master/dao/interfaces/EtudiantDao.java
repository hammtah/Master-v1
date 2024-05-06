package master.dao.interfaces;
import master.beans.Etudiant;
import master.dao.exception.EtudiantDaoException;

public interface EtudiantDao {
	public void addEtudiant(Etudiant e) throws EtudiantDaoException;
	public boolean checkEtudiant(Etudiant e) throws EtudiantDaoException;//true if it's exist (if is there)
}
