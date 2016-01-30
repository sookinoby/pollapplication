package com.sooki.repository;

import org.springframework.data.repository.CrudRepository;

import com.sooki.domain.Poll;

public interface PollRepository extends CrudRepository<Poll, Long> {
	
}
