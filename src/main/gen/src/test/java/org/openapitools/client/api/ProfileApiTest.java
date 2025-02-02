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


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.GenericErrorModel;
import org.openapitools.client.model.GetProfileByUsername200Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProfileApi
 */
@Disabled
public class ProfileApiTest {

    private final ProfileApi api = new ProfileApi();

    /**
     * Follow a user
     *
     * Follow a user by username
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void followUserByUsernameTest() throws ApiException {
        String username = null;
        GetProfileByUsername200Response response = api.followUserByUsername(username);
        // TODO: test validations
    }

    /**
     * Get a profile
     *
     * Get a profile of a user of the system. Auth is optional
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getProfileByUsernameTest() throws ApiException {
        String username = null;
        GetProfileByUsername200Response response = api.getProfileByUsername(username);
        // TODO: test validations
    }

    /**
     * Unfollow a user
     *
     * Unfollow a user by username
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void unfollowUserByUsernameTest() throws ApiException {
        String username = null;
        GetProfileByUsername200Response response = api.unfollowUserByUsername(username);
        // TODO: test validations
    }

}
