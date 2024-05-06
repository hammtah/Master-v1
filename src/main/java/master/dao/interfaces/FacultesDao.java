package master.dao.interfaces;

import java.util.List;
import master.beans.Facultes;
import master.dao.exception.EtudiantDaoException;

public interface FacultesDao {
	public List<Facultes> getAllFacultes() throws EtudiantDaoException;
}
