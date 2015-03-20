package bussinesslogic.PlayerBL;

import java.util.ArrayList;

import PO.PlayerPO;
import PO.TeamPO;
import VO.PlayerVO;
import VO.TeamVO;
import blservice.PlayerBLservice;
import bussinesslogic.TeamBL.TeamLineItem;
import bussinesslogic.Transfer.L2P.PlayerL2P;
import bussinesslogic.Transfer.L2P.TeamL2P;
import bussinesslogic.Transfer.L2V.PlayerL2V;
import bussinesslogic.Transfer.P2L.PlayerP2L;
import bussinesslogic.Transfer.V2L.PlayerV2L;
import bussinesslogic.Transfer.V2L.TeamV2L;
import dataservice.PlayerDataService;

public class Player implements PlayerBLservice{
	
	PlayerDataService pdservice;
	
	/*
	 * 	public Account(){
		try {
			las=new LinkAccountService();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Override
	public PlayerVO Show(PlayerVO vo) {
		// TODO Auto-generated method stub
		PlayerP2L P2L = new PlayerP2L();
		PlayerV2L V2L = new PlayerV2L();
		PlayerL2P L2P = new PlayerL2P();
		PlayerL2V L2V = new PlayerL2V();
		
		PlayerLineItem temppli = V2L.v2l(vo);
		PlayerPO ppo = L2P.l2p(temppli);
		PlayerPO resultpo = new PlayerPO();
		resultpo = pdservice.find(ppo);
		PlayerLineItem pli = P2L.p2l(ppo);
		PlayerVO result = L2V.l2v(pli);

		return result;
	}

	@Override
	public ArrayList<PlayerVO> findByTeam(TeamVO tvo) {
		// TODO Auto-generated method stub
		ArrayList<PlayerPO> resultpo = new ArrayList<PlayerPO>();
		ArrayList<PlayerVO> resultvo = new ArrayList<PlayerVO>();
		PlayerP2L P2L = new PlayerP2L();
		PlayerL2V L2V = new PlayerL2V();
		TeamV2L tV2L = new TeamV2L();
		TeamL2P tL2P = new TeamL2P();
		
		TeamLineItem tli = tV2L.v2l(tvo);
		TeamPO tpo = tL2P.l2p(tli);
		resultpo = pdservice.findByTeam(tpo);
		for(int i = 0; i<resultpo.size(); i++){
			resultvo.add(L2V.l2v(P2L.p2l(resultpo.get(i))));
		}
		
		return resultvo;
	}
	
}
