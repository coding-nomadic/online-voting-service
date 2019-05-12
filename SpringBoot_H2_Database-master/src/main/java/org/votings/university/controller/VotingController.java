package org.votings.university.controller;

import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.votings.university.model.AdminUser;
import org.votings.university.model.OTPDetails;
import org.votings.university.model.TempVoterCard;
import org.votings.university.model.Vote;
import org.votings.university.model.VotingRegistration;
import org.votings.university.otpservice.OTPService;
import org.votings.university.repository.VotingRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VotingController {

	private final OTPService otpservice = OTPService.INSTANCE;
	@Autowired
	VotingRepository itemRepo;

	@Autowired
	private JavaMailSender sender;

	@RequestMapping("/sendMail")
	public String sendMail(@RequestParam("email") String email,
			@RequestParam("voterCardNumber") String voterCardNumber) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			String newOtp = otpservice.otpGenerator();
			System.out.println("new otp---"+newOtp);
			System.out.println("voter card ----"+voterCardNumber);
			if (itemRepo.saveOTP(voterCardNumber, newOtp)>= 1) {
				System.out.println("--matched-----");
				helper.setText("Greetings!! Your one time password to vote is : " + newOtp);
				helper.setSubject("Mail From Online Voting System");
			} else {
				return "votercard and otp couldnt saved in database....";
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail ..";
		}
		sender.send(message);
		return "Mail Sent Success!";
	}
	
	@RequestMapping("/api")
	public String getStatusFromServer() {
		return "hello from the server!!";
	}

	// APIs related to vote table.
	@RequestMapping("/getAllVotes")
	public List<Vote> getAllVotes() {
		return itemRepo.getAllVotes();
	}

	// APIs related to vote table.
	@RequestMapping("/getAllVotesForAdmin")
	public List<Vote> getAllVotesForAdmin() {
		return itemRepo.getAllVotesForAdmin();
	}

	@RequestMapping("/getVote")
	public Vote getVote(@RequestParam("itemId") int itemId) {
		return itemRepo.getItem(itemId);
	}

	@RequestMapping("/addVote")
	public String addVote(@RequestParam("voterCardNumber") String voterCardNumber,
			@RequestParam("candidateGroup") String candidateGroup) {
		if (itemRepo.addVote(voterCardNumber, candidateGroup) >= 1) {
			return "Item Added Successfully";
		} else {
			return "Something went wrong !";
		}
	}

	@RequestMapping("/saveotp")
	public String saveOTP(@RequestParam("voterCardNumber") String voterCardNumber, @RequestParam("otp") String otp) {
		if (itemRepo.saveOTP(voterCardNumber, otp) >= 1) {
			return "otp Added Successfully";
		} else {
			return "Something went wrong !";
		}
	}
	
	@RequestMapping("/addTempVoterCard")
	public String addTempVoterCard(@RequestParam("voterCardNumber") String voterCardNumber) {
		if (itemRepo.addTempVoterCard(voterCardNumber) >= 1) {
			return "Item added Successfully";
		} else {
			return "Something went wrong !";
		}
	}
	
	// APIs related to vote table.
		@RequestMapping("/getAllTempVoterCards")
		
		public List<TempVoterCard> getAllTempVoterCards() {
			return itemRepo.getAllVoterCards();
		}

	@RequestMapping("/deteteVote")
	public String deteteVote(@RequestParam("itemId") int itemId) {
		if (itemRepo.deleteItem(itemId) >= 1) {
			return "Item Deleted Successfully";
		} else {
			return "Something went wrong !";
		}
	}

	// APIs related to voter_register table
	@RequestMapping("/addVoteRegistration")
	public String addVoterRegistration(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("voterCardNumber") String voterCardNumber,
			@RequestParam("DateOfBirth") String DateOfBirth, @RequestParam("contact") String contact,
			@RequestParam("email") String email) {
		if (itemRepo.addVotingRegistration(firstName, lastName, voterCardNumber, DateOfBirth, contact, email) >= 1) {
			return "Registered Successfully";
		} else {
			return "Something went wrong !";
		}
	}

	@RequestMapping("/getAllRegisteredVoters")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<VotingRegistration> getAllRegisteredVoters() {
		return itemRepo.getAllRegisteredVoters();
	}

	// APIs related to adminuser table.
	@RequestMapping("/getAllAdminUsers")
	public List<AdminUser> getAllAdminUsers() {
		return itemRepo.getAllAdminUsers();
	}

	// APIs related to adminuser table.
	@RequestMapping("/getAllOTPs")
	public List<OTPDetails> getAllOTPs() {
		return itemRepo.getAllOTPs();
	}

	@RequestMapping("/getAllVoterCards")
	public List<TempVoterCard> getAllVoterCards() {
		return itemRepo.getAllVoterCards();
	}

	

}