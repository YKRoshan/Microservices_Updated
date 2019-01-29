package com.stackroute.repository;

import com.stackroute.domain.Music;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MusicRepositoryTestIT {

    @Autowired
    private MusicRepository musicRepository;
    private Music music;

    @Before
    public void setUp() throws Exception {
        music = new Music();
        music.setTrackId(1);
        music.setTrackComment("Awesome");
        music.setTrackName("awww");
    }

    @After
    public void tearDown() throws Exception {
        music=null;
    }

    @Test
    public void testSaveMusic() {
        musicRepository.save(music);
        Music fetchMusic = musicRepository.findById(music.getTrackId()).get();
        Assert.assertEquals(1, fetchMusic.getTrackId());
    }
    @Test
    public void testGetAllUser(){

        Music m1=new Music(2,"sumsumne","uppi");
        Music m2=new Music(3,"maarikannu","uppi2");

        musicRepository.save(m1);
        musicRepository.save(m2);
        List<Music> list = musicRepository.findAll();
        Assert.assertEquals("sumsumne",list.get(0).getTrackName());
    }

    @Test
    public void testFindById()
    {
        Music m5=new Music(5,"yaroyaro","kichasudeep");
        musicRepository.save(m5);
        Music fetchMusic = musicRepository.findById(5).get();
        Assert.assertEquals(m5,fetchMusic);
    }

    @Test
    public void testUpdate()
    {
        music.setTrackComment("skfsakbf");
        musicRepository.save(music);
        Assert.assertEquals("skfsakbf",musicRepository.findById(music.getTrackId()).get().getTrackComment());

    }

    @Test
    public void testDelete()
    {
        Music testMusic = new Music(10,"Let Her Go!","Awesome");
        musicRepository.save(testMusic);
        musicRepository.delete(testMusic);
        Assert.assertEquals(Optional.empty() ,musicRepository.findById(10));
    }





}