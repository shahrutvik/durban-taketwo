package com.carpool.vo;





public class EventVO {
	private int idEvent;
	private String eventDate;
	private int idMember;
	private int idClub;
	private int idRole;
	
	public int getIdMember() {
		return idMember;
	}
	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}
	
	public int getIdClub(){
		return idClub;
	}
	
	public void setIdClub(int idClub){
		this.idClub=idClub;
	}
	
	public int getRoleId() {
		return idRole;
	}
	public void setRoleId(int roleId) {
		this.idRole = roleId;
	}
	
	public int getEventId() {
		return idEvent;
	}
	public void setEventid(int id) {
		this.idEvent = id;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String date) {
		this.eventDate = date;
	}
	
	

}
