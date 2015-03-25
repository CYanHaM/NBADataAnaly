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
 * 界面层通过BL层的接口导入数据
 * @author blisscry
 * @date 2015年3月20日20:59:42
 * @version 1.0
 */
	//定义层间传输接口
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
