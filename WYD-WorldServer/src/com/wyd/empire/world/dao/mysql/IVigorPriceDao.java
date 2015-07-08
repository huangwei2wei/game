package com.wyd.empire.world.dao.mysql;

import com.wyd.db.mysql.dao.UniversalDao;
import com.wyd.empire.world.entity.mysql.VigorPrice;

/**
 * The DAO interface for the TabPlayeritemsfromshop entity.
 */
public interface IVigorPriceDao extends UniversalDao {
	public VigorPrice getByCount(int count);

	/**
	 * 获取最大购买次数
	 * 
	 * @param count
	 * @return
	 */
	public int getMaxCount(int vipLevel);

}