package blservice;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import VO.PlayerVO;

public interface PlayerTechBLservice {
    public ArrayList<PlayerTechVO> Ascend(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 升序
     * */
    
    public ArrayList<PlayerTechVO> Descend(PlayerTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 降序
     * */
    
    public ArrayList<PlayerTechVO> sift(String position, String division, String sift);
	/* 根据条件筛选并排序
	 * 可用作筛选条件的有：球员位置，球员联盟
	 * 可用作排序条件的有：球员名称，所属球队，参赛场数，先发场数，篮板数，助攻数，在场时间，投篮命中率，三分命中率，罚球命中率，进攻数，防守数，抢断数，盖帽数，失误数，犯规数，得分，效率，GmSc效率值，真实命中率，投篮效率，篮板率，进攻篮板率，防守篮板率，助攻率，抢断率，盖帽率，失误率，使用率
	 * 筛选条件作为特定属性存入ptpo
	 * 排序条件则为该项属性非0
	 * */
}
