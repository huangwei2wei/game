package com.app.empire.protocol.data.account;
import com.app.empire.protocol.Protocol;
import com.app.protocol.data.AbstractData;
public class RoleLoginOk extends AbstractData {
	private int id;// 角色id
	private int heroId;// 英雄id
	private String nickname; // 玩家角色名称
	private int lv; // 玩家等级
	private int vipLv; // 玩家vip等级
	private String property;// 属性
	private int fight; // 玩家当前战斗力
	

	private int lvExp; // 玩家等级
	private int vipExp; // 玩家vip经验
	private int money; // 玩家金币数量

	public RoleLoginOk(int sessionId, int serial) {
		super(Protocol.MAIN_ACCOUNT, Protocol.ACCOUNT_RoleLoginOk, sessionId, serial);
	}

	public RoleLoginOk() {
		super(Protocol.MAIN_ACCOUNT, Protocol.ACCOUNT_RoleLoginOk);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getVipLv() {
		return vipLv;
	}

	public void setVipLv(int vipLv) {
		this.vipLv = vipLv;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int getFight() {
		return fight;
	}

	public void setFight(int fight) {
		this.fight = fight;
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public int getLvExp() {
		return lvExp;
	}

	public void setLvExp(int lvExp) {
		this.lvExp = lvExp;
	}

	public int getVipExp() {
		return vipExp;
	}

	public void setVipExp(int vipExp) {
		this.vipExp = vipExp;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
