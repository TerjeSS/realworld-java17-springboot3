# TagsApi

All URIs are relative to */api*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getTags**](TagsApi.md#getTags) | **GET** /tags | Get tags |


<a name="getTags"></a>
# **getTags**
> GetTags200Response getTags()

Get tags

Get tags. Auth not required

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TagsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("/api");

    TagsApi apiInstance = new TagsApi(defaultClient);
    try {
      GetTags200Response result = apiInstance.getTags();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TagsApi#getTags");
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

[**GetTags200Response**](GetTags200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Tags |  -  |
| **422** | Unexpected error |  -  |

