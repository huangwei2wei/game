package com.wyd.empire.world.dao.mysql;

import java.util.List;

import com.wyd.db.mysql.dao.UniversalDao;
import com.wyd.empire.world.entity.mysql.WishItem;

public interface ILotteryDao extends UniversalDao {

	/**
	 * 获取许愿物品列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<WishItem> getWishItemList();

	/**
	 * 根据id查询许愿
	 * 
	 * @param id
	 * @return
	 */
	public WishItem getById(int id);

	/**
	 * 获取祝福礼盒
	 * 
	 * @return
	 */
	public List<WishItem> getZflhList();

}