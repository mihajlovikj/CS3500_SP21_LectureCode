package view;

public interface ViewFeaturesListener {
  void handleAddShape(int x, int y);
  void handleRemoveShape();
  void handleSaveEvent();
  void handleLoadEvent();
  void handleSelectColorEvent();
  void handleClear();
}
