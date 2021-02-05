package model;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel{
  private final List<IUser> usernames;
  //This is wrong! There is a bug in this code! Can you think of what the bug is?
  //Hint: it has to do with pointers/refereneces? Why is this dangerous.
  //Parameterized constructor.
              //             0x100
  public Model(List<IUser> usernames) { //not a raw type? It better not be null.
    if ( usernames == null )
      throw new IllegalArgumentException("Usernames cannot be null.");

    this.usernames = new ArrayList<IUser>(usernames); //[0x400, 0x500]
    for ( IUser user : usernames ){
      //this.usernames.add( new User(user.getName()));

      //TODO: Another possible bug.
      this.addUsername( user.clone() ) ;
    }
    //this.usernames =  new ArrayList<>(0x100); [
    //this.usernames = 0x200; [0x400, 0x500]

  }
  //Default constructor
  public Model(){
    this.usernames = new ArrayList<>();
  }

  //TODO: When will this fail?
  //if index is out of bounds.
  //What kind of an exception should I throw here?
  //Illigal argument, index out of bounds.

  /**
   *
   * @param index
   * @return
   * @throws IndexOutOfBoundsException
   */
  @Override
  public String getUsername(int index) {
    if ( index < 0 || index > this.usernames.size() - 1 ){
      throw new IllegalArgumentException("Index is not valid.");
    }
    return this.usernames.get(index).getName();
  }

  //The model should never contain usernames shorter than 3 letters.
  @Override
  public void addUsername(IUser username) {
    if ( username == null ) throw  new IllegalArgumentException("username cannot be null");

    if ( username.getName().length() < 4 )
      throw new IllegalArgumentException("Username is too short.");

    //How does this work? usernames is final and non mutable?
    //Ans: the reference stored in usernames is non mutable.
    this.usernames.add(username);
    //[0x100, 0x200]
  }

  //TODO: Figure out, major bug!. Solved.
  @Override
  public List<IUser> getUsernames() {
    //return new ArrayList<>(this.usernames);
    List<IUser> copy = new ArrayList<>( );

    for (IUser username : this.usernames ){
      copy.add( ( new User( username.getName() ) ) );
    }

    return copy; //[0x300, 0x400]
  }
}
