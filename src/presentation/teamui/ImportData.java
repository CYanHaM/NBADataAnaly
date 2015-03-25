package presentation.teamui;

import java.util.ArrayList;

import blservice.TeamBLservice;
import blservice.TeamTechBLservice;
import bussinesslogic.TeamBL.Team;
import bussinesslogic.TeamTech.TeamTech;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public class ImportData {
/**
 * �����ͨ��BL��Ľӿڵ�������
 * @author blisscry
 * @date 2015��3��20��20:59:42
 * @version 1.0
 */
	//�����䴫��ӿ�
	TeamTechBLservice TTbs;
	TeamBLservice Tbs;

	public ImportData(){
		TTbs = new TeamTech();
		Tbs = new Team();
	}

	public ArrayList<TeamTechVO> getTeamTechAscend(TeamTechEnum DataType){
		return TTbs.Ascend(DataType);
	}

	public ArrayList<TeamTechVO> getTeamTechDescend(TeamTechEnum DataType){
		return TTbs.Descend(DataType);
	}
	
}
