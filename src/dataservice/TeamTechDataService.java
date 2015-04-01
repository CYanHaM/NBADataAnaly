package dataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.TeamTechPO;
import TypeEnum.TeamTechEnum;

public interface TeamTechDataService extends Remote{
	public ArrayList<TeamTechPO> ascend(String type)throws RemoteException, ClassNotFoundException, IOException;
	// 按照type 所示条件升序排序
	
	public ArrayList<TeamTechPO> descend(String type)throws RemoteException, ClassNotFoundException, IOException;
	//按照type所示条件降序排序
}
