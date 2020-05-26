package xupt.se.ttms.idao;
import xupt.se.ttms.dao.*;

public class DAOFactory {
	private static StudioDAO stuDao;
	public static synchronized iStudioDAO creatStudioDAO(){
		if(null==stuDao)
			stuDao = new StudioDAO();
		return stuDao;
	}
	
}
