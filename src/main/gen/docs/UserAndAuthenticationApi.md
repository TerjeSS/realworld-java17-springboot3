# UserAndAuthenticationApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createUser**](UserAndAuthenticationApi.md#createUser) | **POST** /users |  |
| [**getCurrentUser**](UserAndAuthenticationApi.md#getCurrentUser) | **GET** /user | Get current user |
| [**login**](UserAndAuthenticationApi.md#login) | **POST** /users/login | Existing user login |
| [**updateCurrentUser**](UserAndAuthenticationApi.md#updateCurrentUser) | **PUT** /user | Update current user |


<a name="createUser"></a>
# **createUser**
> Login200Response createUser(body)



Register a new user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserAndAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    UserAndAuthenticationApi apiInstance = new UserAndAuthenticationApi(defaultClient);
    CreateUserRequest body = new CreateUserRequest(); // CreateUserRequest | Details of the new user to register
    try {
      Login200Response result = apiInstance.createUser(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAndAuthenticationApi#createUser");
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
| **body** | [**CreateUserRequest**](CreateUserRequest.md)| Details of the new user to register | |

### Return type

[**Login200Response**](Login200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | User |  -  |
| **422** | Unexpected error |  -  |

<a name="getCurrentUser"></a>
# **getCurrentUser**
> Login200Response getCurrentUser()

Get current user

Gets the currently logged-in user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserAndAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    UserAndAuthenticationApi apiInstance = new UserAndAuthenticationApi(defaultClient);
    try {
      Login200Response result = apiInstance.getCurrentUser();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAndAuthenticationApi#getCurrentUser");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Login200Response**](Login200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="login"></a>
# **login**
> Login200Response login(body)

Existing user login

Login for existing user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserAndAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    UserAndAuthenticationApi apiInstance = new UserAndAuthenticationApi(defaultClient);
    LoginRequest body = new LoginRequest(); // LoginRequest | Credentials to use
    try {
      Login200Response result = apiInstance.login(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAndAuthenticationApi#login");
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
| **body** | [**LoginRequest**](LoginRequest.md)| Credentials to use | |

### Return type

[**Login200Response**](Login200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

<a name="updateCurrentUser"></a>
# **updateCurrentUser**
> Login200Response updateCurrentUser(body)

Update current user

Updated user information for current user

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.auth.*;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserAndAuthenticationApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");
    
    // Configure API key authorization: Token
    ApiKeyAuth Token = (ApiKeyAuth) defaultClient.getAuthentication("Token");
    Token.setApiKey("YOUR API KEY");
    // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
    //Token.setApiKeyPrefix("Token");

    UserAndAuthenticationApi apiInstance = new UserAndAuthenticationApi(defaultClient);
    UpdateCurrentUserRequest body = new UpdateCurrentUserRequest(); // UpdateCurrentUserRequest | User details to update. At least **one** field is required.
    try {
      Login200Response result = apiInstance.updateCurrentUser(body);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserAndAuthenticationApi#updateCurrentUser");
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
| **body** | [**UpdateCurrentUserRequest**](UpdateCurrentUserRequest.md)| User details to update. At least **one** field is required. | |

### Return type

[**Login200Response**](Login200Response.md)

### Authorization

[Token](../README.md#Token)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | User |  -  |
| **401** | Unauthorized |  -  |
| **422** | Unexpected error |  -  |

