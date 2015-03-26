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
	 * 并且所有需要抛出错误的地方均在RMI包中使用try-catch完成
	 * @author 小乌龟
	 * @mender blisscry
	 * @date 2015年3月26日17:44:42
	 * @version 1.2
	 */
	
	//定义远程访问IP与端口，并有set与get方法
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
