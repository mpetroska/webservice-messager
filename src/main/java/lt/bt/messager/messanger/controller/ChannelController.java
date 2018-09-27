package lt.bt.messager.messanger.controller;


import lt.bt.messager.messanger.dto.Message;
import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.service.ChannelService;
import lt.bt.messager.messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.channels.Channel;
import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private MessageService messageService;


    @GetMapping ()
    public List<ChannelEntity> getchannels() {

        return channelService.fetchChanels();
    }

    @GetMapping("/{id}")
    public List<Message> getChannelMessages(@PathVariable Long id) {

        return  messageService.getMessagesByChanelId(id);
    }



}
