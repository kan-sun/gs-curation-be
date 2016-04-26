
package com.gs.curation.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "QTime",
    "params"
})
public final class ResponseHeader {

    @JsonProperty("status")
    private final Long status;
    @JsonProperty("QTime")
    private final Long QTime;
    @JsonProperty("params")
    private final Params params;

    private ResponseHeader() {
        this(newBuilder());
    }

    private ResponseHeader(Builder builder) {
        status = builder.status;
        QTime = builder.QTime;
        params = builder.params;
    }

    public Long getStatus() {
        return status;
    }

    public Long getQTime() {
        return QTime;
    }

    public Params getParams() {
        return params;
    }

    public static Builder newBuilder() {
        return new Builder();
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
        ResponseHeader rhs = (ResponseHeader) obj;
        return new EqualsBuilder()
                .append(this.status, rhs.status)
                .append(this.QTime, rhs.QTime)
                .append(this.params, rhs.params)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(status)
                .append(QTime)
                .append(params)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("QTime", QTime)
                .append("params", params)
                .toString();
    }

    public static final class Builder {
        private Long status;
        private Long QTime;
        private Params params;

        private Builder() {
        }

        public Builder withStatus(Long val) {
            status = val;
            return this;
        }

        public Builder withQTime(Long val) {
            QTime = val;
            return this;
        }

        public Builder withParams(Params val) {
            params = val;
            return this;
        }

        public ResponseHeader build() {
            return new ResponseHeader(this);
        }
    }
}
