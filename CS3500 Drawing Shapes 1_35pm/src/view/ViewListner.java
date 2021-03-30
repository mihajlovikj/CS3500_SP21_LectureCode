package view;

public interface ViewListner {
  void shapeAddedEvent(int x, int y);
  void shapeRemovedEvent();
  void saveEvent();
  void loadEvent();
  void motionAddedEvent();
}
