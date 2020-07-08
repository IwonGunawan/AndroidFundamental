package com.fundamental.unittesting;

public class MainViewModel {

    private final CuboidModel cuboidModel;

    MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double length, double width, double height){
        cuboidModel.save(length, width, height);
    }

    double getVolume(){
        return cuboidModel.getVolume();
    }

    double getCircumference() {
        return cuboidModel.getCircumference();
    }

    double getSurfaceArea() {
        return cuboidModel.getSurfaceArea();
    }

}
