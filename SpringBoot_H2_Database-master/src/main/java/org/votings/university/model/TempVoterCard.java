package org.votings.university.model;

public class TempVoterCard {

	private String voterCardNumber;

	public TempVoterCard() {

	}

	public TempVoterCard(String voterCardNumber) {
		super();
		this.voterCardNumber = voterCardNumber;
	}

	public String getVoterCardNumber() {
		return voterCardNumber;
	}

	public void setVoterCardNumber(String voterCardNumber) {
		this.voterCardNumber = voterCardNumber;
	}
}
