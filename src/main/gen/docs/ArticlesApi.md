# ArticlesApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createArticle**](ArticlesApi.md#createArticle) | **POST** /articles | Create an article |
| [**deleteArticle**](ArticlesApi.md#deleteArticle) | **DELETE** /articles/{slug} | Delete an article |
| [**getArticle**](ArticlesApi.md#getArticle) | **GET** /articles/{slug} | Get an article |
| [**getArticles**](ArticlesApi.md#getArticles) | **GET** /articles | Get recent articles globally |
| [**getArticlesFeed**](ArticlesApi.md#getArticlesFeed) | **GET** /articles/feed | Get recent articles from users you follow |
| [**updateArticle**](ArticlesApi.md#updateArticle) | **PUT** /articles/{slug} | Update an article |


<a name="createArticle"></a>
# **createArticle**
> CreateArticle201Response createArticle(article)

Create an article

Create an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    CreateArticleRequest article = new CreateArticleRequest(); // CreateArticleRequest | Article to create
    try {
      CreateArticle201Response result = apiInstance.createArticle(article);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#createArticle");
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
| **article** | [**CreateArticleRequest**](CreateArticleRequest.md)| Article to create | |

### Return type

[**CreateArticle201Response**](CreateArticle201Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Single article |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="deleteArticle"></a>
# **deleteArticle**
> deleteArticle(slug)

Delete an article

Delete an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article to delete
    try {
      apiInstance.deleteArticle(slug);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#deleteArticle");
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
| **slug** | **String**| Slug of the article to delete | |

### Return type

null (empty response body)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | No content |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="getArticle"></a>
# **getArticle**
> CreateArticle201Response getArticle(slug)

Get an article

Get an article. Auth not required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article to get
    try {
      CreateArticle201Response result = apiInstance.getArticle(slug);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#getArticle");
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
| **slug** | **String**| Slug of the article to get | |

### Return type

[**CreateArticle201Response**](CreateArticle201Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Single article |  -  |
| **422** | Unexpected error |  -  |

<a name="getArticles"></a>
# **getArticles**
> GetArticlesFeed200Response getArticles(tag, author, favorited, offset, limit)

Get recent articles globally

Get most recent articles globally. Use query parameters to filter results. Auth is optional

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    String tag = "tag_example"; // String | Filter by tag
    String author = "author_example"; // String | Filter by author (username)
    String favorited = "favorited_example"; // String | Filter by favorites of a user (username)
    Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
    Integer limit = 20; // Integer | The numbers of items to return.
    try {
      GetArticlesFeed200Response result = apiInstance.getArticles(tag, author, favorited, offset, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#getArticles");
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
| **tag** | **String**| Filter by tag | [optional] |
| **author** | **String**| Filter by author (username) | [optional] |
| **favorited** | **String**| Filter by favorites of a user (username) | [optional] |
| **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] |
| **limit** | **Integer**| The numbers of items to return. | [optional] [default to 20] |

### Return type

[**GetArticlesFeed200Response**](GetArticlesFeed200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Multiple articles |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="getArticlesFeed"></a>
# **getArticlesFeed**
> GetArticlesFeed200Response getArticlesFeed(offset, limit)

Get recent articles from users you follow

Get most recent articles from users you follow. Use query parameters to limit. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    Integer offset = 56; // Integer | The number of items to skip before starting to collect the result set.
    Integer limit = 20; // Integer | The numbers of items to return.
    try {
      GetArticlesFeed200Response result = apiInstance.getArticlesFeed(offset, limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#getArticlesFeed");
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
| **offset** | **Integer**| The number of items to skip before starting to collect the result set. | [optional] |
| **limit** | **Integer**| The numbers of items to return. | [optional] [default to 20] |

### Return type

[**GetArticlesFeed200Response**](GetArticlesFeed200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Multiple articles |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="updateArticle"></a>
# **updateArticle**
> CreateArticle201Response updateArticle(slug, article)

Update an article

Update an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ArticlesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ArticlesApi apiInstance = new ArticlesApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article to update
    UpdateArticleRequest article = new UpdateArticleRequest(); // UpdateArticleRequest | Article to update
    try {
      CreateArticle201Response result = apiInstance.updateArticle(slug, article);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ArticlesApi#updateArticle");
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
| **slug** | **String**| Slug of the article to update | |
| **article** | [**UpdateArticleRequest**](UpdateArticleRequest.md)| Article to update | |

### Return type

[**CreateArticle201Response**](CreateArticle201Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Single article |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

