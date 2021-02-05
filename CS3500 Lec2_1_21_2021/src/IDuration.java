public interface IDuration extends Comparable<IDuration>, Cloneable{
  long inSeconds();
  String asHms();
  IDuration plus(IDuration other);
}
