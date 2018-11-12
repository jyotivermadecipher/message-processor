package com.messageprocessor.services;

import com.messageprocessor.models.Message;
import com.messageprocessor.view.MessageView;

import java.util.List;

/**
 * @implNote : Handles processing of message
 */
public interface MessageConsumerService {

    /**
     * Processes message passed
     * @param message Message object
     * @return Saved object
     */
    Message processMessage(Message message);

    /**
     * Getting all saved messages
     * @return Saved messages
     */
    List<Message> getAllMessages();

    /**
     * Prepares JSON data for requested country
     * @return { "date" : "2018-11-01", "value", 0.58}
     */
    List<MessageView> getChartData();
}
