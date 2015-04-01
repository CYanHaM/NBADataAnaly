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
	 * 并且所有需要抛出错误的地方均在RMI包中使用try-catch完成
	 * @author 小乌龟
	 * @mender blisscry
	 * @date 2015年3月26日17:45:28
	 * @version 1.2
	 */
	
	//定义远程访问IP与端口，并有set与get方法
	String host;
	String port;
	PlayerTechDataService playertechdata;
	Remote remote;
	
	public LinkPlayerTechService(){
		ServerURL server=new ServerURL();
		host=server.getHost();
		port=server.getPlayerTechPort();
		try {
			remote = Naming.lookup("//"+host+":"+port+"/PlayerTechData");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (remote instanceof PlayerTechDataService) {
			playertechdata = (PlayerTechDataService) remote;
		}
	}
	
	public ArrayList<PlayerTechPO> ascend(String type){
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
	
	public ArrayList<PlayerTechPO> descend(String type){
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
	
	public ArrayList<PlayerTechPO> sift(String position, String division, String sift){
		ArrayList<PlayerTechPO> result = new ArrayList<PlayerTechPO>();
		try {
			result = playertechdata.sift(position, division, sift);
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
	
	public ArrayList<PlayerTechPO> doubledouble(String position, String division, String doubledouble){
		ArrayList<PlayerTechPO> result = new ArrayList<PlayerTechPO>();
		try {
			result = playertechdata.doubledouble(position, division, doubledouble);
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
