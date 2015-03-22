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
	 * 开启客户端与服务端登录和账户管理接口的rmi类
	 * @author weiao
	 * @date 2014年12月21日20:13:45
	 * @version 5
	 */
	
	//定义远程访问IP与端口，并有set与get方法
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
