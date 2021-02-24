package com.junbetterway.springmongo.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.junbetterway.springmongo.entity.DatabaseSequence;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SequenceGeneratorService {

	private final MongoOperations mongoOperations;
	
	public long createSequence(final String seqName) {
	
	    final DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
	            new Update().inc("seq",1), options().returnNew(true).upsert(true),
	            DatabaseSequence.class);
	    
	    return Objects.isNull(counter) ? 1 : counter.getSeq();
	
	}
	
}
