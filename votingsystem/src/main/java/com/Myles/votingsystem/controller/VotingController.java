package com.Myles.votingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Myles.votingsystem.entity.Candidate;
import com.Myles.votingsystem.entity.Citizen;
import com.Myles.votingsystem.repositories.CadidateRepo;
import com.Myles.votingsystem.repositories.CitizenRepo;

@Controller
public class VotingController {

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CadidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote( ) {
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model) {
		
		Citizen citizen = citizenRepo.findByName(name);
		
		if(!citizen.getHasVoted()) {
			List<Candidate> candidates = candidateRepo.findAll();
			for(Candidate c : candidates) {
				model.addAttribute("candidates",candidates);
			}
			
		 return"/performVote.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String voteFor(@RequestParam Long id) {
		Candidate c = candidateRepo.findById((long)id);
		c.setNumberOfVotes(c.getNumberOfVotes()+1);
		candidateRepo.save(c);
		
		return "voted.html";
	}
	
}
