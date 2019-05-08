package org.votings.university.model;

public class VotingRegistration {
	
	private String firstName;
	private String lastName;
	private String voterCardNumber;
	private String DateOfBirth;
	private String contact;
	private String email;
	
	public VotingRegistration(String firstName, String lastName, String voterCardNumber, String dateOfBirth,
			String contact, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.voterCardNumber = voterCardNumber;
		this.DateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getVoterCardNumber() {
		return voterCardNumber;
	}

	public void setVoterCardNumber(String voterCardNumber) {
		this.voterCardNumber = voterCardNumber;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
