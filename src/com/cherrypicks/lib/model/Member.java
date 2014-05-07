package com.cherrypicks.lib.model;

import java.io.Serializable;

/**
 * Member model
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */	
public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 774315697986007747L;
	
	private String constituency_name;
	private String member_name;
	private String member_party;
	private String member_biography_url;
	private String member_website;
	private String uri;

	public String getConstituency_name() {
		return constituency_name;
	}

	public void setConstituency_name(String constituency_name) {
		this.constituency_name = constituency_name;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_party() {
		return member_party;
	}

	public void setMember_party(String member_party) {
		this.member_party = member_party;
	}

	public String getMember_biography_url() {
		return member_biography_url;
	}

	public void setMember_biography_url(String member_biography_url) {
		this.member_biography_url = member_biography_url;
	}

	public String getMember_website() {
		return member_website;
	}

	public void setMember_website(String member_website) {
		this.member_website = member_website;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Member [constituency_name=" + constituency_name
				+ ", member_name=" + member_name + ", member_party="
				+ member_party + ", member_biography_url="
				+ member_biography_url + ", member_website=" + member_website
				+ ", uri=" + uri + "]";
	}

}
