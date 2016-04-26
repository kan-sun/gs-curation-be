
package com.gs.curation.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "responseHeader",
    "response"
})
public final class CurationResponse {

    @JsonProperty("responseHeader")
    private final ResponseHeader responseHeader;
    @JsonProperty("response")
    private final Response response;

    private CurationResponse() {
        responseHeader = null;
        response = null;
    }

    public CurationResponse(ResponseHeader responseHeader, Response response) {
        this.responseHeader = responseHeader;
        this.response = response;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        CurationResponse rhs = (CurationResponse) obj;
        return new EqualsBuilder()
                .append(this.responseHeader, rhs.responseHeader)
                .append(this.response, rhs.response)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(responseHeader)
                .append(response)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("responseHeader", responseHeader)
                .append("response", response)
                .toString();
    }
}
