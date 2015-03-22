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
	 * @author weiao
	 * @date 2014年12月21日20:13:45
	 * @version 5
	 */
	
	//定义远程访问IP与端口，并有set与get方法
	String host;
	String port;
	TeamTechDataService teamtechdata;
	
	public LinkTeamTechService() throws MalformedURLException, RemoteException, NotBoundException{
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getTeamTechPort();
		Remote remote=Naming.lookup("//"+host+":"+port+"/TeamTechData");
		if (remote instanceof TeamTechDataService) {
			teamtechdata = (TeamTechDataService) remote;
		}
	}
	
	public ArrayList<TeamTechPO> ascend(TeamTechEnum type){
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		try {
			result = teamtechdata.ascend(type);
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
	
	public ArrayList<TeamTechPO> descend(TeamTechEnum type){
		ArrayList<TeamTechPO> result = new ArrayList<TeamTechPO>();
		try {
			result = teamtechdata.descend(type);
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
