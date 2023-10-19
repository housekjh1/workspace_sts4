package edu.pnu.dao;

public interface LogInterface {
	public void addLog(String method, String sqlstring, boolean success);
}
