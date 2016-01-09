package ch.kerbtier.achaia.schema;

public class InvalidFieldException extends RuntimeException {

  public InvalidFieldException(String desc) {
    super(desc);
  }
  
}
