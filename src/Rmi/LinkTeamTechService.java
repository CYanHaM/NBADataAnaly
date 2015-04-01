package Rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TeamTechPO;
import TypeEnum.TeamTechEnum;
import dataservice.TeamTechDataService;

public class LinkTeamTechService {
	/**
	 * �����ͻ��������˵�¼���˻�����ӿڵ�rmi��
	 * ����������Ҫ�׳�����ĵط�����RMI����ʹ��try-catch���
	 * @author С�ڹ�
	 * @mender blisscry
	 * @date 2015��3��26��17:43:06
	 * @version 1.2
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
	String host;
	String port;
	TeamTechDataService teamtechdata;
	Remote remote;
	
	public LinkTeamTechService(){
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getTeamTechPort();
		try {
			remote = Naming.lookup("//"+host+":"+port+"/TeamTechData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (remote instanceof TeamTechDataService) {
			teamtechdata = (TeamTechDataService) remote;
		}
	}
	
	public ArrayList<TeamTechPO> ascend(String type){
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		try {
			result = teamtechdata.ascend(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<TeamTechPO> descend(String type){
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		try {
			result = teamtechdata.descend(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
