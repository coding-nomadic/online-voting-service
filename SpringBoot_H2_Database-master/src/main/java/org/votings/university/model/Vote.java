package org.votings.university.model;

public class Vote {
	private String voterCardNumber;
	private String candidateGroup;

	public Vote() {
	}

	public Vote(String voterCardNumber, String candidateGroup) {
		super();
		this.voterCardNumber = voterCardNumber;
		this.candidateGroup = candidateGroup;
	}

	public String getVoterCardNumber() {
		return voterCardNumber;
	}

	public void setVoterCardNumber(String voterCardNumber) {
		this.voterCardNumber = voterCardNumber;
	}

	public String getCandidateGroup() {
		return candidateGroup;
	}

	public void setCandidateGroup(String candidateGroup) {
		this.candidateGroup = candidateGroup;
	}

}
