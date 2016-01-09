package ch.kerbtier.achaia.schema;

public class UndefinedFieldException extends RuntimeException {

  public UndefinedFieldException(String desc) {
    super(desc);
  }
}
