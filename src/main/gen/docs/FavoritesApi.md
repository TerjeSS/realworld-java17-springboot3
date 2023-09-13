# FavoritesApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createArticleFavorite**](FavoritesApi.md#createArticleFavorite) | **POST** /articles/{slug}/favorite | Favorite an article |
| [**deleteArticleFavorite**](FavoritesApi.md#deleteArticleFavorite) | **DELETE** /articles/{slug}/favorite | Unfavorite an article |


<a name="createArticleFavorite"></a>
# **createArticleFavorite**
> CreateArticle201Response createArticleFavorite(slug)

Favorite an article

Favorite an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article that you want to favorite
    try {
      CreateArticle201Response result = apiInstance.createArticleFavorite(slug);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#createArticleFavorite");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **slug** | **String**| Slug of the article that you want to favorite | |

### Return type

[**CreateArticle201Response**](CreateArticle201Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Single article |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="deleteArticleFavorite"></a>
# **deleteArticleFavorite**
> CreateArticle201Response deleteArticleFavorite(slug)

Unfavorite an article

Unfavorite an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FavoritesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    FavoritesApi apiInstance = new FavoritesApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article that you want to unfavorite
    try {
      CreateArticle201Response result = apiInstance.deleteArticleFavorite(slug);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FavoritesApi#deleteArticleFavorite");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **slug** | **String**| Slug of the article that you want to unfavorite | |

### Return type

[**CreateArticle201Response**](CreateArticle201Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Single article |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

