package blservice;

import java.util.ArrayList;

import VO.PlayerVO;
import VO.TeamVO;

public interface PlayerBLservice {
	public PlayerVO Show(PlayerVO vo);
	/*将要查看的球员的某一信息存入PlayerVO中，
	 * 传入，以此来查找符合条件的球员
	*/
	
	public ArrayList<PlayerVO> findByTeam(TeamVO tvo);
	/*将要查看的球队的名字放入tvo的属性中传入
	 * 以此查找符合条件的球员列表*/
}
