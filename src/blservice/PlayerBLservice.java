package blservice;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.TeamVO;

public interface PlayerBLservice {
	public PlayerVO Show(PlayerVO vo);
	/*��Ҫ�鿴����Ա��ĳһ��Ϣ����PlayerVO�У�
	 * ���룬�Դ������ҷ�����������Ա
	*/
	
	public ArrayList<PlayerVO> findByTeam(TeamVO tvo);
	/*��Ҫ�鿴����ӵ����ַ���tvo�������д���
	 * �Դ˲��ҷ�����������Ա�б�*/
}
