package com.messageprocessor.services.impl;

import com.google.common.collect.Lists;
import com.messageprocessor.models.Message;
import com.messageprocessor.repository.MessageRepository;
import com.messageprocessor.services.MessageConsumerService;
import com.messageprocessor.view.MessageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumerServiceImpl.class);

    private MessageRepository messageRepository;

    @Autowired
    public MessageConsumerServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message processMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return Lists.newArrayList(messageRepository.findAll());
    }

    @Override
    public List<MessageView> getChartData() {
        List<MessageView> viewList = new ArrayList<>();
        List<Message> messages = this.getAllMessages();
        messages.forEach(message -> viewList.add(new MessageView(message)));
        return viewList;
    }

}
