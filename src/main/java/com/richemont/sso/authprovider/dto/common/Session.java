package com.richemont.sso.authprovider.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Session {
    @JsonProperty("access_token")
    private AccessToken accessToken;
    @JsonProperty("id_token")
    private IdToken idToken;
}
