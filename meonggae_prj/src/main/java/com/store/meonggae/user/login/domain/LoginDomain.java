package com.store.meonggae.user.login.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDomain {
	private int memNum;
	private String nick, profile, loginFlag, withdrawFlag;
	private Date suspendDate, unsuspendDate, withdrawDate;
}
