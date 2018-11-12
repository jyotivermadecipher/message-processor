package com.messageprocessor.controller.rest;

import com.messageprocessor.Constants;
import com.messageprocessor.models.Message;
import com.messageprocessor.services.MessageConsumerService;
import com.messageprocessor.view.MessageView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @implNote : Rest Controller for Messages handling
 */
@Api("Messages - Processor")
@RestController
@RequestMapping(value = Constants.BASE_API_URL + "message", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageRestController {

    private static final Logger LOGGER = LogManager.getLogger(MessageRestController.class);
    private final MessageConsumerService messageConsumerService;

    @Autowired
    public MessageRestController(MessageConsumerService messageConsumerService) {
        this.messageConsumerService = messageConsumerService;
    }

    /**
     * @return List of All messages
     */
    @GetMapping(value = "/")
    @ApiOperation("List all messages in queue")
    public List<Message> getMessages() {
        return messageConsumerService.getAllMessages();
    }

    /**
     * @param message Message to be posted
     * @return Saved message
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Processes message")
    public Message consumeMessage(@RequestBody Message message) {
        return messageConsumerService.processMessage(message);
    }

    /**
     * @return { "date" : "2018-11-01", "value", 0.58}
     */
    @GetMapping(value = "/chart-data")
    @ApiOperation("List all messages in queue")
    public List<MessageView> getChartData() {
        return messageConsumerService.getChartData();
    }

}
