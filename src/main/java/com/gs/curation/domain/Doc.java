
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
    "title_en",
    "id",
    "author_en",
    "publicationDateTime",
    "w_Equity",
    "w_Macro",
    "w_US",
    "w_Asia",
    "w_Europe",
    "w_Emerging Markets",
    "w_~Popularity",
    "w_Commodity",
    "industry_en",
    "region",
    "w_Japan"
})
public class Doc {

    @JsonProperty("title_en")
    private final String titleEn;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("author_en")
    private final List<String> authorEn;
    @JsonProperty("publicationDateTime")
    private final String publicationDateTime;
    @JsonProperty("w_Equity")
    private final Long wEquity;
    @JsonProperty("w_Macro")
    private final Long wMacro;
    @JsonProperty("w_US")
    private final Long wUS;
    @JsonProperty("w_Asia")
    private final Long wAsia;
    @JsonProperty("w_Europe")
    private final Long wEurope;
    @JsonProperty("w_Emerging Markets")
    private final Long wEmergingMarkets;
    @JsonProperty("w_~Popularity")
    private final Long wPopularity;
    @JsonProperty("w_Commodity")
    private final Long wCommodity;
    @JsonProperty("industry_en")
    private final List<String> industryEn;
    @JsonProperty("region")
    private final List<String> region;
    @JsonProperty("w_Japan")
    private final Long wJapan;

    private Doc() {
        this(newBuilder());
    }

    private Doc(Builder builder) {
        titleEn = builder.titleEn;
        id = builder.id;
        authorEn = builder.authorEn == null ? new ArrayList<>() : builder.authorEn;
        publicationDateTime = builder.publicationDateTime;
        wEquity = builder.wEquity;
        wMacro = builder.wMacro;
        wUS = builder.wUS;
        wAsia = builder.wAsia;
        wEurope = builder.wEurope;
        wEmergingMarkets = builder.wEmergingMarkets;
        wPopularity = builder.wPopularity;
        wCommodity = builder.wCommodity;
        industryEn = builder.industryEn == null ? new ArrayList<>() : builder.industryEn;
        region = builder.region == null ? new ArrayList<>() : builder.region;
        wJapan = builder.wJapan;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public String getId() {
        return id;
    }

    public List<String> getAuthorEn() {
        return Collections.unmodifiableList(authorEn);
    }

    public String getPublicationDateTime() {
        return publicationDateTime;
    }

    public Long getwEquity() {
        return wEquity;
    }

    public Long getwMacro() {
        return wMacro;
    }

    public Long getwUS() {
        return wUS;
    }

    public Long getwAsia() {
        return wAsia;
    }

    public Long getwEurope() {
        return wEurope;
    }

    public Long getwEmergingMarkets() {
        return wEmergingMarkets;
    }

    public Long getwPopularity() {
        return wPopularity;
    }

    public Long getwCommodity() {
        return wCommodity;
    }

    public List<String> getIndustryEn() {
        return Collections.unmodifiableList(industryEn);
    }

    public List<String> getRegion() {
        return Collections.unmodifiableList(region);
    }

    public Long getwJapan() {
        return wJapan;
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
        Doc rhs = (Doc) obj;
        return new EqualsBuilder()
                .append(this.titleEn, rhs.titleEn)
                .append(this.id, rhs.id)
                .append(this.authorEn, rhs.authorEn)
                .append(this.publicationDateTime, rhs.publicationDateTime)
                .append(this.wEquity, rhs.wEquity)
                .append(this.wMacro, rhs.wMacro)
                .append(this.wUS, rhs.wUS)
                .append(this.wAsia, rhs.wAsia)
                .append(this.wEurope, rhs.wEurope)
                .append(this.wEmergingMarkets, rhs.wEmergingMarkets)
                .append(this.wPopularity, rhs.wPopularity)
                .append(this.wCommodity, rhs.wCommodity)
                .append(this.industryEn, rhs.industryEn)
                .append(this.region, rhs.region)
                .append(this.wJapan, rhs.wJapan)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(titleEn)
                .append(id)
                .append(authorEn)
                .append(publicationDateTime)
                .append(wEquity)
                .append(wMacro)
                .append(wUS)
                .append(wAsia)
                .append(wEurope)
                .append(wEmergingMarkets)
                .append(wPopularity)
                .append(wCommodity)
                .append(industryEn)
                .append(region)
                .append(wJapan)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("titleEn", titleEn)
                .append("id", id)
                .append("authorEn", authorEn)
                .append("publicationDateTime", publicationDateTime)
                .append("wEquity", wEquity)
                .append("wMacro", wMacro)
                .append("wUS", wUS)
                .append("wAsia", wAsia)
                .append("wEurope", wEurope)
                .append("wEmergingMarkets", wEmergingMarkets)
                .append("wPopularity", wPopularity)
                .append("wCommodity", wCommodity)
                .append("industryEn", industryEn)
                .append("region", region)
                .append("wJapan", wJapan)
                .toString();
    }


    public static final class Builder {
        private String titleEn;
        private String id;
        private List<String> authorEn;
        private String publicationDateTime;
        private Long wEquity;
        private Long wMacro;
        private Long wUS;
        private Long wAsia;
        private Long wEurope;
        private Long wEmergingMarkets;
        private Long wPopularity;
        private Long wCommodity;
        private List<String> industryEn;
        private List<String> region;
        private Long wJapan;

        private Builder() {
        }

        public Builder withTitleEn(String val) {
            titleEn = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withAuthorEn(List<String> val) {
            authorEn = val;
            return this;
        }

        public Builder withPublicationDateTime(String val) {
            publicationDateTime = val;
            return this;
        }

        public Builder withWEquity(Long val) {
            wEquity = val;
            return this;
        }

        public Builder withWMacro(Long val) {
            wMacro = val;
            return this;
        }

        public Builder withWUS(Long val) {
            wUS = val;
            return this;
        }

        public Builder withWAsia(Long val) {
            wAsia = val;
            return this;
        }

        public Builder withWEurope(Long val) {
            wEurope = val;
            return this;
        }

        public Builder withWEmergingMarkets(Long val) {
            wEmergingMarkets = val;
            return this;
        }

        public Builder withWPopularity(Long val) {
            wPopularity = val;
            return this;
        }

        public Builder withWCommodity(Long val) {
            wCommodity = val;
            return this;
        }

        public Builder withIndustryEn(List<String> val) {
            industryEn = val;
            return this;
        }

        public Builder withRegion(List<String> val) {
            region = val;
            return this;
        }

        public Builder withWJapan(Long val) {
            wJapan = val;
            return this;
        }

        public Doc build() {
            return new Doc(this);
        }
    }
}
