
package com.sooki.controller;

import java.net.URI;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sooki.domain.Poll;
import com.sooki.repository.PollRepository;


@RestController
public class PollController  {

	@Inject
	PollRepository pollRepository;
	
	@RequestMapping(value="/polls",method=RequestMethod.GET)
	public ResponseEntity<Iterable<Poll>> getAllPolls() 
	{
		Iterable<Poll> allPolls = pollRepository.findAll();
		return new ResponseEntity<>(allPolls,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls", method=RequestMethod.POST )
	public ResponseEntity<?> createPoll(@RequestBody Poll poll)
	{
		poll = pollRepository.save(poll);
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(poll.getId())
				.toUri();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<>(null,responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
	public ResponseEntity<Poll> getPoll(@PathVariable Long pollId)
	{
		
		Poll p = pollRepository.findOne(pollId);
		return new ResponseEntity<Poll>(p,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
	        // Save the entity
	        Poll p = pollRepository.save(poll);
	        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
	        pollRepository.delete(pollId);
	        return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}