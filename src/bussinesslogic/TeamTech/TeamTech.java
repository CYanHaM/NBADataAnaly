package bussinesslogic.TeamTech;

import java.util.ArrayList;

import PO.TeamTechPO;
import Rmi.LinkTeamTechService;
import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import blservice.TeamTechBLservice;
import bussinesslogic.Transfer.L2V.TeamTechL2V;
import bussinesslogic.Transfer.P2L.TeamTechP2L;

public class TeamTech implements TeamTechBLservice{

	LinkTeamTechService ttdataservice;
 	public TeamTech(){
			ttdataservice=new LinkTeamTechService();
	}
	@Override
	public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType) {
		TeamTechP2L P2L = new TeamTechP2L();
		TeamTechL2V L2V = new TeamTechL2V();
		ArrayList<TeamTechPO> resultpo = new ArrayList<TeamTechPO>();
		resultpo = ttdataservice.ascend(DataType);
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			result.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		return result;
	}

	@Override
	public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType) {
		TeamTechP2L P2L = new TeamTechP2L();
		TeamTechL2V L2V = new TeamTechL2V();
		ArrayList<TeamTechPO> resultpo = new ArrayList<TeamTechPO>();
		resultpo = ttdataservice.descend(DataType);
		ArrayList<TeamTechVO> result = new ArrayList<TeamTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			result.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		return result;
	}
	
}
