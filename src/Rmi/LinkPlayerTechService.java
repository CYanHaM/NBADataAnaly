package Rmi;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PlayerTechPO;
import TypeEnum.PlayerTechEnum;
import dataservice.PlayerTechDataService;

public class LinkPlayerTechService {
	/**
	 * 开启客户端与服务端登录和账户管理接口的rmi类
	 * @author weiao
	 * @date 2014年12月21日20:13:45
	 * @version 5
	 */
	
	//定义远程访问IP与端口，并有set与get方法
	String host;
	String port;
	PlayerTechDataService playertechdata;
	
	public LinkPlayerTechService() throws MalformedURLException, RemoteException, NotBoundException{
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getPlayerTechPort();
		Remote remote=Naming.lookup("//"+host+":"+port+"/PlayerTechData");
		if (remote instanceof PlayerTechDataService) {
			playertechdata = (PlayerTechDataService) remote;
		}
	}
	
	public ArrayList<PlayerTechPO> ascend(PlayerTechEnum type){
		ArrayList<PlayerTechPO> result = new ArrayList<PlayerTechPO>();
		try {
			result = playertechdata.ascend(type);
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
	
	public ArrayList<PlayerTechPO> descend(PlayerTechEnum type){
		ArrayList<PlayerTechPO> result = new ArrayList<PlayerTechPO>();
		try {
			result = playertechdata.descend(type);
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
	
	public ArrayList<PlayerTechPO> sift(String position, String division, PlayerTechPO ptpo){
		ArrayList<PlayerTechPO> result = new ArrayList<PlayerTechPO>();
		try {
			result = playertechdata.sift(position, division, ptpo);
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
