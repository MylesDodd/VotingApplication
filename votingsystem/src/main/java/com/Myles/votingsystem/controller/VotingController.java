package com.Myles.votingsystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Myles.votingsystem.entity.Candidate;
import com.Myles.votingsystem.entity.User;
import com.Myles.votingsystem.repositories.CadidateRepo;
import com.Myles.votingsystem.repositories.UserRepo;


@Controller
public class VotingController {
	
	public final Logger logger = Logger.getLogger(VotingController.class);

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CadidateRepo candidateRepo;
	

	
	@RequestMapping("/")
	public String goToVote( ) {
		logger.info("Returning index.html file");
		return "index.html";
	}
	
	@RequestMapping("/signUp")
	public String signUp() {
		logger.info("Returning signUp.html file");
		return "signUp.html";		
	}
	
	@RequestMapping("/createAuditor")
	public String createAuditor()
	{
		logger.info("Returning create auditor view");
		return "createAuditor.html";
	}
	
	@RequestMapping("/createCandidate")
	public String createCandidate()
	{
		logger.info("Returning create candidate view");
		return "createCandidate.html";
	}
	
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		
		
		logger.info("Getting user from database");
		User User = userRepo.findByName(name);
		
		logger.info("Putting user into session");
		session.setAttribute("User", User);
		
		if(User.getUserType() == 1) 
		{
			if(!User.getHasVoted()) {
			
			logger.info("Putting candidates into model");
			List<Candidate> candidates = candidateRepo.findAll();
			for(Candidate c : candidates) {
				model.addAttribute("candidates",candidates);
			}
			
			return "/performVote.html";
			
			}
			
			else return "/alreadyVoted.html";
		}
		
		else if (User.getUserType() == 2) 
		{
			logger.info("returning adminIndex view for admin user");
			
			return "adminIndex.html";
			
		}
		
		else if (User.getUserType() == 3) 
		{
			logger.info("returning auditorIndex view for auditor user");
			
			return "auditorIndex.html";
			
		}
		
		else return "/index.html";
							
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id, HttpSession session) {
		User User = (User)session.getAttribute("User");
		
		if(!User.getHasVoted()) {
			


		User.setHasVoted(true);
		
		Candidate c = candidateRepo.findById((long)id);
		logger.info("voting for candidate" + c.getName());
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		
		candidateRepo.save(c);
		userRepo.save(User);
		
		return "voted.html";
		}
		
		return "alreadyVoted.html";
		
	}
	
	@PostMapping("/signUpComplete")
	public String createNewUser(@RequestParam String username, String password) {
		
		
		int count = 0; 
		List<User> Users = userRepo.findAll();
		for (User c : Users) 
		{
					count ++ ;	
			
		}
		
		User User = new User();
		User.setId((long)count+1);
		User.setName(username);
		User.setPassword(password);
		User.setUserType((long)1);
		User.setHasVoted(false);
		
		userRepo.save(User);
		
		return "index.html";
		
	}
	
	
	
	@PostMapping("/createCandidateComplete")
	public String createNewCandidate(@RequestParam String name) {
		
		
		int count = 0; 
		List<Candidate> Candidates = candidateRepo.findAll();
		for (Candidate c : Candidates) 
		{
					count ++ ;	
			
		}
		
		Candidate Candidate = new Candidate();
		Candidate.setId((long)count+1);
		Candidate.setName(name);
		Candidate.setNumberOfVotes(0);
		
		candidateRepo.save(Candidate);
		
		return "adminIndex.html";
		
	}
	
	
	@PostMapping("/createAuditorComplete")
	public String createNewAuditor(@RequestParam String username, String password) {
		
		
		int count = 0; 
		List<User> Users = userRepo.findAll();
		for (User c : Users) 
		{
					count ++ ;	
			
		}
		
		
		User User = new User();
		User.setId((long)count+1);
		User.setName(username);
		User.setPassword(password);
		User.setUserType((long)3);
		
		userRepo.save(User);
		
		return "adminIndex.html";
		
	}

	
}
