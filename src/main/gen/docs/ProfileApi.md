# ProfileApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**followUserByUsername**](ProfileApi.md#followUserByUsername) | **POST** /profiles/{username}/follow | Follow a user |
| [**getProfileByUsername**](ProfileApi.md#getProfileByUsername) | **GET** /profiles/{username} | Get a profile |
| [**unfollowUserByUsername**](ProfileApi.md#unfollowUserByUsername) | **DELETE** /profiles/{username}/follow | Unfollow a user |


<a name="followUserByUsername"></a>
# **followUserByUsername**
> GetProfileByUsername200Response followUserByUsername(username)

Follow a user

Follow a user by username

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ProfileApi apiInstance = new ProfileApi(defaultClient);
    String username = "username_example"; // String | Username of the profile you want to follow
    try {
      GetProfileByUsername200Response result = apiInstance.followUserByUsername(username);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProfileApi#followUserByUsername");
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
| **username** | **String**| Username of the profile you want to follow | |

### Return type

[**GetProfileByUsername200Response**](GetProfileByUsername200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Profile |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="getProfileByUsername"></a>
# **getProfileByUsername**
> GetProfileByUsername200Response getProfileByUsername(username)

Get a profile

Get a profile of a user of the system. Auth is optional

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    ProfileApi apiInstance = new ProfileApi(defaultClient);
    String username = "username_example"; // String | Username of the profile to get
    try {
      GetProfileByUsername200Response result = apiInstance.getProfileByUsername(username);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProfileApi#getProfileByUsername");
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
| **username** | **String**| Username of the profile to get | |

### Return type

[**GetProfileByUsername200Response**](GetProfileByUsername200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Profile |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="unfollowUserByUsername"></a>
# **unfollowUserByUsername**
> GetProfileByUsername200Response unfollowUserByUsername(username)

Unfollow a user

Unfollow a user by username

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ProfileApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    ProfileApi apiInstance = new ProfileApi(defaultClient);
    String username = "username_example"; // String | Username of the profile you want to unfollow
    try {
      GetProfileByUsername200Response result = apiInstance.unfollowUserByUsername(username);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProfileApi#unfollowUserByUsername");
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
| **username** | **String**| Username of the profile you want to unfollow | |

### Return type

[**GetProfileByUsername200Response**](GetProfileByUsername200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Profile |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

