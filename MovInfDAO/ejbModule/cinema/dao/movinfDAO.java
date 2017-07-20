package cinema.dao;

import java.util.List;

import cinema.datas.MovInfData;

public interface movinfDAO {
	
	void createMIMessage(MovInfData data) throws Exception;

	void deleteMIMessage(MovInfData data);
	
	MovInfData retrieveMIMessage(MovInfData data) throws Exception;
	
	void updateMIMessage(MovInfData data);

	List<MovInfData> getMIMessageList(MovInfData data) throws Exception;

}
