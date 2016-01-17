package ch.kerbtier.archaia;

import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ch.kerbtier.achaia.Parse;
import ch.kerbtier.achaia.Type;
import ch.kerbtier.achaia.schema.Entity;
import ch.kerbtier.achaia.schema.IntegerEntity;
import ch.kerbtier.achaia.schema.MapEntity;
import ch.kerbtier.achaia.schema.SlugEntity;
import ch.kerbtier.achaia.schema.StringEntity;
import ch.kerbtier.achaia.schema.implementation.ImpMapEntity;

public class BasicEntity {
  
  private MapEntity root;
  
  @Before
  public void init() {
    root = new ImpMapEntity(null, "")
    Parse.extend(root, Paths.get("src/test/resources", "post.model"))
  }
  
  @Test()
  public void checkStringType() {
    assertTrue(root["post"]["title"] instanceof StringEntity)
  }
  
  @Test()
  public void checkSlugType() {
    assertTrue(root["post"]["slug"] instanceof SlugEntity)
  }
  
  @Test()
  public void checkIntegerType() {
    assertTrue(root["post"]["count"] instanceof IntegerEntity)
  }
  

  @Test()
  public void checkExistingMapType() {
    Entity entity = root["post"]
    assertTrue(entity instanceof MapEntity)
  }

  @Test()
  public void checkExistingMapTypeWithIsForJavaType() {
    Entity entity = root["post"]
    assertTrue(entity.is(Map.class))
  }
  
  @Test()
  public void checkExistingMapTypeWithIsForArchaiaType() {
    Entity entity = root["post"]
    assertTrue(entity.is(Type.MAP))
  }
  
  @Test()
  public void checkPostName() {
    assertEquals("post", root["post"].name)
  }
  
  @Test()
  public void checkCommentPath() {
    assert "post.comments" == root["post"]["comments"].path
  }
  
  @Test()
  public void checkCommentName() {
    assert "comments" == root["post"]["comments"].name
  }
  
  @Test()
  public void checkCommentItemPath() {
    assert "post.comments._" == root["post"]["comments"].get().path
  }
  
  @Test()
  public void checkCommentFieldPath() {
    assert "post.comments._.email" == root["post"]["comments"].object["email"].path
  }
  
  @Test()
  public void checkHitsList() {
    assert "post.hits" == root["post"]["hits"].path
  }

  @Test()
  public void checkHitsListField() {
    assert "post.hits._" == root["post"]["hits"].get().path
  }
}

