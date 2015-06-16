package com.wyd.empire.gameaccount.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.mongo.dao.impl.BaseDao;
import com.wyd.empire.gameaccount.bean.Account;

/**
 * 执行与Account表相关数据库操作
 * 
 * @author doter
 */

@Repository
public class AccountDao extends BaseDao<Account, Integer> {

	@Autowired
	public AccountDao(MongoRepositoryFactory factory, MongoTemplate mongoOperations) {
		super(factory, mongoOperations, Account.class);
	}
	/**
	 * 根据用户名取得相关账号信息
	 * 
	 * @param name
	 *            用户名
	 * @return <tt>账号信息</tt> 如果存在此用户名相关记录； <tt>null</tt> 如果不存在此用户相关记录。
	 */
	public Account getAccountByName(String username) {
		Query query = new Query();
		query.addCriteria(new Criteria("username").is(username));
		return this.mongoTemplate.findOne(query, Account.class);
	}

	/**
	 * 保存账号信息
	 * 
	 * @param account
	 *            账号信息对象
	 */
	public Account saveAccount(Account account) {
		return this.save(account);
	}
	/**
	 * 创建账号信息
	 * 
	 * @param account
	 *            账号信息对象
	 */
	public Account createAccount(Account account) {
		return this.insert(account);
	}
	
	
	public Account login(String username, String worldServerId) {
		Query query = new Query();
		query.addCriteria(new Criteria("username").is(username));
		query.addCriteria(new Criteria("serverid").is(worldServerId));
		return this.mongoTemplate.findOne(query, Account.class);
	}
 
	
	
}
