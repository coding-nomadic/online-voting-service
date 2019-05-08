package org.votings.university.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.votings.university.model.AdminUser;
import org.votings.university.model.OTPDetails;
import org.votings.university.model.TempVoterCard;
import org.votings.university.model.Vote;
import org.votings.university.model.VotingRegistration;

@Repository
public class VotingRepository {

	@Autowired
	JdbcTemplate template;
	/* Getting all votes from vote table */
	public List<Vote> getAllVotesForAdmin() {
		List<Vote> items = template.query("SELECT COUNT(VOTERCARDNUMBER), CANDIDATEGROUP FROM VOTE GROUP BY CANDIDATEGROUP",(result, rowNum) -> new Vote(result.getString("count(voterCardNumber)"),result.getString("candidateGroup")));
		return items;
	}

	public List<Vote> getAllVotes() {
		List<Vote> items = template.query("select voterCardNumber,candidateGroup from vote",(result, rowNum) -> new Vote(result.getString("voterCardNumber"),result.getString("candidateGroup")));
		return items;
	}
	/* Getting a specific item by item id from table */
	public Vote getItem(int itemId) {
		String query = "SELECT * FROM VOTE WHERE ID=?";
		Vote item = template.queryForObject(query, new Object[] { itemId }, new BeanPropertyRowMapper<>(Vote.class));

		return item;
	}
	
	/* Adding an item into database temp_voter_card table */
	public int addTempVoterCard(String voterCardNumber) {
		String query = "INSERT INTO TEMP_VOTER_CARD VALUES(?)";
		return template.update(query,voterCardNumber);
	}
	/* Adding an item into database table */
	public int addVote(String voterCardNumber, String candidateGroup) {
		String query = "INSERT INTO VOTE VALUES(?,?)";
		return template.update(query,voterCardNumber, candidateGroup);
	}

	/* Adding an item into database table */
	public int saveOTP(String voterCardNumber, String otp) {
		String query = "INSERT INTO OTP VALUES(?,?)";
		return template.update(query,voterCardNumber, otp);
	}
	/* Adding an item into database table */
	public int addVotingRegistration(String firstName, String lastName, String voterCardNumber, String DateOfBirth,
			String contact, String email) {
		String query = "INSERT INTO VOTER_REGISTER VALUES(?,?,?,?,?,?)";
		return template.update(query, firstName, lastName, voterCardNumber, DateOfBirth, contact, email);
	}

	/* delete an item from database */
	public int deleteItem(int id) {
		String query = "DELETE FROM VOTE WHERE ID =?";
		return template.update(query, id);
	}

	/* Getting all votes from vote table */
	public List<VotingRegistration> getAllRegisteredVoters() {
		List<VotingRegistration> items = template.query(
				"select firstName, lastName,voterCardNumber,DateOfBirth,contact,email from voter_register",
				(result, rowNum) -> new VotingRegistration(result.getString("firstName"), result.getString("lastName"),
						result.getString("voterCardNumber"), result.getString("DateOfBirth"),
						result.getString("contact"), result.getString("email")));
		return items;
	}
	
	
	/* Getting all admin users from admin table */
	public List<AdminUser> getAllAdminUsers() {
		List<AdminUser> items = template.query("select userName, password from admin_login",
				(result, rowNum) -> new AdminUser(result.getString("userName"), result.getString("password")));
		return items;
	}
	
	/* Getting all admin users from admin table */
	public List<OTPDetails> getAllOTPs() {
		List<OTPDetails> items = template.query("select voterCardNumber, otp from otp",
				(result, rowNum) -> new OTPDetails(result.getString("voterCardNumber"), result.getString("otp")));
		return items;
	}
	
	/* Getting all admin users from admin table */
	public List<TempVoterCard> getAllVoterCards() {
		List<TempVoterCard> items = template.query("select voterCardNumber from temp_voter_card",
				(result, rowNum) -> new TempVoterCard(result.getString("voterCardNumber")));
		return items;
	}
	
	
}
