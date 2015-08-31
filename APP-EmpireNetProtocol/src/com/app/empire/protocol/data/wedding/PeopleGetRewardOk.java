package com.app.empire.protocol.data.wedding;
import com.app.empire.protocol.Protocol;
import com.app.protocol.data.AbstractData;
/**
 * 
 * @see AbstractData
 * @author zhaopeilong
 */
public class PeopleGetRewardOk extends AbstractData {

	private int goldNum;	//领到的金币数
	private int rewardNum;	//剩余红包数
	
    public PeopleGetRewardOk(int sessionId, int serial) {
        super(Protocol.MAIN_WEDDING, Protocol.WEDDING_PeopleGetRewardOk, sessionId, serial);
    }

    public PeopleGetRewardOk() {
        super(Protocol.MAIN_WEDDING, Protocol.WEDDING_PeopleGetRewardOk);
    }

	public int getGoldNum() {
		return goldNum;
	}

	public void setGoldNum(int goldNum) {
		this.goldNum = goldNum;
	}

	public int getRewardNum() {
		return rewardNum;
	}

	public void setRewardNum(int rewardNum) {
		this.rewardNum = rewardNum;
	}

}