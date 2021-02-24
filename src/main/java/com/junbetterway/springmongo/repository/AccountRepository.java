package com.junbetterway.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.junbetterway.springmongo.entity.Account;

public interface AccountRepository extends MongoRepository<Account, Long> {

}
