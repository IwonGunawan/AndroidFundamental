package com.fundamental.unittesting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private CuboidModel cuboidModel;

    private final double dummyLength = 12.0;
    private final double dummyWidth = 7.0;
    private final double dummmyHeight = 8.0;

    private final double dummyVolume = 672.0;
    private final double dummyCircumference = 108.0;
    private final double dummySurfaceare = 472.0;

    @Before
    public void before() {
        cuboidModel = mock(CuboidModel.class);
        mainViewModel = new MainViewModel(cuboidModel);
    }

    @Test
    public void testVolume() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummmyHeight);
        double volume = mainViewModel.getVolume();

        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testCircumference() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummmyHeight);
        double circumference = mainViewModel.getCircumference();

        assertEquals(dummyCircumference, circumference, 0.0001);
    }

    @Test
    public void testSurfacerea() {
        cuboidModel = new CuboidModel();
        mainViewModel = new MainViewModel(cuboidModel);
        mainViewModel.save(dummyLength, dummyWidth, dummmyHeight);
        double surfacearea = mainViewModel.getSurfaceArea();

        assertEquals(dummySurfaceare, surfacearea, 0.0001);
    }

    @Test
    public void testMockVolume() {
        when(mainViewModel.getVolume()).thenReturn(dummyVolume);
        double volume = mainViewModel.getVolume();
        verify(cuboidModel).getVolume();

        assertEquals(dummyVolume, volume, 0.0001);
    }

    @Test
    public void testMockCircumference() {
        when(mainViewModel.getCircumference()).thenReturn(dummyCircumference);
        double circumference = mainViewModel.getCircumference();
        verify(cuboidModel).getCircumference();

        assertEquals(dummyCircumference, circumference, 0.0001);
    }

    @Test
    public void testMockSurfacearea() {
        when(mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceare);
        double surfacearea = mainViewModel.getSurfaceArea();
        verify(cuboidModel).getSurfaceArea();

        assertEquals(dummySurfaceare, surfacearea, 0.0001);
    }

}