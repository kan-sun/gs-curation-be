package com.gs.curation.domain;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * Created by kansun on 27/04/2016.
 */
public class DocTest extends EqualsHashCodeTestCase {

    public DocTest(String name) {
        super(name);
    }

    @Override
    protected Object createInstance() throws Exception {
        return Doc.newBuilder().withId("foo").build();
    }

    @Override
    protected Object createNotEqualInstance() throws Exception {
        return Doc.newBuilder().withId("Bar").build();
    }
}