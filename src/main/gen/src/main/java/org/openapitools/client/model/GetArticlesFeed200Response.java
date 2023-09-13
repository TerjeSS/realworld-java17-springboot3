/*
 * Conduit API
 * Conduit API documentation
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Article;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * GetArticlesFeed200Response
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-09-08T10:52:50.766697700+02:00[Europe/Oslo]")
public class GetArticlesFeed200Response {
  public static final String SERIALIZED_NAME_ARTICLES = "articles";
  @SerializedName(SERIALIZED_NAME_ARTICLES)
  private List<Article> articles = new ArrayList<>();

  public static final String SERIALIZED_NAME_ARTICLES_COUNT = "articlesCount";
  @SerializedName(SERIALIZED_NAME_ARTICLES_COUNT)
  private Integer articlesCount;

  public GetArticlesFeed200Response() {
  }

  public GetArticlesFeed200Response articles(List<Article> articles) {
    
    this.articles = articles;
    return this;
  }

  public GetArticlesFeed200Response addArticlesItem(Article articlesItem) {
    this.articles.add(articlesItem);
    return this;
  }

   /**
   * Get articles
   * @return articles
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public List<Article> getArticles() {
    return articles;
  }


  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }


  public GetArticlesFeed200Response articlesCount(Integer articlesCount) {
    
    this.articlesCount = articlesCount;
    return this;
  }

   /**
   * Get articlesCount
   * @return articlesCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")

  public Integer getArticlesCount() {
    return articlesCount;
  }


  public void setArticlesCount(Integer articlesCount) {
    this.articlesCount = articlesCount;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetArticlesFeed200Response getArticlesFeed200Response = (GetArticlesFeed200Response) o;
    return Objects.equals(this.articles, getArticlesFeed200Response.articles) &&
        Objects.equals(this.articlesCount, getArticlesFeed200Response.articlesCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(articles, articlesCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetArticlesFeed200Response {\n");
    sb.append("    articles: ").append(toIndentedString(articles)).append("\n");
    sb.append("    articlesCount: ").append(toIndentedString(articlesCount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("articles");
    openapiFields.add("articlesCount");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("articles");
    openapiRequiredFields.add("articlesCount");
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to GetArticlesFeed200Response
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (GetArticlesFeed200Response.openapiRequiredFields.isEmpty()) {
          return;
        } else { // has required fields
          throw new IllegalArgumentException(String.format("The required field(s) %s in GetArticlesFeed200Response is not found in the empty JSON string", GetArticlesFeed200Response.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!GetArticlesFeed200Response.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `GetArticlesFeed200Response` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }

      // check to make sure all required properties/fields are present in the JSON string
      for (String requiredField : GetArticlesFeed200Response.openapiRequiredFields) {
        if (jsonObj.get(requiredField) == null) {
          throw new IllegalArgumentException(String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonObj.toString()));
        }
      }
      if (jsonObj.get("articles") != null && !jsonObj.get("articles").isJsonNull()) {
        JsonArray jsonArrayarticles = jsonObj.getAsJsonArray("articles");
        if (jsonArrayarticles != null) {
          // ensure the json data is an array
          if (!jsonObj.get("articles").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `articles` to be an array in the JSON string but got `%s`", jsonObj.get("articles").toString()));
          }

          // validate the optional field `articles` (array)
          for (int i = 0; i < jsonArrayarticles.size(); i++) {
            Article.validateJsonObject(jsonArrayarticles.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!GetArticlesFeed200Response.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'GetArticlesFeed200Response' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<GetArticlesFeed200Response> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(GetArticlesFeed200Response.class));

       return (TypeAdapter<T>) new TypeAdapter<GetArticlesFeed200Response>() {
           @Override
           public void write(JsonWriter out, GetArticlesFeed200Response value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public GetArticlesFeed200Response read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of GetArticlesFeed200Response given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of GetArticlesFeed200Response
  * @throws IOException if the JSON string is invalid with respect to GetArticlesFeed200Response
  */
  public static GetArticlesFeed200Response fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, GetArticlesFeed200Response.class);
  }

 /**
  * Convert an instance of GetArticlesFeed200Response to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

