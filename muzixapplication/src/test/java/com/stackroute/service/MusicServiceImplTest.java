package com.stackroute.service;

import com.stackroute.Exceptions.TrackAlreadyFoundException;
import com.stackroute.Exceptions.TrackNotFoundException;
import com.stackroute.domain.Music;
import com.stackroute.repository.MusicRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class MusicServiceImplTest {

    private Music music;



    @Mock
    private MusicRepository musicRepository;

    @InjectMocks
    private MusicServiceImpl musicService;
    List<Music> list=null;


    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        music=new Music();
        music.setTrackId(101);
        music.setTrackName("yarallisoundmadodu");
        music.setTrackComment("ramachari");
        list=new ArrayList<>();
        list.add(music);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveMusicTestSuccess() throws TrackAlreadyFoundException {

        when(musicRepository.save((Music)any())).thenReturn(music);
        Music savedMusic=musicService.saveMusic(music);
        Assert.assertEquals(music,savedMusic);

        verify(musicRepository,times(1)).save(music);

    }

    @Test
    public void getAllMusicTestSuccess() {
        musicRepository.save(music);
        when(musicRepository.findAll()).thenReturn(list);
        List<Music> musicList=musicService.getAllMusic();
        Assert.assertEquals(list,musicList);

    }

    @Test
    public void updateMusicTestSuccess()throws TrackNotFoundException {

        when(musicRepository.existsById(anyInt())).thenReturn(true);
        when(musicRepository.findById(anyInt())).thenReturn(Optional.of(music));
        when(musicRepository.save((Music)any())).thenReturn(music);
        Music updatedMusic=musicService.updateMusic(anyString(),101);
        Assert.assertEquals(music,updatedMusic);



    }

    @Test
    public void deleteMusicTestSuccess() throws TrackNotFoundException{
        when(musicRepository.existsById(anyInt())).thenReturn(true);
        when(musicRepository.findAll()).thenReturn(list);
        
        List<Music> deleteMusic=musicService.deleteMusic(1);

        Assert.assertEquals(list,deleteMusic);
        verify(musicRepository, Mockito.times(1)).deleteById(1);

    }

    @Test
    public void findByIdTestSuccess()throws TrackNotFoundException {
        when(musicRepository.existsById(anyInt())).thenReturn(true);
        when(musicRepository.findById(anyInt())).thenReturn(Optional.of(music));
        Optional<Music> music1=musicService.findById(101);
        Assert.assertEquals(music1,Optional.of(music));
    }

    @Test
    public void findByNameTestSuccess()
    {
        when(musicRepository.findByTrackName(anyString())).thenReturn(list);
        List<Music> music1=musicService.findByTrackName(anyString());
        Assert.assertEquals(music1,list);
    }

}