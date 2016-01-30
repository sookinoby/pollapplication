package com.sooki.repository;

import org.springframework.data.repository.CrudRepository;

import com.sooki.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Long> {
	

}
