package com.Myles.votingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String doLogin(@RequestParam String name) {
		
		Citizen citizen = citizenRepo.findByName(name);
		
		if(!citizen.getHasVoted()) {
		 return"/performVote.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
}
