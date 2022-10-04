package edu.wctc.racecar;

import javafx.application.Platform;

public class AnimateCarTask implements Runnable {

    public AnimateCarTask(Car car) {
        this.car = car;
    }

    public void run() {

        private Car car;

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Platform.runLater(() -> car.move());
        }
        try {
            Thread.sleep(25 - car.getSpeed());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
}
