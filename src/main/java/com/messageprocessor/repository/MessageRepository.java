package com.messageprocessor.repository;

import com.messageprocessor.models.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * @implNote : Handles CRUD for message
 */
public interface MessageRepository extends CrudRepository<Message, Long> {

}
