package dataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.PlayerPO;
import PO.TeamPO;

public interface PlayerDataService extends Remote{
	public PlayerPO find(PlayerPO ppo)throws RemoteException, ClassNotFoundException, IOException;
	/* �������Բ�����Ա�����������洢��ppo��
	 * �ɲ��ҵ�����������
	 * */
	
	public ArrayList<PlayerPO> findByTeam(TeamPO tpo)throws RemoteException, ClassNotFoundException, IOException;
	
	/* ������Ӳ�����Ա�����������洢��tpo��
	 * �ɲ��ҵ������ж���
	 * */
}
