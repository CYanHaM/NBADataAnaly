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
	 * ����������Ҫ�׳�����ĵط�����RMI����ʹ��try-catch���
	 * @author С�ڹ�
	 * @mender blisscry
	 * @date 2015��3��26��17:44:42
	 * @version 1.2
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
	String host;
	String port;
	TeamDataService teamdata;
	Remote remote;
	
	public LinkTeamService(){
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getTeamPort();
		try {
			remote = Naming.lookup("//"+host+":"+port+"/TeamData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
