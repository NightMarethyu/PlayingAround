public class Person {
  private int age;
  private String name;
  private Gender gender;

  enum Gender {
    MALE,
    FEMALE
  }

  public Person() {
    name = "Random Name";
    age = (int)(Math.random()*75);
    if (Math.random() > .5) {
      gender = Gender.MALE;
    } else {
      gender = Gender.FEMALE;
    }
  }

  public void setAge(int a) {
    age = a;
  }

  public void setName(String n) {
    name = n;
  }

  public void setGender(Gender g) {
    gender = g;
  }

  @Override
  public String toString() {
    return "Aloha! My name is " + name + "and I am " + age + "years old.";
  }
}
