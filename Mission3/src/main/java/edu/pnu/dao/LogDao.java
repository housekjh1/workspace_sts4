package edu.pnu.dao;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogDao {
	private int id;
	private String method;
	private String sqlstring;
	private Date regidate;
	private boolean success;
}
