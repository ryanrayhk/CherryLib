package com.cherrypicks.lib.model;

import java.util.Date;

/**
 * SenryoQueue model, including Brance, GetTicket, RetrieveTicket
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class SenryoQueue {

	public static class Branch {

		private String branch;
		private String branchstatus;
		private int curno;
		private int nextno;

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getBranchstatus() {
			return branchstatus;
		}

		public void setBranchstatus(String branchstatus) {
			this.branchstatus = branchstatus;
		}

		public int getCurno() {
			return curno;
		}

		public void setCurno(int curno) {
			this.curno = curno;
		}

		public int getNextno() {
			return nextno;
		}

		public void setNextno(int nextno) {
			this.nextno = nextno;
		}

	}

	public static class GetTicket {
		private String status;
		private String branch;
		private String ticketid;
		private String ticketno;
		private Date ticketcreatetime;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getTicketid() {
			return ticketid;
		}

		public void setTicketid(String ticketid) {
			this.ticketid = ticketid;
		}

		public String getTicketno() {
			return ticketno;
		}

		public void setTicketno(String ticketno) {
			this.ticketno = ticketno;
		}

		public Date getTicketcreatetime() {
			return ticketcreatetime;
		}

		public void setTicketcreatetime(Date ticketcreatetime) {
			this.ticketcreatetime = ticketcreatetime;
		}

	}

	public static class RetrieveTicket {
		private String status;
		private String branch;
		private String ticketid;
		private String ticketno;
		private String noofperson;
		private String mobileno;
		private String ticketstatus;
		private Date ticketcreatetime;
		private String seatintime;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getTicketid() {
			return ticketid;
		}

		public void setTicketid(String ticketid) {
			this.ticketid = ticketid;
		}

		public String getTicketno() {
			return ticketno;
		}

		public void setTicketno(String ticketno) {
			this.ticketno = ticketno;
		}

		public String getNoofperson() {
			return noofperson;
		}

		public void setNoofperson(String noofperson) {
			this.noofperson = noofperson;
		}

		public String getMobileno() {
			return mobileno;
		}

		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}

		public String getTicketstatus() {
			return ticketstatus;
		}

		public void setTicketstatus(String ticketstatus) {
			this.ticketstatus = ticketstatus;
		}

		public Date getTicketcreatetime() {
			return ticketcreatetime;
		}

		public void setTicketcreatetime(Date ticketcreatetime) {
			this.ticketcreatetime = ticketcreatetime;
		}

		public String getSeatintime() {
			return seatintime;
		}

		public void setSeatintime(String seatintime) {
			this.seatintime = seatintime;
		}

	}

}
