package Rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PlayerPO;
import PO.TeamPO;
import dataservice.PlayerDataService;

public class LinkPlayerService {
	/**
	 * �����ͻ��������˵�¼���˻�����ӿڵ�rmi��
	 * ����������Ҫ�׳�����ĵط�����RMI����ʹ��try-catch���
	 * @author С�ڹ�
	 * @mender blisscry
	 * @date 2015��3��26��17:46:25
	 * @version 1.2
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
	String host;
	String port;
	PlayerDataService playerdata;
	Remote remote;
	
	public LinkPlayerService(){
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getPlayerPort();
		try {
			remote = Naming.lookup("//"+host+":"+port+"/PlayerData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (remote instanceof PlayerDataService) {
			playerdata = (PlayerDataService) remote;
		}
	}
	
	public PlayerPO find(PlayerPO ppo){
		PlayerPO result = new PlayerPO();
		try {
			result = playerdata.find(ppo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<PlayerPO> findByTeam(TeamPO tpo){
		ArrayList<PlayerPO> result = new ArrayList<PlayerPO>();
		try {
			result = playerdata.findByTeam(tpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
