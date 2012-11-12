class MyJsonRepresentation {

  public MyJsonRepresentation() {
  }

  private int id;
  private String sportart;
  private double latitude;
  private double longitude;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setSportart(String sportart) {
    this.sportart = sportart;
  }

  public String getSportart() {
    return sportart;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

}