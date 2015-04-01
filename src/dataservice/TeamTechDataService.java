package dataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TeamTechPO;
import TypeEnum.TeamTechEnum;

public interface TeamTechDataService extends Remote{
	public ArrayList<TeamTechPO> ascend(String type)throws RemoteException, ClassNotFoundException, IOException;
	// ����type ��ʾ������������
	
	public ArrayList<TeamTechPO> descend(String type)throws RemoteException, ClassNotFoundException, IOException;
	//����type��ʾ������������
}
