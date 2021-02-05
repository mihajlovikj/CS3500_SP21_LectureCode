public interface IDuration extends Comparable<IDuration> {
  long inSeconds();
  String asHms();
  IDuration plus(IDuration other);
}
