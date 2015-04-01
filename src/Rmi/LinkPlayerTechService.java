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
	 * �����ͻ��������˵�¼���˻�����ӿڵ�rmi��
	 * ����������Ҫ�׳�����ĵط�����RMI����ʹ��try-catch���
	 * @author С�ڹ�
	 * @mender blisscry
	 * @date 2015��3��26��17:45:28
	 * @version 1.2
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
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
