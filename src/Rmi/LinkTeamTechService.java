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
	 * 开启客户端与服务端登录和账户管理接口的rmi类
	 * 并且所有需要抛出错误的地方均在RMI包中使用try-catch完成
	 * @author 小乌龟
	 * @mender blisscry
	 * @date 2015年3月26日17:43:06
	 * @version 1.2
	 */
	
	//定义远程访问IP与端口，并有set与get方法
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
