
package com.gs.curation.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fl",
    "q",
    "wt",
    "fq",
    "rows"
})
public final class Params {

    @JsonProperty("fl")
    private final String fl;
    @JsonProperty("q")
    private final String q;
    @JsonProperty("wt")
    private final String wt;
    @JsonProperty("fq")
    private final String fq;
    @JsonProperty("rows")
    private final String rows;

    public String getFl() {
        return fl;
    }

    public String getQ() {
        return q;
    }

    public String getWt() {
        return wt;
    }

    public String getFq() {
        return fq;
    }

    public String getRows() {
        return rows;
    }

    private Params() {
        this(newBuilder());
    }

    private Params(Builder builder) {
        fl = builder.fl;
        q = builder.q;
        wt = builder.wt;
        fq = builder.fq;
        rows = builder.rows;
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
        Params rhs = (Params) obj;
        return new EqualsBuilder()
                .append(this.fl, rhs.fl)
                .append(this.q, rhs.q)
                .append(this.wt, rhs.wt)
                .append(this.fq, rhs.fq)
                .append(this.rows, rhs.rows)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(fl)
                .append(q)
                .append(wt)
                .append(fq)
                .append(rows)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("fl", fl)
                .append("q", q)
                .append("wt", wt)
                .append("fq", fq)
                .append("rows", rows)
                .toString();
    }


    public static final class Builder {
        private String fl;
        private String q;
        private String wt;
        private String fq;
        private String rows;

        private Builder() {
        }

        public Builder withFl(String val) {
            fl = val;
            return this;
        }

        public Builder withQ(String val) {
            q = val;
            return this;
        }

        public Builder withWt(String val) {
            wt = val;
            return this;
        }

        public Builder withFq(String val) {
            fq = val;
            return this;
        }

        public Builder withRows(String val) {
            rows = val;
            return this;
        }

        public Params build() {
            return new Params(this);
        }
    }
}
