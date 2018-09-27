package lt.bt.messager.messanger.TestServices;

import lt.bt.messager.messanger.entity.ChannelEntity;
import lt.bt.messager.messanger.repository.ChannelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestChannelService {


    ChannelRepository channelRepository;

    @Test
    public void TestshouldReturnList() {
        List<ChannelEntity> channels = new ArrayList<>();




    }




}
