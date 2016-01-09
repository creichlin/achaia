package ch.kerbtier.archaia;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import ch.kerbtier.achaia.Parse;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;

public class EntityPathGetters {
  
  private MapEntity root
  
  @Before
  public void init() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get("src/test/resources", "post.model"))
  }
  
  @Test()
  public void checkPostName() {
    assertEquals(root.getObject("post"), root.get("post"))
  }
  
  @Test()
  public void checkRoot() {
    assertEquals(root, root.get(""))
  }
  
  @Test()
  public void checkCommentName() {
    assertEquals(root.getObject("post").getList("comments"), root.get("post.comments"))
  }
  
  @Test()
  public void checkCommentNameUsinggetObject() {
    assertEquals(root.getObject("post").getObject("meta"), root.getObject("post.meta"))
  }
  
  @Test()
  public void checkCommentItemName() {
    assertEquals(root.getObject("post").getList("comments").get(), root.get("post.comments._"))
  }
  
  @Test()
  public void checkCommentFieldName() {
    assertEquals(root.getObject("post").getList("comments").getObject().get("email"), root.get("post.comments._.email"))
  }
  
  @Test()
  public void checkHitsList() {
    assertEquals(root.getObject("post").getList("hits"), root.get("post.hits"))
  }

  @Test()
  public void checkHitsField() {
    assertEquals(root.getObject("post").getList("hits").get(), root.get("post.hits._"))
  }
}

