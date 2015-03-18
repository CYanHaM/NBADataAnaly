package blservice;

import VO.PlayerVO;

public interface PlayerBLservice {
	public PlayerVO Show(PlayerVO vo);
	/*将要查看的球员的某一信息存入PlayerVO中，
	 * 传入，以此来查找符合条件的球员
	*/
}
