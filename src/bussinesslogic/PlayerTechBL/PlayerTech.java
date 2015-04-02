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

		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		String send = DataType.toString();
		resultpo = ptdataservice.ascend(send);
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			PlayerTechP2L P2L = new PlayerTechP2L();
			PlayerTechL2V L2V = new PlayerTechL2V();
			PlayerTechLineItem ptli = new PlayerTechLineItem();
			PlayerTechVO ptvo = new PlayerTechVO();
			ptli = P2L.p2l(resultpo.get(i));
			ptvo = L2V.l2v(ptli);
			result.add(ptvo);
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechVO> Descend(PlayerTechEnum DataType) {
		// TODO Auto-generated method stub

		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		String send = DataType.toString();
		resultpo = ptdataservice.descend(send);
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<resultpo.size(); i++){
			PlayerTechP2L P2L = new PlayerTechP2L();
			PlayerTechL2V L2V = new PlayerTechL2V();
			PlayerTechLineItem ptli = new PlayerTechLineItem();
			PlayerTechVO ptvo = new PlayerTechVO();
			ptli = P2L.p2l(resultpo.get(i));
			ptvo = L2V.l2v(ptli);
			result.add(ptvo);
		}
		return result;
	}

	@Override
	public ArrayList<PlayerTechVO> sift(String position, String division,
			String sift) {
		// TODO Auto-generated method stub

		PlayerTechV2L V2L = new PlayerTechV2L();
		PlayerTechL2P L2P = new PlayerTechL2P();
		ArrayList<PlayerTechPO> resultpo = new ArrayList<PlayerTechPO>();
		String doubledouble = "doubledouble";
		if(sift.equals(doubledouble)){
			resultpo = ptdataservice.doubledouble(position,division,sift);
		}
		else{
			resultpo = ptdataservice.sift(position, division, sift);
		}
		ArrayList<PlayerTechVO> result = new ArrayList<PlayerTechVO>();
		for(int i = 0; i<50; i++){
			PlayerTechP2L P2L = new PlayerTechP2L();
			PlayerTechL2V L2V = new PlayerTechL2V();
			PlayerTechLineItem tmp = new PlayerTechLineItem();
			PlayerTechVO temp = new PlayerTechVO();
			tmp = P2L.p2l(resultpo.get(i));
			temp = L2V.l2v(tmp);
			result.add(temp);
		}
		return result;
	}


}
