package com.wyd.empire.gameaccount.handler.server;
import org.hibernate.SessionFactory;

import com.wyd.empire.gameaccount.bean.Account;
import com.wyd.empire.gameaccount.service.factory.ServiceFactory;
import com.wyd.empire.gameaccount.service.impl.AccountService;
import com.wyd.empire.protocol.data.server.PlayerLogout;
import com.wyd.protocol.data.AbstractData;
import com.wyd.protocol.handler.IDataHandler;
public class PlayerLogoutHandler implements IDataHandler {
	protected SessionFactory sf;

	public PlayerLogoutHandler() {
	}

	public AbstractData handle(AbstractData message) throws Exception {
		PlayerLogout playerLogout = (PlayerLogout) message;
		Account account;
		try {
			AccountService accountService = ServiceFactory.getServiceFactory().getAccountService();
			account = accountService.getAccountDao().findOne(playerLogout.getAccountId());
			if (account == null) {
				return null;
			}
			int lastLoginTime = account.getLastLoginTime();
			int between = (int) System.currentTimeMillis() / 1000 - lastLoginTime;// 除以1000是为了转换成秒
			int onLineTime = account.getOnLineTime();
			account.setOnLineTime(onLineTime + between);
			accountService.saveAccount(account);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
