package com.wyd.empire.world.dao.mysql;

import java.util.Collection;

import com.wyd.db.mysql.dao.UniversalDao;
import com.wyd.empire.world.entity.mysql.StarsInfo;

/**
 * The DAO interface for the TabTool entity.
 */
public interface IStarsInfoDao extends UniversalDao {
	/**
	 * 初始化数据
	 */
	public void initData();

	/**
	 * 根据星级获取升星信息
	 * 
	 * @param level
	 * @return
	 */
	public StarsInfo getByLevel(int level);

	/**
	 * 获取所有的升星信息
	 * 
	 * @return
	 */
	public Collection<StarsInfo> getAllStarsInfo();

	public StarsInfo getStarConfig(int level);
}