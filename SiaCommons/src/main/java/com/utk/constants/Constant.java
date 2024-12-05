package com.utk.constants;

public class Constant {

	public static final String GETACCOUNTBYID = "select * from account where id = ?";

	public static final String GETALLACCOUNTS = "select * from account";

	public static final String UPDATEWALLETAMOUNT = "update account set amount=? where id=?";

}
