package com.junbetterway.springmongo.event.listener;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.junbetterway.springmongo.entity.BaseEntity;
import com.junbetterway.springmongo.service.SequenceGeneratorService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BaseEntityMongoEventListener extends AbstractMongoEventListener<BaseEntity> {

	private final SequenceGeneratorService sequenceGenerator;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event) {
        if (Objects.isNull(event.getSource().getId()) || event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.createSequence(event.getSource().getSequenceName()));
        }
    }
    
}
