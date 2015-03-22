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
	 * @author weiao
	 * @date 2014��12��21��20:13:45
	 * @version 5
	 */
	
	//����Զ�̷���IP��˿ڣ�����set��get����
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
