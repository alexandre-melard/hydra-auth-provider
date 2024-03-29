package com.richemont.sso.authprovider.client;

import com.richemont.sso.authprovider.dto.consent.ConsentAcceptRequest;
import com.richemont.sso.authprovider.dto.consent.ConsentAcceptResponse;
import com.richemont.sso.authprovider.dto.consent.ConsentResponse;
import com.richemont.sso.authprovider.dto.login.LoginAcceptRequest;
import com.richemont.sso.authprovider.dto.login.LoginAcceptResponse;
import com.richemont.sso.authprovider.dto.login.LoginResponse;
import com.richemont.sso.authprovider.dto.logout.LogoutAcceptRequest;
import com.richemont.sso.authprovider.dto.logout.LogoutAcceptResponse;
import com.richemont.sso.authprovider.dto.logout.LogoutResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The HTTP client interface that models the inveni store API
 */
@FeignClient(value = "${sso.hydra.name}",
        url = "${sso.hydra.base-url}")
public interface AuthClient {

    /**
     *  Fetches information on a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "${sso.hydra.endpoints.loginRequest}")
    LoginResponse loginRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.loginAcceptRequest}")
    LoginAcceptResponse loginAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final LoginAcceptRequest body);

    /**
     *  Rejects a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.loginRejectRequest}")
    ResponseEntity<String> loginRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);

    /**
     *  Fetches information on a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "${sso.hydra.endpoints.consentRequest}")
    ConsentResponse consentRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a consent request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.consentAcceptRequest}")
    ConsentAcceptResponse consentAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final ConsentAcceptRequest body);

    /**
     *  Rejects a consent request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.consentRejectRequest}")
    ResponseEntity<String> consentRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);

    /**
     *  Fetches information on a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "${sso.hydra.endpoints.logoutRequest}")
    LogoutResponse logoutRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.logoutAcceptRequest}")
    LogoutAcceptResponse logoutAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final LogoutAcceptRequest body);

    /**
     *  Reject a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "${sso.hydra.endpoints.logoutRejectRequest}")
    ResponseEntity<String> logoutRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);
}
