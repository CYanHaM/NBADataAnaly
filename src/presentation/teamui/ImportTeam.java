package presentation.teamui;

import java.util.ArrayList;

import blservice.TeamBLservice;
import blservice.TeamTechBLservice;
import bussinesslogic.TeamBL.Team;
import bussinesslogic.TeamTech.TeamTech;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import VO.TeamVO;

public class ImportTeam {
/**
 * �����ͨ��BL��Ľӿڵ��벢��������
 * @author blisscry
 * @date 2015��3��20��20:59:42
 * @version 1.0
 */
	//�����䴫��ӿ�
	TeamTechBLservice TTbs;
	TeamBLservice Tbs;

	public ImportTeam(){
		TTbs = new TeamTech();
		Tbs = new Team();
	}

	public ArrayList<TeamTechVO> getTeamTechAscend(TeamTechEnum DataType){
		return TTbs.Ascend(DataType);
	}

	public ArrayList<TeamTechVO> getTeamTechDescend(TeamTechEnum DataType){
		return TTbs.Descend(DataType);
	}
	
	public TeamVO getTeamVO(TeamVO tvo){
		return Tbs.Show(tvo);
	}
	
}
