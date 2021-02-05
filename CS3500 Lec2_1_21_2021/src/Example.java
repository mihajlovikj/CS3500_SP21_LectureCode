interface IPet {
  boolean hasName(String name);
}

//to represent no pet.
class NoPet implements IPet{
  NoPet(){}

  @Override
  public boolean hasName(String name) {
    return false;
  }
}

// to represent a pet cat
class Cat implements IPet {
  String name;
  String kind;
  boolean longhaired;

  Cat(String name, String kind, boolean longhaired) {
    this.name = name;
    this.kind = kind;
    this.longhaired = longhaired;
  }


  @Override
  public boolean hasName(String name) {
    return this.name.equalsIgnoreCase(name);
  }
}

// to represent a pet dog
class Dog implements IPet {
  String name;
  String kind;
  boolean male;

  Dog(String name, String kind, boolean male) {
    this.name = name;
    this.kind = kind;
    this.male = male;
  }

  @Override
  public boolean hasName(String name) {
    return this.name.equalsIgnoreCase(name);
  }

  // to represent a pet owner
  class Person {
    String name;
    IPet pet;
    int age;

    Person(String name, IPet pet, int age) {
      this.name = name;
      this.pet = pet;
      this.age = age;
    }

    Person lostPet(String nameOfPerson){
      return new Person(nameOfPerson, new NoPet(), 0);
    }
  }

}