# CommentsApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createArticleComment**](CommentsApi.md#createArticleComment) | **POST** /articles/{slug}/comments | Create a comment for an article |
| [**deleteArticleComment**](CommentsApi.md#deleteArticleComment) | **DELETE** /articles/{slug}/comments/{id} | Delete a comment for an article |
| [**getArticleComments**](CommentsApi.md#getArticleComments) | **GET** /articles/{slug}/comments | Get comments for an article |


<a name="createArticleComment"></a>
# **createArticleComment**
> CreateArticleComment200Response createArticleComment(slug, comment)

Create a comment for an article

Create a comment for an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article that you want to create a comment for
    CreateArticleCommentRequest comment = new CreateArticleCommentRequest(); // CreateArticleCommentRequest | Comment you want to create
    try {
      CreateArticleComment200Response result = apiInstance.createArticleComment(slug, comment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#createArticleComment");
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
| **slug** | **String**| Slug of the article that you want to create a comment for | |
| **comment** | [**CreateArticleCommentRequest**](CreateArticleCommentRequest.md)| Comment you want to create | |

### Return type

[**CreateArticleComment200Response**](CreateArticleComment200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Single comment |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="deleteArticleComment"></a>
# **deleteArticleComment**
> deleteArticleComment(slug, id)

Delete a comment for an article

Delete a comment for an article. Auth is required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article that you want to delete a comment for
    Integer id = 56; // Integer | ID of the comment you want to delete
    try {
      apiInstance.deleteArticleComment(slug, id);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#deleteArticleComment");
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
| **slug** | **String**| Slug of the article that you want to delete a comment for | |
| **id** | **Integer**| ID of the comment you want to delete | |

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

<a name="getArticleComments"></a>
# **getArticleComments**
> GetArticleComments200Response getArticleComments(slug)

Get comments for an article

Get the comments for an article. Auth is optional

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CommentsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    CommentsApi apiInstance = new CommentsApi(defaultClient);
    String slug = "slug_example"; // String | Slug of the article that you want to get comments for
    try {
      GetArticleComments200Response result = apiInstance.getArticleComments(slug);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CommentsApi#getArticleComments");
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
| **slug** | **String**| Slug of the article that you want to get comments for | |

### Return type

[**GetArticleComments200Response**](GetArticleComments200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Multiple comments |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

