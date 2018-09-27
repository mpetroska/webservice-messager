package lt.bt.messager.messanger.service;

import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;


    public List<ChannelEntity> fetchChanels() {

        return (List<ChannelEntity>) channelRepository.findAll();

        }
    }
