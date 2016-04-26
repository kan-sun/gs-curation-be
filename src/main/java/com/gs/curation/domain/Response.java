
package com.gs.curation.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "numFound",
    "start",
    "docs"
})
public final class Response {

    @JsonProperty("numFound")
    private final Long numFound;
    @JsonProperty("start")
    private final Long start;
    @JsonProperty("docs")
    private final List<Doc> docs;

    private Response() {
        this(newBuilder());
    }

    private Response(Builder builder) {
        numFound = builder.numFound;
        start = builder.start;
        docs = builder.docs == null ? new ArrayList<>() : builder.docs;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getStart() {
        return start;
    }

    public Long getNumFound() {
        return numFound;
    }

    public List<Doc> getDocs() {
        return Collections.unmodifiableList(docs);
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
        Response rhs = (Response) obj;
        return new EqualsBuilder()
                .append(this.numFound, rhs.numFound)
                .append(this.start, rhs.start)
                .append(this.docs, rhs.docs)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(numFound)
                .append(start)
                .append(docs)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("numFound", numFound)
                .append("start", start)
                .append("docs", docs)
                .toString();
    }

    public static final class Builder {
        private Long numFound;
        private Long start;
        private List<Doc> docs;

        private Builder() {
        }

        public Builder withNumFound(Long val) {
            numFound = val;
            return this;
        }

        public Builder withStart(Long val) {
            start = val;
            return this;
        }

        public Builder withDocs(List<Doc> docs) {
            this.docs = docs;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
