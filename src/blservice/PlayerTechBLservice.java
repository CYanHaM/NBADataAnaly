package blservice;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;

public interface PlayerTechBLservice {
    public ArrayList<PlayerTechVO> AscendAll(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 升序
     * */
    
    public ArrayList<PlayerTechVO> DescendAll(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 降序
     * */
    
    public ArrayList<PlayerTechVO> AscendAve(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按场均数据排序
	 * 升序
     * */
    
    public ArrayList<PlayerTechVO> DescendAve(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按场均数据排序
	 * 降序
     * */
}
