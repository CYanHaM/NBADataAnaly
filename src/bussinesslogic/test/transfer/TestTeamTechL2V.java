package bussinesslogic.test.transfer;

import junit.framework.TestCase;
import VO.TeamTechVO;
import bussinesslogic.TeamTech.TeamTechLineItem;
import bussinesslogic.Transfer.L2V.TeamTechL2V;

public class TestTeamTechL2V extends TestCase{
	public void testL2V(){
		TeamTechL2V l2v = new TeamTechL2V();
		TeamTechLineItem ttli = new TeamTechLineItem();
		ttli.name = "Haha";
		ttli.season = "13-14";
		ttli.gameNum = 82;
		ttli.shotInRate = 1;
		ttli.threeShotInRate = 2;
		ttli.penaltyShotInRate = 3;
		ttli.winningRate = 4;
		ttli.offensiveEfficiency = 5;
		ttli.defensiveEfficiency = 6;
		ttli.reboundEfficiency = 7;
		ttli.stealEfficiency = 8;
		ttli.secondaryAttackEfficiency = 9;
		ttli.winningNum = 10;
		ttli.shotInNum = 82*11;
		ttli.shotNum = 82*12;
		ttli.threeShotInNum = 82*13;
		ttli.threeShotNum = 82*14;
		ttli.penaltyShotInNum = 82*15;
		ttli.penaltyShotNum = 82*16;
		ttli.offensiveRebound = 82*17;
		ttli.defensiveRebound = 82*18;
		ttli.rebound = 82*19;
		ttli.secondaryAttack = 82*20;
		ttli.steal = 82*21;
		ttli.blockShot = 82*22;
		ttli.fault = 82*23;
		ttli.foul = 82*24;
		ttli.score = 82*25;
		ttli.offensiveRound = 82*26;
		ttli.shotInNumave = 11;
		ttli.shotNumave = 12;
		ttli.threeShotInNumave = 13;
		ttli.threeShotNumave = 14;
		ttli.penaltyShotInNumave = 15;
		ttli.penaltyShotNumave = 16;
		ttli.offensiveReboundave = 17;
		ttli.defensiveReboundave = 18;
		ttli.reboundave = 19;
		ttli.secondaryAttackave = 20;
		ttli.stealave = 21;
		ttli.blockShotave = 22;
		ttli.faultave = 23;
		ttli.foulave = 24;
		ttli.scoreave = 25;
		ttli.offensiveRoundave = 26;
		TeamTechVO result = l2v.l2v(ttli);
		TeamTechVO expected = new TeamTechVO();
		expected.name = "Haha";
		expected.season = "13-14";
		expected.gameNum = 82;
		expected.shotInRate = 1;
		expected.threeShotInRate = 2;
		expected.penaltyShotInRate = 3;
		expected.winningRate = 4;
		expected.offensiveEfficiency = 5;
		expected.defensiveEfficiency = 6;
		expected.reboundEfficiency = 7;
		expected.stealEfficiency = 8;
		expected.secondaryAttackEfficiency = 9;
		expected.winningNum = 10;
		expected.shotInNum = 82*11;
		expected.shotNum = 82*12;
		expected.threeShotInNum = 82*13;
		expected.threeShotNum = 82*14;
		expected.penaltyShotInNum = 82*15;
		expected.penaltyShotNum = 82*16;
		expected.offensiveRebound = 82*17;
		expected.defensiveRebound = 82*18;
		expected.rebound = 82*19;
		expected.secondaryAttack = 82*20;
		expected.steal = 82*21;
		expected.blockShot = 82*22;
		expected.fault = 82*23;
		expected.foul = 82*24;
		expected.score = 82*25;
		expected.offensiveRound = 82*26;
		expected.shotInNumave = 11;
		expected.shotNumave = 12;
		expected.threeShotInNumave = 13;
		expected.threeShotNumave = 14;
		expected.penaltyShotInNumave = 15;
		expected.penaltyShotNumave = 16;
		expected.offensiveReboundave = 17;
		expected.defensiveReboundave = 18;
		expected.reboundave = 19;
		expected.secondaryAttackave = 20;
		expected.stealave = 21;
		expected.blockShotave = 22;
		expected.faultave = 23;
		expected.foulave = 24;
		expected.scoreave = 25;
		expected.offensiveRoundave = 26;
		boolean test = expected.equals(result);
		assertTrue("tell me WHY!",test);
	}
}
