package ch.kerbtier.achaia.schema;

import java.util.Set;

public interface MapEntity extends Entity, Iterable<String> {
  Entity get(String name);
  Set<String> getProperties();
  MapEntity getObject(String name);
  ListEntity getList(String peek);
}
