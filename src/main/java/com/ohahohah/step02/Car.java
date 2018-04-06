package com.ohahohah.step02;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 자동차 경주게임을 위한 자동차 class
 */
public class Car {

  private String playerName;
  private int coords;
  private List<Integer> coordsLog;

  public Car() {
  }

  public Car(String playerName, int coords) {
    this.playerName = playerName;
    this.coords = coords;
  }

  public String getPlayerName() {
    return playerName;
  }

  public int getCoords() {
    return coords;
  }

  public int stopOrGo(int randomValue) {
    if (randomValue >= 4) {
      return 1;
    }
    return 0;
  }

  public void move(int i) {
    coords += i;
  }

  public void saveCoordiate(int coordinate) {
    coordsLog.add(coords + coordinate);
  }

  public static Comparator<Car> carCoordsComparator = new Comparator<Car>() {
    public int compare(Car c1, Car c2) {
      return c2.getCoords() - c1.getCoords();
    }
  };


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return coords == car.coords &&
        Objects.equals(playerName, car.playerName) &&
        Objects.equals(coordsLog, car.coordsLog);
  }

  @Override
  public int hashCode() {

    return Objects.hash(playerName, coords, coordsLog);
  }

  @Override
  public String toString() {
    return "Car{" +
        "playerName='" + playerName + '\'' +
        ", coords=" + coords +
        ", coordsLog=" + coordsLog +
        '}';
  }
}
