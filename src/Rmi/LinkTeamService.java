package Rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.TeamPO;
import dataservice.TeamDataService;

public class LinkTeamService {
	/**
	 * �����ͻ��������˵�¼���˻�����ӿڵ�rmi��
	 * @author weiao
	 * @date 2014��12��21��20:13:45
	 * @version 5
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
	String host;
	String port;
	TeamDataService teamdata;
	
	public LinkTeamService() throws MalformedURLException, RemoteException, NotBoundException{
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getTeamPort();
		Remote remote=Naming.lookup("//"+host+":"+port+"/TeamData");
		if (remote instanceof TeamDataService) {
			teamdata = (TeamDataService) remote;
		}
	}
	
	public TeamPO find(TeamPO tpo){
		TeamPO result = new TeamPO();
		try {
			result = teamdata.find(tpo);
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
