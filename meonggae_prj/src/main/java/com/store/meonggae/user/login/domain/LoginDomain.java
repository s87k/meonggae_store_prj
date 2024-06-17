package com.store.meonggae.user.login.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



public class LoginDomain {
	private int memNum;
	private String nick, profile, loginFlag, withdrawFlag;
	private Date suspendDate, unsuspendDate, withdrawDate;
	
	public LoginDomain() {
		
	}
	
	public LoginDomain(int memNum, String nick, String profile, String loginFlag, String withdrawFlag, Date suspendDate,
			Date unsuspendDate, Date withdrawDate) {
		this.memNum = memNum;
		this.nick = nick;
		this.profile = profile;
		this.loginFlag = loginFlag;
		this.withdrawFlag = withdrawFlag;
		this.suspendDate = suspendDate;
		this.unsuspendDate = unsuspendDate;
		this.withdrawDate = withdrawDate;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getWithdrawFlag() {
		return withdrawFlag;
	}

	public void setWithdrawFlag(String withdrawFlag) {
		this.withdrawFlag = withdrawFlag;
	}

	public Date getSuspendDate() {
		return suspendDate;
	}

	public void setSuspendDate(Date suspendDate) {
		this.suspendDate = suspendDate;
	}

	public Date getUnsuspendDate() {
		return unsuspendDate;
	}

	public void setUnsuspendDate(Date unsuspendDate) {
		this.unsuspendDate = unsuspendDate;
	}

	public Date getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	@Override
	public String toString() {
		return "LoginDomain [memNum=" + memNum + ", nick=" + nick + ", profile=" + profile + ", loginFlag=" + loginFlag
				+ ", withdrawFlag=" + withdrawFlag + ", suspendDate=" + suspendDate + ", unsuspendDate=" + unsuspendDate
				+ ", withdrawDate=" + withdrawDate + "]";
	}
	
}
