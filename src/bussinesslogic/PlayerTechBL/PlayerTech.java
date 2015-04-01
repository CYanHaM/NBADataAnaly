package bussinesslogic.PlayerTechBL;

import java.util.ArrayList;

import PO.PlayerTechPO;
import Rmi.LinkPlayerTechService;
import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import blservice.PlayerTechBLservice;
import bussinesslogic.Transfer.L2P.PlayerTechL2P;
import bussinesslogic.Transfer.L2V.PlayerTechL2V;
import bussinesslogic.Transfer.P2L.PlayerTechP2L;
import bussinesslogic.Transfer.V2L.PlayerTechV2L;

public class PlayerTech implements PlayerTechBLservice{
    LinkPlayerTechService ptdataservice;
 	public PlayerTech(){
			ptdataservice=new LinkPlayerTechService();
	}
	
	@Override
	public ArrayList<PlayerTechVO> Ascend(PlayerTechEnum DataType) {
		// TODO Auto-generated method stub
		PlayerTechP2L P2L = new PlayerTechP2L();
		PlayerTechL2V L2V = new PlayerTechL2V();
		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		resultpo = ptdataservice.ascend(DataType);
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			result.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechVO> Descend(PlayerTechEnum DataType) {
		// TODO Auto-generated method stub
		PlayerTechP2L P2L = new PlayerTechP2L();
		PlayerTechL2V L2V = new PlayerTechL2V();
		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		resultpo = ptdataservice.descend(DataType);
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			result.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechVO> sift(String position, String division,
			String sift) {
		// TODO Auto-generated method stub
		PlayerTechP2L P2L = new PlayerTechP2L();
		PlayerTechL2V L2V = new PlayerTechL2V();
		PlayerTechV2L V2L = new PlayerTechV2L();
		PlayerTechL2P L2P = new PlayerTechL2P();
		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		resultpo = ptdataservice.sift(position, division, sift);
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<50; i++){
			result.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		return result;
	}


}
