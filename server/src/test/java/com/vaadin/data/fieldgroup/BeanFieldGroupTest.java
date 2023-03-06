/*
 * Copyright (C) 2000-2023 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.data.fieldgroup;

import org.junit.Assert;
import org.junit.Test;

public class BeanFieldGroupTest {

    class Main {
        private String mainField;

        public String getMainField() {
            return mainField;
        }

        public void setMainField(String mainField) {
            this.mainField = mainField;
        }

    }

    class Sub1 extends Main {
        private Integer sub1Field;

        public Integer getSub1Field() {
            return sub1Field;
        }

        public void setSub1Field(Integer sub1Field) {
            this.sub1Field = sub1Field;
        }

    }

    class Sub2 extends Sub1 {
        private boolean sub2field;

        public boolean isSub2field() {
            return sub2field;
        }

        public void setSub2field(boolean sub2field) {
            this.sub2field = sub2field;
        }

    }

    @Test
    public void propertyTypeWithoutItem() {
        BeanFieldGroup<Sub2> s = new BeanFieldGroup<BeanFieldGroupTest.Sub2>(
                Sub2.class);
        Assert.assertEquals(boolean.class, s.getPropertyType("sub2field"));
        Assert.assertEquals(Integer.class, s.getPropertyType("sub1Field"));
        Assert.assertEquals(String.class, s.getPropertyType("mainField"));
    }
}
