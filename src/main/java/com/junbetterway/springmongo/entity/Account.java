package com.junbetterway.springmongo.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Document(collection = "accounts")
public class Account extends BaseEntity {

	private String name;
	private BigDecimal balance;

	@Override
	public String getSequenceName() {
		return "accounts_sequence";
	}
    
}
